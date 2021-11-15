public class Main {
    public static void main(String[] args) throws InterruptedException {
        Cell[][] testLattice = {
                {new Cell("."),new Cell("."),new Cell("."),new Cell("0"),new Cell("0"),new Cell("."),new Cell("."),new Cell(".")},
                {new Cell("."),new Cell("."),new Cell("0"),new Cell("."),new Cell("."),new Cell("0"),new Cell("."),new Cell(".")},
                {new Cell("."),new Cell("0"),new Cell("."),new Cell("."),new Cell("."),new Cell("."),new Cell("0"),new Cell(".")},
                {new Cell("0"),new Cell("."),new Cell("."),new Cell("."),new Cell("."),new Cell("."),new Cell("."),new Cell("0")},
                {new Cell("0"),new Cell("."),new Cell("."),new Cell("."),new Cell("."),new Cell("."),new Cell("."),new Cell("0")},
                {new Cell("."),new Cell("0"),new Cell("."),new Cell("."),new Cell("."),new Cell("."),new Cell("0"),new Cell(".")},
                {new Cell("."),new Cell("."),new Cell("0"),new Cell("."),new Cell("."),new Cell("0"),new Cell("."),new Cell(".")},
                {new Cell("."),new Cell("."),new Cell("."),new Cell("0"),new Cell("0"),new Cell("."),new Cell("."),new Cell(".")},
        };
        /*Cell[][] testLattice = {
                {new Cell("."),new Cell("."),new Cell("."),new Cell("."),new Cell(".")},
                {new Cell("."),new Cell("."),new Cell("."),new Cell("."),new Cell(".")},
                {new Cell("."),new Cell("0"),new Cell("0"),new Cell("0"),new Cell(".")},
                {new Cell("."),new Cell("."),new Cell("."),new Cell("."),new Cell(".")},
                {new Cell("."),new Cell("."),new Cell("."),new Cell("."),new Cell(".")},
        };*/

        Board board = new Board();
        board.initializeLattice(testLattice);
        board.printLattice();
        for (int i = 0; i < 10; i++) {
            board.getNextGeneration();
            Thread.sleep(1 * 1000);
            board.printLattice();
        }
    }
}