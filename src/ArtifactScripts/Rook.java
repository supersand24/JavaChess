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
        int result = checkVertical(xTarget, yTarget, board) + checkHorizontal(xTarget, yTarget, board);
        if (result == 0) {
            System.out.println("Invalid Move, you can only move horizontally or vertically with a Rook.");
        } else if (result == 1){
            canMove = true;
        }
        debugger(xTarget,yTarget);
        return canMove;
    }
}
