public interface Game {

    void init();

    boolean canMove();

    boolean move();

    void addItem();

    Board getGameBoard();

    boolean hasWin();

}
