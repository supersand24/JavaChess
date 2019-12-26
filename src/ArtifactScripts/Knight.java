package ArtifactScripts;

import BoardScripts.Board;

public class Knight extends Artifact{

    public Knight() {
        xPos = 2;
        yPos = 8;
        idCurrent = 'N';
        idOther = 'n';
    }

    public boolean checkIfValidMove(int xTarget, int yTarget, Board board) {
        boolean canMove = false;
        if (Math.abs(yTarget - yPos) == 2 && Math.abs(xTarget - xPos) == 1) {
            canMove = true;
        } else if (Math.abs(xTarget - xPos) == 2 && Math.abs(yTarget - yPos) == 1) {
            canMove = true;
        } else {
            System.out.println("Invalid Move, you can only move in an L shape with a Knight, 2 spaces any direction and 1 sideways.");
        }
        return canMove;
    }

}
