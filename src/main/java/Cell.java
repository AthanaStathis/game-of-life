public class Cell {
    private String state;

    public Cell(String state) {
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public String updateCellsState(int numberOfLivingNeighbors) {
        if (this.state.equals("0")) {
            if (numberOfLivingNeighbors > 1 && numberOfLivingNeighbors < 4)
                this.state = "0";
            else
                this.state = ".";
        }
        else {
            if (numberOfLivingNeighbors  == 3)
                this.state = "0";
            else
                this.state = ".";
        }
        return this.state;
    }
}
