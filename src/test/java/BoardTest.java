import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    String[][] secondGenerationLattice = new String[][]{
            {".", ".","."},
            {"0", "0","0"},
            {".", ".","."}
    };

    String[][] firstGenerationLattice = new String[][]{
            {".", "0","."},
            {".", "0","."},
            {".", "0","."}
    };

    Cell[][] testLatticeZero = {
            {new Cell("."),new Cell("."),new Cell(".")},
            {new Cell("0"),new Cell("0"),new Cell("0")},
            {new Cell("."),new Cell("."),new Cell(".")}
    };

    Cell[][] testLatticeOne = {
            {new Cell("."),new Cell("0"),new Cell(".")},
            {new Cell("."),new Cell("0"),new Cell(".")},
            {new Cell("."),new Cell("0"),new Cell(".")}
    };

    @ParameterizedTest(name = "Cell:[{0},{1}], Expected-State={2}")
    @CsvSource({
            "0,0,.", "0,1,.", "0,2,.",
            "1,0,0", "1,1,0", "1,2,0",
            "2,0,.", "2,1,.", "2,2,."
    })
    void initialize_board_according_to_zero_generation_lattice(int row, int col, String expectedState) {
        Board board = new Board();
        board.initializeLattice(testLatticeZero);
        assertEquals(board.lattice[row][col].getState(), expectedState);
    }

    @ParameterizedTest(name = "Cell:[{0},{1}], Expected-State={2}")
    @CsvSource({
            "0,0,.", "0,1,0", "0,2,.",
            "1,0,.", "1,1,0", "1,2,.",
            "2,0,.", "2,1,0", "2,2,."
    })
    void initialize_board_according_to_first_generation_lattice(int row, int col, String expectedState) {
        Board board = new Board();
        board.initializeLattice(testLatticeOne);
        assertEquals(board.lattice[row][col].getState(), expectedState);
    }
}
