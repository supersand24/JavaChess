package ArtifactScripts;

import BoardScripts.Board;

public class Bishop extends Artifact{

    public Bishop() {
        xPos = 3;
        yPos = 8;
        idCurrent = 'B';
        idOther = 'b';
    }
    @Override
    public boolean checkIfValidMove(int xTarget, int yTarget, Board board) {
        boolean canMove = false;
        if (checkDiagonally(xTarget, yTarget, board)) {
            canMove = true;
        } else {
            System.out.println("Invalid Move, you can only move diagonally with a Bishop.");
        }
        return canMove;
    }
}
