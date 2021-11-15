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
}
