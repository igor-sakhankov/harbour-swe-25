package com.harbour;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InjectByTypeConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object object) {
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                field.set(object, ObjectFactory.getInstance().createObject(field.getType()));
            }
        }
    }

}
