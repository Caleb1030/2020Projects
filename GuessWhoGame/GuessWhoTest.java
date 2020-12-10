public class GuessWhoTest{

    //creates the boards so each player has the same characters on their board
    private static Board board1 = new Board();
    private static Board board2 = board1;
    public static void main(String[] args) {
        Tile[][] board = board1.getBoard();
        System.out.println(board[1][1].getInputArr());
    }
}