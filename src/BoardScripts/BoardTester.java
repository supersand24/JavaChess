package BoardScripts;

import java.util.Stack;

public class BoardTester {

    public static void main(String[] args) {
        System.out.println("This is the board tester!");
        Board myBoard = new Board();
        System.out.println(myBoard.toString());

        System.out.println("Fill row 2 with Pawns");
        Board TestBoard;
        Stack<TestPiece> wPawns = new Stack<TestPiece>();
        for(int i = 0; i<8;i++){
            wPawns.push(new TestPiece());
        }
        //TestBoard = new Board(/*new Stack<TestPiece>(),*/wPawns/*,new Stack<TestPiece>(),new Stack<TestPiece>()*/);
        TestBoard = new Board();
        TestBoard.rowFill(1,wPawns);

        System.out.println("Fill row 7 with Black Pawns");
        Stack<TestPiece> bPawns = new Stack<TestPiece>();
        for(int i = 0; i<8;i++) bPawns.push(new TestPiece(1));
        TestBoard.rowFill(6,bPawns);
        System.out.println(TestBoard.toString());
        //int Xcord =1;
        //int Ycord =1;
        //int x = myBoard.myboard[Xcord][Ycord].team;
    }

    private void flipTest(Board myBoard){
        System.out.println("Board post 1st Flip");
        myBoard.flipBoard();
        System.out.println(myBoard.toString());
        System.out.println("Board post 2nd Flip");
        myBoard.flipBoard();
        System.out.println(myBoard.toString());
    }
    private void pieceTest(Board myBoard){
        TestPiece myPiece = new TestPiece();
        TestPiece myOPiece= new TestPiece(1);
        myBoard.ChangePlace(new int[]{1,0},myPiece);
        myBoard.ChangePlace(new int[]{6,5},myOPiece);
        System.out.println("New board post adding 2 pieces");
        System.out.println(myBoard.toString());
    }
}
