package ArtifactScripts;

import BoardScripts.Board;

public class Pawn extends Artifact{

    public boolean moved = false;

    public Pawn() {
        team = 0;
        idCurrent = 'X';
        idOther = 'y';
    }

    public Pawn(int xPos1, int yPos1, int team1) {
        xPos = xPos1;
        yPos = yPos1;
        team = team1;
        idCurrent = 'X';
        idOther = 'y';
    }

    @Override
    public boolean checkIfValidMove(int xTarget, int yTarget, Board board) {
        boolean canMove = false;
        xTarget += 1;
        yTarget += 1;
        //If target is on the same column
        if (xTarget == xPos) {
            //If target is two spaces away and on same column
            if (Math.abs(yTarget - yPos) == 2) {
                //Check if the Pawn has moved before
                if (moved) {
                    System.out.println("Invalid Move, you can only move two spaces only on the first turn of that Pawn.");
                } else {
                    //Going Down
                    if ((yTarget - yPos) > 0) {
                        if (board.isPlaceFull(new int[]{xPos, yPos + 1})) {
                            System.out.println("Path Blocked, there is a piece in the way, at " + xPos + ", " + (yPos + 1));
                        } else {
                            canMove = true;
                        }
                    //Going Up
                    } else {
                        if (board.isPlaceFull(new int[]{xPos, yPos - 1})) {
                            System.out.println("Path Blocked, there is a piece in the way, at " + xPos + ", " + (yPos - 1));
                        } else {
                            canMove = true;
                        }
                    }
                }
            //If target is one space away and on same column
            } else if (Math.abs(yTarget - yPos) == 1) {
                if (board.isPlaceFull(new int[]{xTarget,yTarget})) {
                    System.out.println("Invalid Move, there is a chess piece in that spot, and a Pawn may not capture whats directly in front of it.");
                    debugger(xTarget,yTarget);
                } else {
                    canMove = true;
                }
            } else {
                System.out.println("Invalid Move, you can only move 1 or 2(on the Pawn's first turn) spaces forwards.");
                debugger(xTarget,yTarget);
            }
        //If target is on the next column over
        } else if (Math.abs(xTarget - xPos) == 1) {
            if ((yTarget - yPos) > 0) {
                if (team == 0) {
                    canMove = true;
                } else if (team == 1) {
                    System.out.println("Invalid Move, you are going the wrong direction.");
                    debugger(xTarget,yTarget);
                }
            } else if ((yTarget - yPos) < 0) {
                if (team == 0) {
                    System.out.println("Invalid Move, you are going the wrong direction.");
                    debugger(xTarget,yTarget);
                } else if (team == 1) {
                    canMove = true;
                }
            } else {
                System.out.println("Invalid Move, you can only move diagonally by attacking, not horizontally.");
                debugger(xTarget,yTarget);
            }
        } else {
            System.out.println("Invalid Move, you can only move 1 or 2(on the Pawn's first turn) spaces forwards, or attack forwards diagonally 1 space away.");
            debugger(xTarget,yTarget);
        }
        return canMove;
    }
}
