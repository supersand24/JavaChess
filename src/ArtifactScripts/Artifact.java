package ArtifactScripts;

import BoardScripts.Board;

public class Artifact {
    public int xPos;
    public int yPos;
    public boolean alive = true;
    public int team;
    public Character idCurrent;
    public Character idOther;

    public void debugger(int xTarget, int yTarget) {
        System.out.println("xPos = " + xPos);
        System.out.println("yPos = " + yPos);
        System.out.println("xTarget = " + xTarget);
        System.out.println("yTarget = " + yTarget);
        System.out.println("xDistance = " + (xTarget - xPos));
        System.out.println("yDistance = " + (yTarget - yPos));
    }

    public boolean checkSpace(int xTarget, int yTarget, Board board) {
        return board.isPlaceFull(new int[]{yTarget - 1,xTarget - 1});
    }

    public String getArtifactName(int xTarget, int yTarget, Board board) {
        return (board.myboard[yTarget-1][xTarget-1].toString(board.getTeam()));
    }

    public void newCoords(int xTarget, int yTarget) {
        xPos = xTarget + 1;
        yPos = yTarget + 1;
    }

    private boolean isPosNum(int num) {
        if (num > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int checkVertical(int xTarget, int yTarget, Board board) {
        int canMove = 0;
        if (xPos == xTarget) {
            //If going north
            if (yTarget - yPos > 0) {
                for (int pos = 1; pos <= yTarget; pos++) {
                    if ((yPos - pos) == yTarget) {
                        canMove = 1;
                        break;
                    } else {
                        if (checkSpace(xPos,yPos + pos,board)) {
                            System.out.println("Path Blocked, there is a " + getArtifactName(xPos, yPos + pos, board) + " in the way, at " + xPos + ", " + (yPos + pos));
                            canMove = 2;
                            break;
                        }
                    }
                }
            //If going South
            } else if (yTarget - yPos < 0) {
                for (int pos = 1; pos <= yTarget; pos++) {
                    if ((yPos - pos) == yTarget) {
                        canMove = 1;
                        break;
                    } else {
                        if (checkSpace(xPos,yPos - pos,board)) {
                            System.out.println("Path Blocked, there is a " + getArtifactName(xPos, yPos - pos, board) + " in the way, at " + xPos + ", " + (yPos - pos));
                            canMove = 2;
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
    public int checkHorizontal(int xTarget, int yTarget, Board board) {
        int canMove = 0;
        if (yPos == yTarget) {
            //If going east
            if (xTarget - xPos > 0) {
                for (int pos = 1; pos <= xTarget; pos++) {
                    if ((xPos + pos) == xTarget) {
                        canMove = 1;
                        break;
                    } else {
                        if (checkSpace(xPos + pos,yPos,board)) {
                            System.out.println("Path Blocked, there is a " + getArtifactName(xPos + pos, yPos, board) + " in the way, at " + (xPos + pos) + ", " + yPos);
                            canMove = 2;
                            break;
                        }
                    }
                }
            //If going west
            } else if (xTarget - xPos < 0) {
                for (int pos = 1; pos <= xTarget; pos++) {
                    if ((xPos - pos) == xTarget) {
                        canMove = 1;
                        break;
                    } else {
                        if (checkSpace(xPos - pos,yPos - pos,board)) {
                            System.out.println("Path Blocked, there is a " + getArtifactName(xPos - pos, yPos, board) + " in the way, at " + (xPos - pos) + ", " + yPos);
                            canMove = 2;
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
    public int checkDiagonally(int xTarget, int yTarget, Board board) {
        int canMove = 0;
        int xDistance = xTarget - xPos;
        int yDistance = yTarget - yPos;
        if (Math.abs(xDistance) == Math.abs(yDistance)) {
            if (isPosNum(xDistance) == true && isPosNum(yDistance) == true) {
                for (int pos = 1; pos <= xDistance; pos++) {
                    if ((xPos + pos) == xTarget && (yPos + pos) == yTarget) {
                        canMove = 1;
                        break;
                    } else {
                        if (checkSpace(xPos + pos,yPos + pos,board)) {
                            System.out.println("Path Blocked, there is a " + getArtifactName(xPos + pos, yPos + pos, board) + " in the way, at " + (xPos + pos) + ", " + (yPos + pos));
                            canMove = 2;
                            break;
                        }
                    }
                }
            } else if (isPosNum(xDistance) == true && isPosNum(yDistance) == false) {
                for (int pos = 1; pos <= xDistance; pos++) {
                    if ((xPos + pos) == xTarget && (yPos - pos) == yTarget) {
                        canMove = 1;
                        break;
                    } else {
                        if (checkSpace(xPos + pos,yPos - pos,board)) {
                            System.out.println("Path Blocked, there is a " + getArtifactName(xPos + pos, yPos - pos, board) + " in the way, at " + (xPos + pos) + ", " + (yPos - pos));
                            canMove = 2;
                            break;
                        }
                    }
                }
            } else if (isPosNum(xDistance) == false && isPosNum(yDistance) == false) {
                for (int pos = 1; pos <= xDistance; pos++) {
                    if ((xPos - pos) == xTarget && (yPos - pos) == yTarget) {
                        canMove = 1;
                        break;
                    } else {
                        if (checkSpace(xPos - pos,yPos - pos,board)) {
                            System.out.println("Path Blocked, there is a " + getArtifactName(xPos - pos, yPos - pos, board) + " in the way, at " + (xPos - pos) + ", " + (yPos - pos));
                            canMove = 2;
                            break;
                        }
                    }
                }
            } else if (isPosNum(xDistance) == false && isPosNum(yDistance) == true) {
                for (int pos = 1; pos <= xDistance; pos++) {
                    if ((xPos - pos) == xTarget && (yPos + pos) == yTarget) {
                        canMove = 1;
                        break;
                    } else {
                        if (checkSpace(xPos - pos,yPos + pos,board)) {
                            System.out.println("Path Blocked, there is a " + getArtifactName(xPos - pos, yPos + pos, board) + " in the way, at " + (xPos - pos) + ", " + (yPos + pos));
                            canMove = 2;
                            break;
                        }
                    }
                }
            }
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
