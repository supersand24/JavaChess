package ArtifactScripts;

import BoardScripts.Board;

public class Queen extends Artifact{

    public Queen() {
        idCurrent = 'Q';
        idOther = 'q';
    }

    @Override
    public boolean checkIfValidMove(int xTarget, int yTarget, Board board) {
        boolean canMove = false;
        xTarget += 1;
        yTarget += 1;
        int result = checkVertical(xTarget, yTarget, board) + checkHorizontal(xTarget, yTarget, board) + checkDiagonally(xTarget, yTarget, board);
        if (result == 0) {
            System.out.println("Invalid Move, you can only move horizontally, vertically, or diagonally with a Queen.");
        } else if (result == 1){
            canMove = true;
        }
        debugger(xTarget,yTarget);
        return canMove;
    }
}
