package game;

import java.util.ArrayList;
import java.util.List;

public class GameHelper {

    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        List<Integer> newValues = new ArrayList<>();
        int listSize = list.size();
        int nullCounter = 0;
        for (int i = 0; i < listSize; i++) {
            Integer value = list.get(i);
            if (value != null) {
                if ((i + 1) != listSize) {
                    for (int j = i + 1; j < listSize; j++) {
                        if (list.get(j) != null) {
                            if (value.equals(list.get(j))) {
                                value = value * 2;
                                list.set(j, null);
                            }
                            break;
                        }
                    }
                }
                newValues.add(value);
            } else {
                nullCounter++;
            }
        }
        for (int i = 0; i < nullCounter; i++) {
            newValues.add(null);
        }
        return newValues;
    }

}
