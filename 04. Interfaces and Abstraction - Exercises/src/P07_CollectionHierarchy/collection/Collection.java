package P07_CollectionHierarchy.collection;

import java.util.ArrayList;

public abstract class Collection {
    private ArrayList<String> items;
    private int maxSize;

    public Collection() {
        this.items = new ArrayList<>();
        maxSize = 100;
    }

    public ArrayList<String> collection() {
        return this.items;
    }

    public boolean isOutOfCapacity() {
        return this.collection().size() < this.maxSize;
    }
}
