package robotService.core;

import robotService.common.ExceptionMessages;
import robotService.common.OutputMessages;
import robotService.core.interfaces.Controller;
import robotService.models.garages.GarageImpl;
import robotService.models.garages.interfaces.Garage;
import robotService.models.procedures.Charge;
import robotService.models.procedures.Repair;
import robotService.models.procedures.Work;
import robotService.models.procedures.interfaces.Procedure;
import robotService.models.robots.Cleaner;
import robotService.models.robots.Housekeeper;
import robotService.models.robots.interfaces.Robot;

public class ControllerImpl implements Controller {
    private Garage garage;
    private Procedure charge;
    private Procedure repair;
    private Procedure work;

    public ControllerImpl() {
        this.garage = new GarageImpl();
        this.charge = new Charge();
        this.repair = new Repair();
        this.work = new Work();
    }

    @Override
    public String manufacture(String robotType, String name, int energy, int happiness, int procedureTime) {
        switch (robotType){
            case "Cleaner":
                this.garage.manufacture(new Cleaner(name, energy, happiness, procedureTime));
                return String.format(OutputMessages.ROBOT_MANUFACTURED, name);
            case "Housekeeper":
                this.garage.manufacture(new Housekeeper(name, energy, happiness, procedureTime));
                return String.format(OutputMessages.ROBOT_MANUFACTURED, name);
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_ROBOT_TYPE, robotType));
        }
    }

    @Override
    public String repair(String robotName, int procedureTime) {
        this.repair.doService(getRobotIfExist(robotName),procedureTime);
        return String.format(OutputMessages.REPAIR_PROCEDURE, robotName);
    }

    @Override
    public String work(String robotName, int procedureTime) {
        this.work.doService(getRobotIfExist(robotName),procedureTime );
        return String.format(OutputMessages.WORK_PROCEDURE, robotName,procedureTime);
    }

    @Override
    public String charge(String robotName, int procedureTime) {
        this.charge.doService(getRobotIfExist(robotName), procedureTime);
        return String.format(OutputMessages.CHARGE_PROCEDURE, robotName);
    }

    @Override
    public String sell(String robotName, String ownerName) {
        this.garage.sell(getRobotIfExist(robotName).getName(), ownerName);
        return String.format(OutputMessages.SELL_ROBOT, ownerName, robotName);
    }

    @Override
    public String history(String procedureType) {
         switch (procedureType) {
            case "Charge":
                return this.charge.history();
            case "Repair":
                return this.repair.history();
            case "Work":
                return this.work.history();
            default:
                return null;
        }
    }

    private Robot getRobotIfExist(String robotName) {
        if (!this.garage.getRobots().containsKey(robotName))
            throw new IllegalArgumentException(String.format(ExceptionMessages.NON_EXISTING_ROBOT, robotName));

        return this.garage.getRobots().get(robotName);
    }
}
