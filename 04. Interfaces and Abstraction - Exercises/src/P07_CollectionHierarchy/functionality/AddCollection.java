package P07_CollectionHierarchy.functionality;

import P07_CollectionHierarchy.interfaces.Addable;
import P07_CollectionHierarchy.collection.Collection;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String element) {
        super.collection().add(element);
        return super.collection().size()-1;
    }
}
