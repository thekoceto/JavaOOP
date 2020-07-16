package P03_BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        List<Birthable> birthables = new ArrayList<>();

        while (!"End".equals(input = reader.readLine())){
            String[] token = input.split(" ");
            switch (token[0]){
                case "Citizen":
                    birthables.add(new Citizen(token[1],Integer.parseInt(token[2]),token[3],token[4]));
                    break;
                case "Pet":
                    birthables.add(new Pet(token[1],token[2]));
                    break;
                case "Robot":
                    break;
            }
        }
        String birthYear = reader.readLine();

        birthables
                .stream()
                .filter(birthable -> birthable.getBirthDate().endsWith(birthYear))
                .forEach(birthable -> System.out.println(birthable.getBirthDate()));

    }
}
//Citizen Stamat 16 0041018380 01/01/2000
//Robot MK-10 12345678
//Robot PP-09 00000001
//Pet Topcho 24/12/2000
//Pet Kosmat 12/06/2002
//End
//2000