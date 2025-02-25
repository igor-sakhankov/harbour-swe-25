package com.harbour;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ObjectFactory {

    private static final ObjectFactory objectFactory = new ObjectFactory();
    private Reflections scanner = new Reflections("com.harbour");

    public static ObjectFactory getInstance() {
        return objectFactory;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> classOfObject) {
        if(classOfObject.isInterface()) {
            var implementationClass = (Class<T>) scanner.getSubTypesOf(classOfObject).stream().findFirst().get();
            return createInstance(implementationClass);
        }
        return createInstance(classOfObject);
    }

    private <T> T createInstance(Class<T> maybeInterface) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        return (T) Arrays.stream(maybeInterface.getDeclaredConstructors()).findFirst().get().newInstance();
    }
}
