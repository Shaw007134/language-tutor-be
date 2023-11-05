package com.zsy.language_tutor.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BeanUtil {

    public static <T> T fastCopy(Object source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }

        try {
            T target = targetClass.getDeclaredConstructor().newInstance();
            BeanWrapper sourceWrapper = new BeanWrapperImpl(source);
            BeanWrapper targetWrapper = new BeanWrapperImpl(target);

            for (PropertyDescriptor descriptor : sourceWrapper.getPropertyDescriptors()) {
                String propertyName = descriptor.getName();
                if (targetWrapper.isWritableProperty(propertyName) && sourceWrapper.isReadableProperty(propertyName)) {
                    Object value = sourceWrapper.getPropertyValue(propertyName);
                    targetWrapper.setPropertyValue(propertyName, value);
                }
            }

            return target;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Bean copy failed", e);
        }
    }
}

