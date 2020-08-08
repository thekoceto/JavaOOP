package robotService.models.procedures;

import robotService.models.robots.interfaces.Robot;

public class Work extends BaseProcedure{
    private static final int COST_HAPPINESS = 12;
    private static final int COST_ENERGY = 6;

    @Override
    public Robot robotAfterDoService(Robot robot) {

        robot.setHappiness(robot.getHappiness() + COST_HAPPINESS);
        robot.setEnergy(robot.getEnergy() - COST_ENERGY);
        return robot;
    }
}
