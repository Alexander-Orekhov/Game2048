package game;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;


public class SquareBoardTest {


    @Test
    void availableSpaceTest(){
        SquareBoard squareBoard = new SquareBoard(2);
        squareBoard.fillBoard(asList(1, 2, 3, null));
        assertNotEquals(squareBoard.availableSpace().get(0), squareBoard.getKey(1,1));
    }

}
