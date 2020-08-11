package motocrossWorldChampionship.entities.motorcycles;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;

public abstract class MotorcycleImpl implements Motorcycle {
    private static final int MIN_SYMBOLS = 4;

    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public MotorcycleImpl(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.cubicCentimeters = cubicCentimeters;
    }

    public void setModel(String model) {
        if(model == null || model.trim().isEmpty() || model.length() < MIN_SYMBOLS)
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_MODEL, model, MIN_SYMBOLS));
        this.model = model;
    }

    public void setHorsePower(int horsePower){
        this.horsePower = horsePower;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return (cubicCentimeters / horsePower) * laps;
    }
}
//•	model – String (If the model is null, whitespace or less than 4 symbols,
// throw an IllegalArgumentException with message "Model {model} cannot be less than 4 symbols.")
// – All models are unique

//•	horsePower – int (every type of motorcycle has a different range of valid horsepower.
// If the horsepower is not in the valid range, throw an IllegalArgumentException
// with message "Invalid horse power: {horsepower}.")

//•	cubicCentimeters – double(every type of motorcycle has different cubic centimeters)