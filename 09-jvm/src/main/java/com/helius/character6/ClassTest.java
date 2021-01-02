package com.helius.character6;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Author Helius
 * @Create 2020-08-03-9:48 下午
 */
public class ClassTest {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("java.lang.String");
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
            String mod = Modifier.toString(m.getModifiers());
            System.out.print(mod + " " + m.getName() + " (");
            Class<?>[] parameterTypes = m.getParameterTypes();

        }
    }
}
