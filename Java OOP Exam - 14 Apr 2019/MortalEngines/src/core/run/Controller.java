package core.run;

public interface Controller {
    String Hire(String name);

    String Report(String pilotName);

    String ManufactureTank(String type, double attackPoints, double defensePoints);

    String ManufactureFighter(String type, double attackPoints, double defensePoints);

    String Engage(String pilotName, String machineName);

    String Attack(String attackMachineName, String defendingMachineName);

    String AggressiveMode(String machineName);

    String DefenseMode(String machineName);

//    String Over();
}
