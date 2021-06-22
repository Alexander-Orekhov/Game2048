import java.awt.event.HierarchyBoundsAdapter;
import java.util.ArrayList;
import java.util.List;

public class Game2048 {

    public static final int GAME_SIZE = 4;

    private final Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);

    public void init(){
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < GAME_SIZE * 2; i++) {
            List
        }
        board.fillBoard(values);
    }



}
