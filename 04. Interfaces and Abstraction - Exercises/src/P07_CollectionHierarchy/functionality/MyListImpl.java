package P07_CollectionHierarchy.functionality;

import P07_CollectionHierarchy.interfaces.MyList;
import P07_CollectionHierarchy.collection.Collection;

public class MyListImpl extends Collection implements MyList {

    @Override
    public int add(String element) {
        super.collection().add(0, element);
        return 0;
    }

    @Override
    public String remove() {
        return super.collection().remove(super.collection().size()-1);
    }

    @Override
    public int getUsed() {
        return super.collection().size();
    }
}
