package ArtifactScripts;

import BoardScripts.Board;

public class Queen extends Artifact{

    public Queen() {
        xPos = 4;
        yPos = 8;
        idCurrent = 'Q';
        idOther = 'q';
    }

    @Override
    public boolean checkIfValidMove(int xTarget, int yTarget, Board board) {
        boolean canMove = false;
        if (checkVertical(xTarget, yTarget, board) || checkHorizontal(xTarget, yTarget, board) || checkDiagonally(xTarget, yTarget, board)) {
            canMove = true;
        } else {
            System.out.println("Invalid Move, you can only move horizontally, vertically, or diagonally with a Queen.");
        }
        return canMove;
    }
}
