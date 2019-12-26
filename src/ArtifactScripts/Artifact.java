package ArtifactScripts;

import BoardScripts.Board;

public class Artifact {
    public int xPos;
    public int yPos;
    public boolean alive = true;
    public int team;
    public Character idCurrent;
    public Character idOther;

    public void newCoords(int xTarget, int yTarget) {
        xPos = xTarget;
        yPos = yTarget;
    }

    public boolean checkVertical(int xTarget, int yTarget, Board board) {
        boolean canMove = false;
        if (xPos == xTarget) {
            //If going north
            if (yTarget - yPos > 0) {
                for (int pos = 1; pos <= yTarget; pos++) {
                    if (board.isPlaceFull(new int[]{xPos, (yPos + pos)})) {
                        System.out.println("Path Blocked, there is a piece in the way, at " + xPos + ", " + (yPos + pos));
                        break;
                    } else {
                        if ((yPos + pos) == yTarget) {
                            canMove = true;
                            break;
                        }
                    }
                }
            //If going South
            } else if (yTarget - yPos < 0) {
                for (int pos = 1; pos <= yTarget; pos++) {
                    if (board.isPlaceFull(new int[]{xPos, (yPos - pos)})) {
                        System.out.println("Path Blocked, there is a piece in the way, at " + xPos + ", " + (yPos - pos));
                        break;
                    } else {
                        if ((yPos - pos) == yTarget) {
                            canMove = true;
                            break;
                        }
                    }
                }
            //Error
            } else {
                System.out.println("ERROR: checkVertical() tried to check horizontally.");
            }
        }
        return canMove;
    }
    public boolean checkHorizontal(int xTarget, int yTarget, Board board) {
        boolean canMove = false;
        if (yPos == yTarget) {
            //If going east
            if (xTarget - xPos > 0) {
                for (int pos = 1; pos <= (Math.abs(xTarget - xPos)); pos++) {
                    if (board.isPlaceFull(new int[]{(xPos + pos), yPos})) {
                        System.out.println("Path Blocked, there is a piece in the way, at " + (xPos + pos) + ", " + yPos);
                        break;
                    } else {
                        if ((xPos + pos) == xTarget) {
                            canMove = true;
                            break;
                        }
                    }
                }
            //If going west
            } else if (xTarget - xPos < 0) {
                for (int pos = 1; pos <= (Math.abs(xTarget - xPos)); pos++) {
                    if (board.isPlaceFull(new int[]{(xPos - pos), yPos})) {
                        System.out.println("Path Blocked, there is a piece in the way, at " + (xPos - pos) + ", " + yPos);
                        break;
                    } else {
                        if ((xPos - pos) == xTarget) {
                            canMove = true;
                            break;
                        }
                    }
                }
            //Error
            } else {
                System.out.println("ERROR: checkHorizontal() tried to check vertically.");
            }
        }
        return canMove;
    }
    public boolean checkDiagonally(int xTarget, int yTarget, Board board) {
        boolean canMove = false;
        //If going Northeast
        if (xTarget > xPos && yTarget > yPos) {
            for (int pos = 1; pos <= (xTarget - xPos); pos++){
                if (board.isPlaceFull(new int[]{(xPos + pos),(yPos + pos)})) {
                    System.out.println("Path Blocked, there is a piece in the way, at " + (xPos + pos) + ", " + (yPos + pos));
                    break;
                } else {
                    if ((xPos + pos) == xTarget && (yPos + pos) == yTarget) {
                        canMove = true;
                        break;
                    }
                }
            }
        //If going Southeast
        } else if (xTarget > xPos && yTarget < yPos) {
            for (int pos = 1; pos <= (xTarget - xPos); pos++){
                if (board.isPlaceFull(new int[]{(xPos + pos),(yPos + pos)})) {
                    System.out.println("Path Blocked, there is a piece in the way, at " + (xPos + pos) + ", " + (yPos - pos));
                    break;
                } else {
                    if ((xPos + pos) == xTarget && (yPos - pos) == yTarget) {
                        canMove = true;
                        break;
                    }
                }
            }
        //If going Southwest
        } else if (xTarget < xPos && yTarget < yPos) {
            for (int pos = 1; pos <= (xTarget - xPos); pos++){
                if (board.isPlaceFull(new int[]{(xPos + pos),(yPos + pos)})) {
                    System.out.println("Path Blocked, there is a piece in the way, at " + (xPos - pos) + ", " + (yPos - pos));
                    break;
                } else {
                    if ((xPos - pos) == xTarget && (yPos - pos) == yTarget) {
                        canMove = true;
                        break;
                    }
                }
            }
        //If going Northwest
        } else if (xTarget < xPos && yTarget > yPos) {
            for (int pos = 1; pos <= (xTarget - xPos); pos++){
                if (board.isPlaceFull(new int[]{(xPos + pos),(yPos + pos)})) {
                    System.out.println("Path Blocked, there is a piece in the way, at " + (xPos - pos) + ", " + (yPos + pos));
                    break;
                } else {
                    if ((xPos - pos) == xTarget && (yPos + pos) == yTarget) {
                        canMove = true;
                        break;
                    }
                }
            }
        //Error
        } else {
            System.out.println("ERROR: checkDiagonally() tried to check horizontally or vertically.");
        }
        return canMove;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public boolean checkIfValidMove(int xTarget, int yTarget, Board board){
        System.out.println("Validity unknown!");
        return false;
    }
}
