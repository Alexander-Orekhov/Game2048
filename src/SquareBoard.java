import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SquareBoard<V> extends Board<Key, V> {

    public SquareBoard(int size) {
        super(size, size);
    }

    @Override
    public void fillBoard(List<V> list) {
        Iterator iterator = list.iterator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weigh; j++) {
                board.put(new Key(i, j), (V) iterator.next());
            }
        }
    }

    @Override
    public List<Key> availableSpace() {
        List<Key> availableSpace = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weigh; j++) {
                if (board.get(new Key(i, j)).equals(null)) {
                    availableSpace.add(new Key(i, j));
                }
            }
        }
        return new ArrayList<>();
    }

    @Override
    public void addItem(Key key, V value) {
        board.put(key, value);
    }

    @Override
    public Key getKey(int i, int j) {
        return new Key(i, j);
    }

    @Override
    public V getValue(Key key) {
        return board.get(key);
    }

    @Override
    public List<Key> getColumn(int j) {
        List<Key> column = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            column.add(new Key(i, j));
        }
        return column;
    }

    @Override
    public List<Key> getRow(int i) {
        List<Key> row = new ArrayList<>();
        for (int j = 0; j < weigh; j++) {
            row.add(new Key(i, j));
        }
        return null;
    }

    @Override
    public boolean hasValue(V value) {
        return board.containsValue(value);
    }

    @Override
    public List<V> getValues(List<Key> keys) {
        List<V> values = new ArrayList<>();
        for (Key key : keys) {
            values.add(board.get(key));
        }
        return values;
    }

}
