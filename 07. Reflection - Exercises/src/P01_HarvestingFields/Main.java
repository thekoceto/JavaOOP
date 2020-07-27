package P01_HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		Field[] fields = RichSoilLand.class.getDeclaredFields();
		while (!"HARVEST".equals(input = reader.readLine())) {
			if ("all".equals(input)){
				Arrays.stream(fields)
						.forEach(field -> System.out.printf("%s %s %s%n",
								Modifier.toString(field.getModifiers()),
								field.getType().getSimpleName(),
								field.getName()));
			}else{
				String finalInput = input;
				Arrays.stream(fields)
						.filter(field -> Modifier.toString(field.getModifiers()).equals(finalInput))
						.forEach(field -> System.out.printf("%s %s %s%n",
								Modifier.toString(field.getModifiers()),
								field.getType().getSimpleName(),
								field.getName()));
			}
//			switch (input){
//				case "private":
//					Arrays.stream(fields)
//							.filter(field -> field.getModifiers() == Modifier.PRIVATE)
//							.forEach(field -> System.out.printf("private %s %s%n",
//									field.getType().getSimpleName(),
//									field.getName()));
//					break;
//				case "protected":
//					Arrays.stream(fields)
//							.filter(field -> field.getModifiers() == Modifier.PROTECTED)
//							.forEach(field -> System.out.printf("protected %s %s%n",
//									field.getType().getSimpleName(),
//									field.getName()));
//					break;
//				case "public":
//					Arrays.stream(fields)
//							.filter(field -> field.getModifiers() == PUBLIC)
//							.forEach(field -> System.out.printf("public %s %s%n",
//									field.getType().getSimpleName(),
//									field.getName()));
//					break;
//				case "all":
//					Arrays.stream(fields)
//							.forEach(field -> System.out.printf("%s %s %s%n",
//									Modifier.toString(field.getModifiers()),
//									field.getType().getSimpleName(),
//									field.getName()));
//					break;
//			}
		}
	}
}
