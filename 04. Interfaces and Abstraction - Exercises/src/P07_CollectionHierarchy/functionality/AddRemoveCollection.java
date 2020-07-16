package P07_CollectionHierarchy.functionality;

import P07_CollectionHierarchy.interfaces.AddRemovable;
import P07_CollectionHierarchy.collection.Collection;

public class AddRemoveCollection extends Collection implements AddRemovable {

    @Override
    public int add(String element) {
        super.collection().add(0, element);
        return 0;
    }

    @Override
    public String remove() {
        return super.collection().remove(0);
    }
}
