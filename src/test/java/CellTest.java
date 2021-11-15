import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;


class CellTest {
    @ParameterizedTest(name = "Number of Neigbors: Initial-State={0} Set-State={1} Expected-State={2}")
    @CsvSource({
            "0,0,0",
            "0,.,.",
            ".,0,0",
            ".,.,."
    })
    void getting_state_after_Setting_Cells_state(String initialState, String newState, String expectedState) {
        Cell cell = new Cell(initialState);
        cell.setState(newState);
        assertEquals(cell.getState(), expectedState);
    }
}