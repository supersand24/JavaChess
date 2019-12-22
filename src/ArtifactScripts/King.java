package ArtifactScripts;

import BoardScripts.Board;

public class King extends Artifact {

    public King() {
        xPos = 5;
        yPos = 8;
        idCurrent = 'K';
        idOther = 'k';
    }

    public boolean checkIfValidMove(int xTarget, int yTarget, Board board) {
        boolean canMove = false;
        if (Math.abs(xTarget - xPos) <= 1 || Math.abs(yTarget - yPos) <= 1) {
            if (checkVertical(xTarget, yTarget, board) || checkHorizontal(xTarget, yTarget, board) || checkDiagonally(xTarget, yTarget, board)) {
                canMove = true;
            } else {
                System.out.println("Invalid Move, you can only move horizontally, vertically, or diagonally 1 space with a King.");
            }
        }
        return canMove;
    }

}
