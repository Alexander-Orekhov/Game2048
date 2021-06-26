package game;

import javax.jnlp.SingleInstanceListener;
import java.security.SecureRandom;
import java.util.*;

public class Game2048 implements Game {

    public static final int GAME_SIZE = 4;

    Random random = new SecureRandom();
    private final Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);

    @Override
    public void init(){
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < (GAME_SIZE * GAME_SIZE); i++) {
            values.add(null);
        }
        board.fillBoard(values);
        try {
            addItem();
            addItem();
        } catch (NotEnoughSpace notEnoughSpace) {
            notEnoughSpace.printStackTrace();
        }
    }

    @Override
    public boolean canMove() {
        return !board.availableSpace().isEmpty();
    }

    @Override
    public boolean move(Direction direction) {
        boolean result = true;
        GameHelper gameHelper = new GameHelper();
        if (canMove()) {
            for (int i = 0; i < GAME_SIZE; i++) {
                List<Key> keys = null;
                switch (direction) {
                    case LEFT:
                        keys = board.getRow(i);
                        break;
                    case RIGHT:
                        keys = board.getRow(i);
                        Collections.reverse(keys);
                        break;
                    case UP:
                        keys = board.getColumn(i);
                        break;
                    case DOWN:
                        keys = board.getColumn(i);
                        Collections.reverse(keys);
                        break;
                }
                Iterator<Integer> iteratorGameHelperResult = gameHelper.moveAndMergeEqual(board.getValues(keys)).iterator();
                for (Key key : keys) {
                    board.addItem(key, iteratorGameHelperResult.next());
                }
            }

            try {
                addItem();
            } catch (NotEnoughSpace notEnoughSpace) {
                notEnoughSpace.printStackTrace();
            }
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public void addItem() throws NotEnoughSpace {
        if (board.availableSpace().isEmpty()) {
            throw new NotEnoughSpace();
        }
        Integer value = 0;
        while (value == 0) {
            value = random.nextInt((board.availableSpace().size() - 1));
        }
        Key key = board.availableSpace().get(value);
        board.addItem(key, 2);
    }

    @Override
    public Board getGameBoard() {
        return board;
    }

    @Override
    public boolean hasWin() {
        return board.hasValue(64);
    }

}
