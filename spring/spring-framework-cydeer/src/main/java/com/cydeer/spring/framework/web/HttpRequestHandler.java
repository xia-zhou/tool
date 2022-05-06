package com.cydeer.spring.framework.web;

import com.cydeer.spring.framework.annotation.XzRequestParam;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author song.z
 * @date 2022/5/6 18:14
 */
public class HttpRequestHandler {
    private Object controllerBeans;

    private Method method;

    private Pattern pattern;

    private Map<String, Integer> paramsIndexMapping;

    public HttpRequestHandler(Object controllerBeans, Method method, Pattern pattern) {
        this.controllerBeans = controllerBeans;
        this.method = method;
        this.pattern = pattern;
        this.paramsIndexMapping = buildParamsIndexMapping(method);
    }

    private Map<String, Integer> buildParamsIndexMapping(Method method) {
        Map<String, Integer> mapping = new HashMap<>();
        Annotation[][] annotations = method.getParameterAnnotations();
        for (int j = 0; j < annotations.length; j++) {
            Annotation[] paramAnnotations = annotations[j];
            for (Annotation a : paramAnnotations) {
                if (a instanceof XzRequestParam) {
                    String paramName = ((XzRequestParam) a).value();
                    if (StringUtils.hasText(paramName)) {
                        mapping.put(paramName, j);
                    }
                }
            }
        }
        Class<?>[] paramsTypes = method.getParameterTypes();
        for (int i = 0; i < paramsTypes.length; i++) {
            Class<?> paramsType = paramsTypes[i];
            if (paramsType == HttpServletRequest.class || paramsType == HttpServletResponse.class) {
                mapping.put(paramsType.getName(), i);
            }
        }
        return mapping;
    }

    public Object getControllerBeans() {
        return controllerBeans;
    }

    public Method getMethod() {
        return method;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public Map<String, Integer> getParamsIndexMapping() {
        return paramsIndexMapping;
    }
}
