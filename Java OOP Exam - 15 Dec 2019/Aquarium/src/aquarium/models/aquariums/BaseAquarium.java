package aquarium.models.aquariums;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.models.decorations.Decoration;
import aquarium.models.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseAquarium implements Aquarium{
    private String name;
    private int capacity;
    Collection<Decoration> decorations;
    Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty())
            throw new  NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    @Override
    public void addFish(Fish fish) {
        if(this.fish.size() >= this.capacity)
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);

        this.fish.add(fish);
    }

    @Override
    public int calculateComfort() {
        return this.decorations
                .stream()
                .mapToInt(Decoration::getComfort)
                .sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        return this.name + " (" + this.getClass().getSimpleName() + "):" +
                System.lineSeparator() +
                "Fish: " + fish.stream().map(Fish::getName).collect(Collectors.joining(" ")) +
                System.lineSeparator() +
                "Decorations: " + this.decorations.size() +
                System.lineSeparator() +
                "Comfort: " + this.calculateComfort();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
//"{aquariumName} ({aquariumType}):
//Fish: {fishName1} {fishName2} {fishName3} (…) / none
//Decorations: {decorationsCount}
//Comfort: {aquariumComfort}"