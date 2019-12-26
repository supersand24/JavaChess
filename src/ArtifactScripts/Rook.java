package ArtifactScripts;

import BoardScripts.Board;

public class Rook extends Artifact{

    public Rook() {
        idCurrent = 'R';
        idOther = 'r';
    }

    @Override
    public boolean checkIfValidMove(int xTarget, int yTarget, Board board) {
        boolean canMove = false;
        xTarget += 1;
        yTarget += 1;
        if (checkVertical(xTarget, yTarget, board) || checkHorizontal(xTarget, yTarget, board)) {
            canMove = true;
        } else {
            System.out.println("Invalid Move, you can only move horizontally or vertically with a Rook.");
        }
        debugger(xTarget,yTarget);
        return canMove;
    }
}
