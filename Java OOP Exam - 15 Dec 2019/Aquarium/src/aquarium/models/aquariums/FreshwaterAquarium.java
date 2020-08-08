package aquarium.models.aquariums;

import aquarium.common.ConstantMessages;
import aquarium.models.fish.Fish;

public class FreshwaterAquarium extends BaseAquarium{
    private static final int INITIAL_CAPACITY = 50;

    protected FreshwaterAquarium(String name) {
        super(name, INITIAL_CAPACITY);
    }

}
