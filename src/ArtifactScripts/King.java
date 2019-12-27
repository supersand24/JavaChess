package ArtifactScripts;

import BoardScripts.Board;

public class King extends Artifact {

    public King() {
        idCurrent = 'K';
        idOther = 'k';
    }

    public boolean checkIfValidMove(int xTarget, int yTarget, Board board) {
        boolean canMove = false;
        xTarget += 1;
        yTarget += 1;
        int result = 0;
        if (Math.abs(xTarget - xPos) <= 1 || Math.abs(yTarget - yPos) <= 1) {
            result = checkVertical(xTarget, yTarget, board) + checkHorizontal(xTarget, yTarget, board) + checkDiagonally(xTarget, yTarget, board);
            if (result == 0) {
                System.out.println("Invalid Move, you can only move horizontally, vertically, or diagonally 1 space with a King.");
            } else if (result == 1) {
                canMove = true;
            }
        }
        debugger(xTarget,yTarget);
        return canMove;
    }

}
