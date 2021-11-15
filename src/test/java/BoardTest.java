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

    @ParameterizedTest(name = "Point:[{0},{1}] belongs to 3x3 matrix")
    @CsvSource({
            "0,0", "0,1", "0,2",
            "1,0", "1,1", "1,2",
            "2,0", "2,1", "2,2"
    })
    void method_cellPointLiesInLattice_returns_true_when_coordinates_are_valid_gen0_lattice_points_(int x, int y) {
        Board board = new Board();
        board.initializeLattice(testLatticeZero);
        assertTrue(board.cellPointLiesInLattice(x, y));
    }

    @ParameterizedTest(name = "Point:[{0},{1}] does not belong to 3x3 matrix")
    @CsvSource({
            "-1,-1", "-1,0", "-1,1","-1,2", "-1,-3",
            "0,-1",                           "0,3",
            "1,-1",                         "-1,-3",
            "2,-1",                         "-1,-3",
            "3,-1",  "3,0",  "3,1",  "3,2",  "3,-3"
    })
    void method_cellPointLiesInLattice_returns_false_when_coordinates_are_not_valid_lattice_points(int x, int y) {
        Board board = new Board();
        board.initializeLattice(testLatticeZero);
        assertFalse(board.cellPointLiesInLattice(x, y));
    }

    @ParameterizedTest(name = "Cell:[{0},{1}], Expected living-neigborgs:{2}")
    @CsvSource({
            // Cell-row, cell-column, number of living neighbors
            "0,0,2", "0,1,3", "0,2,2",
            "1,0,1", "1,1,2", "1,2,1",
            "2,0,2", "2,1,3", "2,2,2"
    })
    void method_countNumberOfLivingNeighbors_returns_proper_number_of_living_neighboring_cells_for_both_alive_and_dead_cells_for_initial_lattice
            (int row, int col, int expectedNumberOfLivingNeighbors) {
        Board board = new Board();
        board.initializeLattice(testLatticeZero);
        assertEquals(board.countCellsLivingNeighbors(row, col), expectedNumberOfLivingNeighbors);
    }

    @ParameterizedTest(name = "Cell:[{0},{1}], Expected living-neigborgs:{2}")
    @CsvSource({
            // Cell-row, cell-column, number of living neighbors
            "0,0,2", "0,1,1", "0,2,2",
            "1,0,3", "1,1,2", "1,2,3",
            "2,0,2", "2,1,1", "2,2,2"
    })
    void method_countNumberOfLivingNeighbors_returns_proper_number_of_living_neighboring_cells_for_both_alive_and_dead_cells_for_first_generation_lattice
            (int row, int col, int expectedNumberOfLivingNeighbors) {
        Board board = new Board();
        board.initializeLattice(testLatticeOne);
        assertEquals(board.countCellsLivingNeighbors(row, col), expectedNumberOfLivingNeighbors);
    }

    @ParameterizedTest(name = "Cell:[{0},{1}]")
    @CsvSource({
            "0,0", "0,1", "0,2",
            "1,0", "1,1", "1,2",
            "2,0", "2,1", "2,2"
    })
    void get_next_generation_applied_to_board_with_initial_lattice_gives_board_with__generation_one_lattice
            (int row, int col) {
        Board board = new Board();
        board.initializeLattice(testLatticeZero);
        board.getNextGeneration();
        assertEquals(board.lattice[row][col].getState(), firstGenerationLattice[row][col]);
    }
}
