package P04_TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TrafficLights[] trafficLights = Arrays.stream(reader.readLine().split(" "))
                .map(TrafficLights::valueOf)
                .toArray(TrafficLights[]::new);

        int n = Integer.parseInt(reader.readLine());
        StringBuilder out = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (TrafficLights trafficLight : trafficLights) {
                int index = (trafficLight.ordinal() + i) % 3;
                out.append(trafficLight.getLightByIndex(index));
                out.append(" ");
            }
            out.append(System.lineSeparator());
        }
        System.out.print(out.toString().trim());
    }
}