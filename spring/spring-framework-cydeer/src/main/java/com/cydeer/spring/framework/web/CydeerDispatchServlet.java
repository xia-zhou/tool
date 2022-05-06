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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author song.z
 * @date 2022/5/5 21:49
 */
public class CydeerDispatchServlet extends HttpServlet {

    private Map<String, Object> map = new HashMap<>();

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
        if (!map.containsKey(requestPath)) {
            resp.getWriter().write(" 404 NOT FUND");
        }
        Method method = (Method) map.get(requestPath);
        method.invoke(map.get(method.getDeclaringClass().getName()), new Object[]{req, resp, req.getParameter("name")});
    }

    @Override
    public void init() throws ServletException {
        doScan("com.cydeer.biz");
        try {
            Set<String> set = new HashSet<>(map.keySet());
            for (String className : set) {
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
                        map.put(url, method);
                    }
                    map.put(className, clazz.newInstance());
                }
                if (clazz.isAnnotationPresent(XzService.class)) {
                    XzService xzService = clazz.getAnnotation(XzService.class);
                    String beanName = xzService.value();
                    if (!StringUtils.hasText(beanName)) {
                        beanName = clazz.getName();
                    }
                    Object instance = clazz.newInstance();
                    map.put(beanName, instance);
                    for (Class<?> anInterface : clazz.getInterfaces()) {
                        map.put(anInterface.getName(), instance);
                    }
                }
            }

        } catch (Exception e) {

        }
        for (Object value : map.values()) {
            if (value == null) {
                continue;
            }
            if (!value.getClass().isAnnotationPresent(XzController.class)) {
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
                    declaredField.set(map.get(value.getClass().getName()), map.get(autowiredBeanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
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
                map.put(className, null);
            }
        }
    }
}
