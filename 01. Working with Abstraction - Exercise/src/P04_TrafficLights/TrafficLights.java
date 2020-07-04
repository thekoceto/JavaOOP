/*
 * Copyright (c) 2020.
 * thekoceto@gmail.com
 */

package P04_TrafficLights;

public enum TrafficLights {
    RED(0), GREEN(1), YELLOW(2);

    private int index;

    TrafficLights(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public TrafficLights getLightByIndex (int index){
        for (TrafficLights light : TrafficLights.values()) {
            if (light.index == index)
                return light;
        }
        return null;
    }
}
