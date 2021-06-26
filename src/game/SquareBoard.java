package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SquareBoard<V> extends Board<Key, V> {

    public SquareBoard(int size) {
        super(size, size);
    }

    @Override
    public void fillBoard(List<V> list) {
        if (list.size() > (height * weigh)) {
            throw new RuntimeException();
        }
        Iterator<V> iterator = list.iterator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weigh; j++) {
                if (iterator.hasNext()) {
                    board.put(new Key(i, j), iterator.next());
                }
            }
        }
    }

    @Override
    public List<Key> availableSpace() {
        List<Key> space = new ArrayList<>();
        if (!board.isEmpty()) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < weigh; j++) {
                    Key key = new Key(i, j);
                    if (Objects.isNull(board.get(key))) {
                        space.add(getKey(i, j));
                    }
                }
            }
        }
        return space;
    }

    @Override
    public void addItem(Key key, V value) {
        board.put(getKey(key.i, key.j), value);
    }

    @Override
    public Key getKey(int i, int j) {
        Key result = null;
        for (Key key : board.keySet()) {
            if (key.equals(new Key(i, j))) {
                result = key;
            }
        }
        return result;
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
        return row;
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
