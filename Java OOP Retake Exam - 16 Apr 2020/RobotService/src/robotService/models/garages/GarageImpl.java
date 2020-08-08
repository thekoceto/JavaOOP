package robotService.models.garages;

import robotService.common.ExceptionMessages;
import robotService.models.garages.interfaces.Garage;
import robotService.models.robots.interfaces.Robot;

import java.util.LinkedHashMap;
import java.util.Map;

public class GarageImpl implements Garage {
    private static final int CAPACITY = 10;

    private int capacity;
    private Map<String, Robot> robots;

    public GarageImpl() {
        this.capacity = CAPACITY;
        this.robots = new LinkedHashMap<>();
    }

    @Override
    public Map<String, Robot> getRobots() {
        return this.robots;
    }

    @Override
    public void manufacture(Robot robot) {
        if (this.robots.size() >= this.capacity)
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY);

        String robotName = robot.getName();

        if (this.robots.containsKey(robotName))
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_ROBOT,robotName));

        this.robots.put(robotName, robot);
    }

    @Override
    public void sell(String robotName, String ownerName) {
        if (!this.robots.containsKey(robotName))
            throw new IllegalArgumentException(String.format(ExceptionMessages.NON_EXISTING_ROBOT,robotName));

        //If a robot with that name exists, change its owner, its bought status and remove the robot from the garage.
        robots.get(robotName).setOwner(ownerName);
        robots.get(robotName).setBought(true);
        robots.remove(robotName);
    }
}
