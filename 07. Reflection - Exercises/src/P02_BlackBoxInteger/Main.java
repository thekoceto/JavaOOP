package P02_BlackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Method[] methods = BlackBoxInt.class.getDeclaredMethods();

        String input;
        while (!"END".equals(input = reader.readLine())){
            String[] token = input.split("_");
            int value = Integer.parseInt(token[1]);

            Method method = Arrays.stream(methods)
                    .filter(m -> token[0].equals(m.getName()))
                    .findFirst()
                    .orElse(null);

            if (method != null){
                method.setAccessible(true);
                method.invoke(blackBoxInt, value);
                Field declaredField = blackBoxInt.getClass().getDeclaredField("innerValue");
                declaredField.setAccessible(true);
                System.out.println(declaredField.getInt(blackBoxInt));
            }
        }
    }
}
