package ru.ncedu.java.tasks;

import java.lang.reflect.*;
import java.util.*;

/**
 * Created by Alimantu on 04/11/15.
 */
public class ReflectionsImpl implements Reflections {

    private void checkNull(Object... objects) {
        for (Object object : objects) {
            if (object == null) {
                throw new NullPointerException();
            }
        }
    }

    @Override
    public Object getFieldValueByName(Object object, String fieldName) throws NoSuchFieldException {
        checkNull(object, fieldName);
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        try {
            return field.get(object);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    @Override
    public Set<String> getProtectedMethodNames(Class clazz) {
        checkNull(clazz);
        Method[] methods = clazz.getDeclaredMethods();
        Set<String> methodNames = new HashSet<String>();
        for (Method method : methods) {
            if (method.getModifiers() == Modifier.PROTECTED) {
                methodNames.add(method.getName());
            }
        }
        return methodNames;
    }

    @Override
    public Set<Method> getAllImplementedMethodsWithSupers(Class clazz) {
        checkNull(clazz);
        Set<Method> methods = new HashSet<Method>();
        methods.addAll(Arrays.asList(clazz.getDeclaredMethods()));
        for (Class tmpClass : getExtendsHierarchy(clazz)) {
            methods.addAll(Arrays.asList(tmpClass.getDeclaredMethods()));
        }
        return methods;
    }

    @Override
    public List<Class> getExtendsHierarchy(Class clazz) {
        checkNull(clazz);
        List<Class> classes = new LinkedList<Class>();
        Class tmp = clazz;
        while ((tmp = tmp.getSuperclass()) != null) {
            classes.add(tmp);
        }
        return classes;
    }

    @Override
    public Set<Class> getImplementedInterfaces(Class clazz) {
        checkNull(clazz);
        Set<Class> interfaces = new HashSet<Class>();
        List<Class> interfaceTmp = Arrays.asList(clazz.getInterfaces());
        interfaces.addAll(interfaceTmp);
        for (Class tmpClass : interfaceTmp) {
            interfaces.addAll(getExtendsHierarchy(tmpClass));
        }
        for (Class tmpClass : getExtendsHierarchy(clazz)) {
            interfaces.addAll(getImplementedInterfaces(tmpClass));
        }
        return interfaces;
    }

    @Override
    public List<Class> getThrownExceptions(Method method) {
        checkNull(method);
        // for Java 8
        // return Arrays.asList(method.getExceptionTypes());
        Class[] methods = method.getExceptionTypes();
        return Arrays.asList(methods);
    }

    @Override
    public String getFooFunctionResultForDefaultConstructedClass() {
        String result = null;
        Constructor<?>[] constructors = SecretClass.class.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            // for java 8
            //if (constructor.getParameterCount() == 0) {
            if (Arrays.asList(constructor.getParameterTypes()).isEmpty()) {
                constructor.setAccessible(true);
                try {
                    SecretClass tmp = (SecretClass) constructor.newInstance();
                    Method method = SecretClass.class.getDeclaredMethod("foo");
                    method.setAccessible(true);
                    result = (String) method.invoke(tmp);
                } catch (InstantiationException
                        | IllegalAccessException
                        | InvocationTargetException
                        | NoSuchMethodException
                        ignored) {
                }
            }
        }
        return result;
    }

    @Override
    public String getFooFunctionResultForClass(String constructorParameter, String string, Integer... integers) {
        String result = null;
        SecretClass secretClass = new SecretClass(constructorParameter);
        try {
            Method method = secretClass.getClass().getDeclaredMethod("foo", String.class, integers.getClass());
            method.setAccessible(true);
            result = (String) method.invoke(secretClass, string, integers);

        } catch (NoSuchMethodException
                | InvocationTargetException
                | IllegalAccessException
                ignored) {
            ignored.printStackTrace();
        }
        return result;
    }
}
