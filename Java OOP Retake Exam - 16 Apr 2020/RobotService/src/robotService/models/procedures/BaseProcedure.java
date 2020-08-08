package robotService.models.procedures;

import robotService.common.ExceptionMessages;
import robotService.models.procedures.interfaces.Procedure;
import robotService.models.robots.interfaces.Robot;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseProcedure implements Procedure {
    private Collection<Robot> robots;

    public BaseProcedure() {
        this.robots = new ArrayList<>();
    }

    @Override
    public String history() {
        StringBuilder report = new StringBuilder()
                .append(this.getClass().getSimpleName())
                .append(System.lineSeparator());

        robots.forEach(robot -> report.append(robot.toString()).append(System.lineSeparator()));

        return report.toString().trim();
    }

    @Override
    public void doService(Robot robot, int procedureTime){
        if (robot.getProcedureTime() < procedureTime)
            throw new IllegalArgumentException(ExceptionMessages.INSUFFICIENT_PROCEDURE_TIME);

        robots.add(robotAfterDoService(robot));
    }

    protected abstract Robot robotAfterDoService (Robot robot);

}
