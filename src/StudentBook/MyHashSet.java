package StudentBook;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet<T> {
    private final List<T> data = new ArrayList<>();

    public void add(T item) {
        if (!data.contains(item)) {
            data.add(item);
        }
    }

    public void remove(T item) {
        data.remove(item);
    }

    public boolean contains(T item) {
        return data.contains(item);
    }

    public List<T> getAll() {
        return data;
    }

    public int size() {
        return data.size();
    }
}
