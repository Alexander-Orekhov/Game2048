package game;

import java.util.ArrayList;
import java.util.List;

public class Game2048 implements Game {

    public static final int GAME_SIZE = 4;

    private final Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);

    @Override
    public void init() {
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < GAME_SIZE * 2; i++) {

        }
        board.fillBoard(values);
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public boolean move(Direction direction) {

        return false;
    }

    @Override
    public void addItem() {

    }

    @Override
    public Board getGameBoard() {
        return board;
    }

    @Override
    public boolean hasWin() {
        return false;
    }

}
