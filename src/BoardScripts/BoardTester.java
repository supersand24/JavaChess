package BoardScripts;

import java.sql.SQLOutput;

public class BoardTester {
    public static void main(String[] args) {
        System.out.println("This is the board tester!");
        Board myBoard = new Board();
        System.out.println(myBoard.toString());
        TestPiece myPiece = new TestPiece();
        TestPiece myOPiece= new TestPiece(1);
        myBoard.ChangePlace(new int[]{1,0},myPiece);
        myBoard.ChangePlace(new int[]{6,5},myOPiece);
        System.out.println("New board post adding 1 piece");
        System.out.println(myBoard.toString());
        System.out.println("Board post 1st Flip");
        myBoard.flipBoard();
        System.out.println(myBoard.toString());
        System.out.println("Board post 2nd Flip");
        myBoard.flipBoard();
        System.out.println(myBoard.toString());
    }
}
