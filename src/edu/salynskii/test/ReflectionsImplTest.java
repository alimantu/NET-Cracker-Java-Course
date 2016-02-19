package edu.salynskii.test;

import ru.ncedu.java.tasks.Reflections;
import ru.ncedu.java.tasks.ReflectionsImpl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Alimantu on 04/11/15.
 */
public class ReflectionsImplTest {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        ReflectionsImpl reflections = new ReflectionsImpl();

        // getFieldValue test
        /*Reflections.SecretClass secretClass = new Reflections.SecretClass("abc");
        System.out.println((String) reflections.getFieldValueByName(secretClass, "text"));
        System.out.println((String) reflections.getFieldValueByName(secretClass, "secret"));*/

        // getProtected test
        //System.out.println(reflections.getProtectedMethodNames(SuperBase.class));

        // getAllImpl and getExtendsHier test
        //System.out.println(reflections.getAllImplementedMethodsWithSupers(Base.class));

        // getImplemInter test
        //System.out.println(reflections.getImplementedInterfaces(TreeMap.class));

        // getThrown test
        /*System.out.println(reflections
                .getThrownExceptions(ReflectionsImpl.class
                        .getMethod("getFieldValueByName", Object.class, String.class)));*/

        // getFooForDefault test
        System.out.println(reflections.getFooFunctionResultForDefaultConstructedClass());

        // getFooForSpecified test
        /*System.out.println(reflections
                .getFooFunctionResultForClass("abc", "One", 1));*/

        /*List<Method> methods = new ArrayList<>(
                Arrays.asList(Reflections.SecretClass.class.getDeclaredMethods())
        );
        for (Method method : methods) {
            System.out.println(Arrays.asList(method.getParameterTypes()).isEmpty());
            System.out.print(Arrays.deepToString(method.getParameterTypes()));
            System.out.println(" " + method.getName());
        }*/

    }
}
