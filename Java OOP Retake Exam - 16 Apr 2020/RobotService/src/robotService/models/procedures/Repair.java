package robotService.models.procedures;

import robotService.common.ExceptionMessages;
import robotService.models.robots.interfaces.Robot;

public class Repair extends BaseProcedure{
    private static final int COST_HAPPINESS = 5;

    @Override
    public Robot robotAfterDoService(Robot robot) {
        if (robot.isRepaired())
            throw new IllegalArgumentException(String.format(ExceptionMessages.ALREADY_REPAIRED, robot.getName()));

        robot.setHappiness(robot.getHappiness() - COST_HAPPINESS);
        robot.setRepaired(true);
        return robot;
    }
}
