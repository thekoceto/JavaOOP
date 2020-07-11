package P04_PizzaCalories;

import java.util.HashMap;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;
    //-	flourType: String
    //-	bakingTechnique: String
    //-	weight: double

    private final HashMap<String, Double> flourTypes = new HashMap<>(){{
        put("White", 1.5);    put("Wholegrain", 1.0);
    }};

    private final HashMap<String, Double> bakingTechniques = new HashMap<>(){{
        put("Homemade", 1.0); put("Crispy", 0.9);
        put("Chewy", 1.1);
    }};

    //+ Dough (String, String, double)
    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    //-	setFlourType(String): void
    private void setFlourType(String flourType) {
        if (!flourTypes.containsKey(flourType))
            throw new IllegalArgumentException("Invalid type of dough.");
        this.flourType = flourType;
    }

    //-	setBakingTechnique(String): void
    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechniques.containsKey(bakingTechnique))
            throw new IllegalArgumentException("Invalid type of dough.");
        this.bakingTechnique = bakingTechnique;
    }

    //-	setWeight(double): void
    private void setWeight(double weight) {
        if (weight < 1 || weight > 200)
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        this.weight = weight;
    }

    private double getFlourTypes() {
        return this.flourTypes.get(this.flourType);
    }

    private double getBakingTechniques() {
        return this.bakingTechniques.get(this.bakingTechnique);
    }

    //+	calculateCalories (): double
    public double calculateCalories(){
        return this.getFlourTypes() *
                this.getBakingTechniques() *
                this.weight * 2;
    }
}