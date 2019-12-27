import ArtifactScripts.*;
import BoardScripts.Board;
import BoardScripts.Place;

import java.util.Scanner;
import java.util.Stack;

public class Game {

    public static void main(String[] args) {
        //<editor-fold desc="vars">
        Scanner userIn = new Scanner(System.in);
        Boolean activeGame = false;
        Board GameBoard = new Board();
        String command = "";
        intro();

        String[] moveCords;
        Artifact peiceToMove = new Pawn();
        int start[]= new int[2];
        int dest[] = new int[2];
        boolean valid = true;
        //</editor-fold>
        do{
            //start the game
            GameBoard = inactiveGame(activeGame,command,userIn,GameBoard);
            activeGame = true;

            System.out.print("Make a move: ");
            String move = userIn.nextLine();
            /*for chess notation moves will be translated
            from notation to numbered moves here the rest
            of the code will run the same way. for now the
            feature is undeveloped.
             */
            moveCords = move.split("\\s+");
            Boolean validInput = validMoveInput(moveCords);
            if(!validInput) continue;
            //note the start coordinates are reversed not sure why the have to be
            start[0]=Integer.parseInt(moveCords[1]);
            start[1]=Integer.parseInt(moveCords[0]);
            dest[0] =Integer.parseInt(moveCords[2]);
            dest[1] =Integer.parseInt(moveCords[3]);

            peiceToMove = GameBoard.myboard[start[0]][start[1]].getPiece();
            //is actual piece
            Boolean real = isReal(peiceToMove);
            if(!real) continue;
            //debug move id
            debugID(GameBoard,start,dest);
            //debug legal move Authentication
            peiceToMove.newCoords(start[1],start[0]);
            valid = peiceToMove.checkIfValidMove(dest[0], dest[1], GameBoard);

            //move method
            if (valid&&real) {
                    GameBoard = move(peiceToMove,start,dest,GameBoard);
                }

        }while(activeGame);

        //exit
        exit();
    }

    //verification methods
    private static boolean isReal(Artifact peiceToMove) {
        try {
            if (peiceToMove.idCurrent.equals(' ')) {
                System.out.println("not a valid piece!");
                return false;
            }
        }catch(Exception e){
            System.out.println("not a valid piece!");
            return false;
        }
        return true;
    }
    private static boolean validMoveInput(String[] in){
        try{
            int[] s = new int[4];
            s[0]=Integer.parseInt(in[1]);
            s[1]=Integer.parseInt(in[0]);
            s[0] =Integer.parseInt(in[2]);
            s[1] =Integer.parseInt(in[3]);
        }catch(Exception e){
            System.out.println("Invalid move: Wrong format please" +
                    " enter 4 digits separated by spaces!");
            return false;
        }
        return true;
    }
    //debug methods
    private static void debugID(Board GameBoard,int[] start,int[]dest) {
        if (GameBoard.getTeam() == 1){
         start = reverseAllNums(start);
         dest = reverseAllNums(dest);
        }
        System.out.print("you want to move: ");
        System.out.print(GameBoard.myboard[start[0]][start[1]].toString
                (GameBoard.getTeam()));
        System.out.print(" to ");
        System.out.println("(" + GameBoard.numToChar(dest[0]+1) + "," + (dest[1]+1) + ")");

    }

    //these methods change game state
    private static void intro(){
        System.out.println("Welcome to Java Chess!");

    }
    private static Board inactiveGame(Boolean activeGame,String command,Scanner userIn,Board GameBoard){
        while(!activeGame){
            System.out.print("Shall we play a game?\nY/N:");
            command = userIn.nextLine();
            if(command.equalsIgnoreCase("y")){
                GameBoard = startGame(GameBoard);
                activeGame = true;
            }else if(command.equalsIgnoreCase("n")){
                System.out.println("Alright");
                userIn.close();
                exit();

            }else
                System.out.println("invalid command!");
        }
        return GameBoard;
    }
    private static Board startGame(Board b){
        b = new Board();
        //building White pawns
        Stack<Artifact> wPawns = new Stack<Artifact>();
        for(int i = 0; i<8;i++) wPawns.push(new Pawn());
        //building White pieces
        Stack<Artifact> wArts = new Stack<Artifact>();
        wArts.push(new Rook());wArts.push(new Knight());
        wArts.push(new Bishop());wArts.push(new King());
        wArts.push(new Queen());wArts.push(new Bishop());
        wArts.push(new Knight());wArts.push(new Rook());

        //building black Pawns note teams are not set here
        Stack<Artifact> bPawns = new Stack<Artifact>();
        for(int i = 0; i<8;i++) bPawns.push(new Pawn());
        //building black pieces
        Stack<Artifact> bArts = new Stack<Artifact>();
        bArts.push(new Rook());bArts.push(new Knight());
        bArts.push(new Bishop());bArts.push(new King());
        bArts.push(new Queen());bArts.push(new Bishop());
        bArts.push(new Knight());bArts.push(new Rook());

        //rowfill all!
        b.rowFill(0,wArts);
        b.rowFill(1,wPawns);
        b.rowFill(6,bPawns);
        b.rowFill(7,bArts);
        //setBlack
        for(int j=7;j>5;j--){
            for(int i = 0;i<8;i++) {
                Artifact cur = b.myboard[j][i].getPiece();
                cur.setTeam(1);
                b.myboard[j][i].addArtifact(cur);
            }
        }

        System.out.println("The Game Has begun!");
        System.out.println(b.toString());
        return b;

    }
    private static void exit(){
        System.out.println("goodBye!");
        System.exit(1);
    }
    //private static String commandParse(){

    //}

    //board manipulation methods
    private static Board move(Artifact peiceToMove, int start[],int dest[],Board GameBoard){
        GameBoard.myboard[dest[1]][dest[0]].addArtifact(peiceToMove);
        GameBoard.myboard[start[0]][start[1]].removeArtifact();
        //debug
        System.out.println("PieceMoved");
        GameBoard.flipBoard();
        System.out.println(GameBoard.toString());
        return GameBoard;
    }

    //Other methods
    public static int[] reverseAllNums(int[] toRev){
        int[] reved = new int[toRev.length];
        for (int i=0;i<toRev.length;i++) {
            switch (toRev[i]){
                case 0:
                    reved[i] = 7;
                    break;
                case 1:
                    reved[i] = 6;
                    break;
                case 2:
                    reved[i] = 5;
                    break;
                case 3:
                    reved[i] = 4;
                    break;
                case 4:
                    reved[i] = 3;
                    break;
                case 5:
                    reved[i] = 2;
                    break;
                case 6:
                    reved[i] = 1;
                    break;
                case 7:
                    reved[i] = 0;
                    break;
                default:reved[i] = 9;
            }

        }
        return reved;
    }
}
