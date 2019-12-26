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
        if (checkDiagonally(xTarget, yTarget, board)) {
            canMove = true;
        } else {
            System.out.println("Invalid Move, you can only move diagonally with a Bishop.");
        }
        debugger(xTarget,yTarget);
        return canMove;
    }
}
