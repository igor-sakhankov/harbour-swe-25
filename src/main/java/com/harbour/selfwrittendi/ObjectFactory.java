package com.harbour.selfwrittendi;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

public class ObjectFactory {

    private static final ObjectFactory objectFactory = new ObjectFactory();
    private Reflections scanner = new Reflections("com.harbour");

    public static ObjectFactory getInstance() {
        return objectFactory;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> classOfObject) {
        if (classOfObject.isInterface()) {
            var implementationClass = (Class<T>) scanner.getSubTypesOf(classOfObject).stream().findFirst().get();
            T andConfigureInstance = createAndConfigureInstance(implementationClass);
            return andConfigureInstance;
        }
        return createAndConfigureInstance(classOfObject);
    }

    private <T> T createAndConfigureInstance(Class<T> maybeInterface) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Object object = Arrays.stream(maybeInterface.getDeclaredConstructors()).findFirst().get().newInstance();
        configure(object);
        return (T) object;
    }

    @SneakyThrows
    private void configure(Object object) {
        Set<Class<? extends ObjectConfigurator>> subTypesOf = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> type : subTypesOf) {
            ObjectConfigurator objectConfigurator = type.getDeclaredConstructor().newInstance();
            objectConfigurator.configure(object);
        }
    }

}
