package ArtifactScripts;

import BoardScripts.Board;

public class Bishop extends Artifact{

    public Bishop() {
        idCurrent = 'B';
        idOther = 'b';
    }
    @Override
    public boolean checkIfValidMove(int xTarget, int yTarget, Board board) {
        boolean canMove = false;
        xTarget += 1;
        yTarget += 1;
        int result = checkDiagonally(xTarget, yTarget, board);
        //No Valid Move
        if (result == 0) {
            System.out.println("Invalid Move, you can only move diagonally with a Bishop.");
        } else if (result == 1) {
            canMove = true;
        }
        debugger(xTarget,yTarget);
        return canMove;
    }
}
