/*
 * Copyright (c) 2020.
 * thekoceto@gmail.com
 */

package P04_TrafficLights;

import java.util.Arrays;

public enum TrafficLights {
    RED(0), GREEN(1), YELLOW(2);

    private final int index;

    TrafficLights(int index) {
        this.index = index;
    }

    public TrafficLights getLightByIndex (int index){
        return Arrays.stream(TrafficLights.values())
                .filter(t -> t.index == index)
                .findAny()
                .orElse(null);
    }

//    public TrafficLights getLightByIndex (int index){
//        for (TrafficLights light : TrafficLights.values()) {
//            if (light.index == index)
//                return light;
//        }
//        return null;
//    }
}
