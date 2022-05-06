package com.cydeer.spring.framework.web;

import com.cydeer.spring.framework.annotation.XzAutowired;
import com.cydeer.spring.framework.annotation.XzController;
import com.cydeer.spring.framework.annotation.XzRequestMapping;
import com.cydeer.spring.framework.annotation.XzService;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author song.z
 * @date 2022/5/5 21:49
 */
public class CydeerDispatchServlet extends HttpServlet {

    private Map<String, Object> map = new HashMap<>();

    private List<String> classNames = new ArrayList<>();

    private Map<String, Object> beans = new HashMap<>();

    private Map<String, Method> handlerMap = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, InvocationTargetException, IllegalAccessException {
        String requestPath = req.getRequestURI();
        String contextPath = req.getContextPath();
        requestPath = requestPath.replace(contextPath, "").replaceAll("/+", "/");
        if (!handlerMap.containsKey(requestPath)) {
            resp.getWriter().write(" 404 NOT FUND");
        }
        Method method = handlerMap.get(requestPath);
        method.invoke(beans.get(method.getDeclaringClass().getName()),
                      new Object[]{req, resp, req.getParameter("name")});
    }

    @Override
    public void init() {

        // 扫描 获取到对应的所有全限定类名
        doScan("com.cydeer.biz");

        // 初始化类，保存到beans中
        doInstance();

        // 依赖注入
        doAutowired();

        // 初始化 url和对应的method映射
        doInitHandlerMapping();
    }

    private void doInitHandlerMapping() {
        try {
            for (String className : classNames) {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(XzController.class)) {
                    String basePath = "";
                    if (clazz.isAnnotationPresent(XzRequestMapping.class)) {
                        XzRequestMapping xzRequestMapping = clazz.getAnnotation(XzRequestMapping.class);
                        basePath = xzRequestMapping.value();
                    }
                    Method[] methods = clazz.getMethods();
                    for (Method method : methods) {
                        if (!method.isAnnotationPresent(XzRequestMapping.class)) {
                            continue;
                        }
                        XzRequestMapping mapping = method.getAnnotation(XzRequestMapping.class);
                        String url = basePath + mapping.value();
                        handlerMap.put(url, method);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void doAutowired() {
        for (Object value : beans.values()) {
            if (value == null) {
                continue;
            }
            for (Field declaredField : value.getClass().getDeclaredFields()) {
                if (!declaredField.isAnnotationPresent(XzAutowired.class)) {
                    continue;
                }
                XzAutowired xzAutowired = declaredField.getAnnotation(XzAutowired.class);
                String autowiredBeanName = xzAutowired.value();
                if (!StringUtils.hasText(autowiredBeanName)) {
                    autowiredBeanName = declaredField.getType().getName();
                }
                declaredField.setAccessible(true);
                try {
                    declaredField.set(beans.get(value.getClass().getName()), beans.get(autowiredBeanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doInstance() {
        try {
            for (String className : classNames) {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(XzController.class)) {
                    beans.put(className, clazz.newInstance());
                }
                if (clazz.isAnnotationPresent(XzService.class)) {
                    XzService xzService = clazz.getAnnotation(XzService.class);
                    String beanName = xzService.value();
                    if (!StringUtils.hasText(beanName)) {
                        beanName = clazz.getName();
                    }
                    Object instance = clazz.newInstance();
                    beans.put(beanName, instance);
                    for (Class<?> anInterface : clazz.getInterfaces()) {
                        beans.put(anInterface.getName(), instance);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private void doScan(String packageName) {
        URL url = this.getClass().getClassLoader().getResource("/" + packageName.replaceAll("\\.", "/"));
        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()) {
            if (file.isDirectory()) {
                doScan(packageName + "." + file.getName());
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + "." + file.getName().replace(".class", "");
                classNames.add(className);
            }
        }
    }
}
