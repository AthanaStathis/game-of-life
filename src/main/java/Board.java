public class Board {
    public Cell[][] lattice;
    int latticeHeight = 0;
    int latticeWidth = 0;
    private int[][] getCellsLivingNeighbors;

    public Board() {

    }

    public void initializeLattice(Cell[][] lattice) {
        this.lattice = lattice;
        this.latticeHeight = lattice.length;
        this.latticeWidth = lattice[0].length;
    }

    public boolean cellPointLiesInLattice(int row, int col) {
        return row >= 0 && col >= 0 && row < latticeHeight && col < latticeWidth;
    }

    public int countCellsLivingNeighbors(int row, int col) {
        int numberOfLivingNeighbors = 0;
        for (int adjacentRow = row - 1; adjacentRow <= row + 1; adjacentRow +=1) {
            for (int adjacentCol = col - 1 ; adjacentCol <= col + 1; adjacentCol += 1) {
                if(!(adjacentRow == row && adjacentCol == col)) {
                    if(cellPointLiesInLattice(adjacentRow, adjacentCol) &&
                            lattice[adjacentRow][adjacentCol].getState().equals("0")) {
                        numberOfLivingNeighbors++;
                    }
                }
            }
        }
        return numberOfLivingNeighbors;
    }

    private int[][] getCellsLivingNeighbors() {
        int[][] matrixWithLivingNeigborsOfEveryCell = new int[latticeWidth][latticeHeight];
        for (int i = 0; i < latticeHeight; i++) {
            for (int j = 0; j < latticeWidth; j++) {
                matrixWithLivingNeigborsOfEveryCell[i][j] = countCellsLivingNeighbors(i,j);
            }
        }
        return matrixWithLivingNeigborsOfEveryCell;
    }
    
    public void getNextGeneration() {
        int[][] getNumberOfLivingNeighborsOfCell = this.getCellsLivingNeighbors();
        for (int i = 0; i < latticeHeight; i++) {
            for (int j = 0; j < latticeWidth; j++) {
                lattice[i][j].updateCellsState(getNumberOfLivingNeighborsOfCell[i][j]);
            }
        }
    }

    public void printLattice() {
        System.out.println("================================");
        for (int i = 0; i < latticeHeight; i++) {
            for (int j = 0; j < latticeWidth; j++) {
                System.out.print(lattice[i][j].getState()+" ");
            }
            System.out.println();
        }
    }
}
