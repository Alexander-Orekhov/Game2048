package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class Game2048Test {

    @Mock Board board = mock(SquareBoard.class);
    @InjectMocks Game2048 game2048 = new Game2048();

    @BeforeEach
    void createGame(){
    }

    @Test
    void hasWinTest(){
        Mockito.when(board.hasValue()).thenReturn(true);
        assertEquals(true, game2048.hasWin());
    }
}
