package com.freeit.lesson16.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PhoneRunner {

    private static final String NOT_SECRET = "Telephone is not encrypted )) Use it for your own";

    public static void main(String[] args) throws Exception {
        annotationsAnalizator(Telephone.class);
    }

    private static void annotationsAnalizator(Class<? extends Object> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        boolean annotationPresent = clazz.isAnnotationPresent(NotSecretPhone.class);
        if (!annotationPresent) {
            System.out.println(NOT_SECRET);
        } else {
            NotSecretPhone notSecretAnnotation = clazz.getAnnotation(NotSecretPhone.class);
            boolean secret = notSecretAnnotation.secret();
            if (secret) {
                System.out.println("THis telephone is totally secret. Sorry :)");
                Method[] methods = clazz.getDeclaredMethods();
                for (Method m : methods) {
                    if (m.isAnnotationPresent(PhoneIsGenerallyAvailable.class)) {
                        PhoneIsGenerallyAvailable isGA = m.getAnnotation(PhoneIsGenerallyAvailable.class);
                        if (isGA.available()) {
                            Constructor<?> constructor = clazz.getConstructor(String.class);
                            Telephone phone = (Telephone) constructor.newInstance("iphone 13 pro");
                            m.setAccessible(true);
                            m.invoke(phone);
                        } else {
                            System.out.println("Phone is not GA");
                        }
                    }
                }

            } else {
                System.out.println(NOT_SECRET);
            }
        }
    }

}