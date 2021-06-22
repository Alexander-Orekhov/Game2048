import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GameHelper {

    public List<Integer> moveAndMergeEqual(List<Integer> list){
        List<Integer> newValues = new ArrayList<>();
        int mergeCounter = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer firstValue = list.get(i);
            for (int j = 0; j < ; j++) {

            }
            if (!firstValue.equals(null)){
                move(list, firstValue);
            }
        }
        return newValues;
    }

    private List<Integer> move(List<Integer> list, int value){
        for (int i = value; i >= 0; i++) {
            if (!list.get(i).equals(null) || i == 0){
                replace(list, value, i);
            }
        }
        return list;
    }

    private List<Integer> merge(List<Integer> list, int firstValuePos, int secondValuePos){

    }

    private List<Integer> replace(List<Integer> list, int firstValuePos, int secondValuePos){
        Integer replaceValue = list.get(firstValuePos);
        list.set(firstValuePos, list.get(secondValuePos));
        list.set(secondValuePos, replaceValue);
        return list;
    }



}
