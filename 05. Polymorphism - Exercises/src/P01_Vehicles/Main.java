package P01_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] token = reader.readLine().split("\\s+");
        Car car = new Car(Double.parseDouble(token[1]), Double.parseDouble(token[2]));
        token = reader.readLine().split("\\s+");
        Truck truck  = new Truck(Double.parseDouble(token[1]), Double.parseDouble(token[2]));

        int n = Integer.parseInt(reader.readLine());
        while (n-- >0){
            token = reader.readLine().split("\\s+");
            switch (token[0]){
                case "Drive":
                    if ("Car".equals(token[1]))
                        car.drive(Double.parseDouble(token[2]));
                    else if ("Truck".equals(token[1]))
                        truck.drive(Double.parseDouble(token[2]));
                    break;
                case "Refuel":
                    if ("Car".equals(token[1]))
                        car.refuel(Double.parseDouble(token[2]));
                    else if ("Truck".equals(token[1]))
                        truck.refuel(Double.parseDouble(token[2]));
                    break;
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
