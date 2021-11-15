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

    @ParameterizedTest(name = "Number of Neigbors: {index} => Initial State={0} Resulting Cell State={1}")
    @CsvSource({
            "0,0, .",
            "0,1, .",
            "0,2, 0",
            "0,3, 0",
            "0,4, .",
            ".,1,.",
            ".,2,.",
            ".,3,0",
            ".,4,."
    })
    void update_Cell_state_as_function_of_living_neigbors(String initialState, int numberOfNeigbors, String state) {
        Cell cell = new Cell(initialState);
        assertEquals(cell.updateCellsState(numberOfNeigbors), state);
    }
}