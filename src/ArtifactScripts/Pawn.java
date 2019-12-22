package ArtifactScripts;

public class Pawn extends Artifact{

    public boolean moved = false;

    public Pawn() {
        xPos = 1;
        yPos = 7;
        team = 0;
        idCurrent = 'X';
        idOther = 'y';
    }

    public Pawn(int xPos, int yPos, int team) {
        xPos = xPos;
        yPos = yPos;
        team = team;
        idCurrent = 'X';
        idOther = 'y';
    }


    public boolean checkIfValidMove(int xTarget, int yTarget) {
        boolean canMove = false;
        //If target is on the same column
        if (xTarget == xPos) {
            //If target is two spaces away and on same column
            if (Math.abs(yTarget - yPos) == 2) {
                //Check if the Pawn has moved before
                if (moved) {
                    System.out.println("Invalid Move, you can only move two spaces only on the first turn of that Pawn.");
                } else {
                    canMove = true;
                }
            //If target is one space away and on same column
            } else if (Math.abs(yTarget - yPos) == 1) {
                canMove = true;
            } else {
                System.out.println("Invalid Move, you can only move 1 or 2(on the Pawn's first turn) spaces forwards.");
            }
        //If target is on the next column over
        } else if (Math.abs(xTarget - xPos) == 1) {
            if ((yTarget - yPos) > 0) {
                if (team == 0) {
                    canMove = true;
                } else if (team == 1) {
                    System.out.println("Invalid Move, you are going the wrong direction.");
                }
            } else if ((yTarget - yPos) < 0) {
                if (team == 0) {
                    System.out.println("Invalid Move, you are going the wrong direction.");
                } else if (team == 1) {
                    canMove = true;
                }
            } else {
                System.out.println("Invalid Move, you can only move diagonally by attacking, not horizontally.");
            }
        } else {
            System.out.println("Invalid Move, you can only move 1 or 2(on the Pawn's first turn) spaces forwards, or attack forwards diagonally 1 space away.");
        }
        return canMove;
    }
}
