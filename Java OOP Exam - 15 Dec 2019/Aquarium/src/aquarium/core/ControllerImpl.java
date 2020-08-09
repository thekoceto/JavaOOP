package aquarium.core;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.models.aquariums.Aquarium;
import aquarium.models.aquariums.FreshwaterAquarium;
import aquarium.models.aquariums.SaltwaterAquarium;
import aquarium.models.decorations.Decoration;
import aquarium.models.decorations.Ornament;
import aquarium.models.decorations.Plant;
import aquarium.models.fish.Fish;
import aquarium.models.fish.FreshwaterFish;
import aquarium.models.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.Collections;
import java.util.HashMap;

public class ControllerImpl implements Controller{
    private DecorationRepository decorations;
    private HashMap<String, Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new HashMap<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquariums.put(aquariumName, new FreshwaterAquarium(aquariumName));
                return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
            case "SaltwaterAquarium":
                aquariums.put(aquariumName, new SaltwaterAquarium(aquariumName));
                return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }

    }

    @Override
    public String addDecoration(String type) {
        switch (type) {
            case "Ornament":
                decorations.add(new Ornament());
                return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
            case "Plant":
                decorations.add(new Plant());
                return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {

        Decoration decoration = decorations.findByType(decorationType);
        if (decoration != null){
            aquariums.get(aquariumName).addDecoration(decoration);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM,
                    decorationType, aquariumName);
        }else
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_DECORATION_FOUND, decorationType));
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        switch (fishType) {
            case "FreshwaterFish":
                if(aquariums.get(aquariumName).getClass().getSimpleName().equals("FreshwaterAquarium")){
                    aquariums.get(aquariumName).addFish(new FreshwaterFish(fishName, fishSpecies, price));
                    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
                }
                else
                    return ConstantMessages.WATER_NOT_SUITABLE;
            case "SaltwaterFish":
                if(aquariums.get(aquariumName).getClass().getSimpleName().equals("SaltwaterAquarium")){
                    aquariums.get(aquariumName).addFish(new SaltwaterFish(fishName, fishSpecies, price));
                    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
                }
                else
                    return ConstantMessages.WATER_NOT_SUITABLE;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FISH_TYPE);
        }
    }

    @Override
    public String feedFish(String aquariumName) {
        aquariums.get(aquariumName).feed();
        return String.format(ConstantMessages.FISH_FED, aquariums.get(aquariumName).getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = aquariums.get(aquariumName);
        double decorationsPrice = aquarium
                .getDecorations()
                .stream()
                .mapToDouble(Decoration::getPrice)
                .sum();
        double fishPrice = aquarium
                .getFish()
                .stream()
                .mapToDouble(Fish::getPrice)
                .sum();
        return String.format(ConstantMessages.VALUE_AQUARIUM, aquariumName, decorationsPrice + fishPrice);
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();
        aquariums.values().forEach(aquarium -> report
                        .append(aquarium.getInfo())
                        .append(System.lineSeparator())
        );
        return report.toString().trim();
    }
}
