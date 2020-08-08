package aquarium.models.aquariums;

import aquarium.common.ConstantMessages;
import aquarium.models.fish.Fish;

public class SaltwaterAquarium extends BaseAquarium{
    private static final int INITIAL_CAPACITY = 25;

    protected SaltwaterAquarium(String name) {
        super(name, INITIAL_CAPACITY);
    }
}
