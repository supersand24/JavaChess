import ArtifactScripts.*;
import BoardScripts.Board;
import BoardScripts.Place;

import java.util.Scanner;
import java.util.Stack;

public class Game {

    public static void main(String[] args) {
        Scanner userIn = new Scanner(System.in);
        Boolean activeGame = false;
        Board GameBoard = new Board();
        intro();

        String[] moveCords;
        Artifact peiceToMove = new Pawn();
        int start[]= new int[2];
        int dest[] = new int[2];
        boolean valid = true;

        do{
            String command;
            //System.out.println("Please enter a command");
            //command = x.nextLine();
            //start the game
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

            System.out.print("Make a move: ");
            String move = userIn.nextLine();
            /*for chess notation moves will be translated
            from notation to numbered moves here the rest
            of the code will run the same way. for now the
            feature is undeveloped.
             */
            moveCords = move.split("\\s+");
            try{
                //note the start coordinates are reversed not sure why the have to be
                start[0]=Integer.parseInt(moveCords[1]);
                start[1]=Integer.parseInt(moveCords[0]);
                dest[0] =Integer.parseInt(moveCords[2]);
                dest[1] =Integer.parseInt(moveCords[3]);
            }catch(Exception e){
                System.out.println("Invalid move: Wrong format please" +
                        " enter 4 digits separated by spaces!");
            }
            try {
                peiceToMove = GameBoard.myboard[start[0]][start[1]].getPiece();
                //debug move id
                System.out.print("you want to move: ");
                System.out.print(GameBoard.myboard[start[0]][start[1]].toString
                        (GameBoard.getTeam()));
                System.out.print(" to ");
                System.out.println("(" + GameBoard.numToChar(dest[0]+1) + "," + (dest[1]+1) + ")");
                //debug legal move Authentication
                peiceToMove.newCoords(start[0],start[1]);
                valid = peiceToMove.checkIfValidMove(dest[0], dest[1], GameBoard);
            }catch(Exception e){
                System.out.println("invalid move: no valid piece to make move!");
            }
            //move method
                if (valid == true) {
                    GameBoard.myboard[dest[1]][dest[0]].addArtifact(peiceToMove);
                    GameBoard.myboard[start[0]][start[1]].removeArtifact();
                    //debug
                    System.out.println("PieceMoved");
                    GameBoard.flipBoard();
                    System.out.println(GameBoard.toString());
                }

        }while(activeGame);

        //exit
        exit();
    }

    private static void intro(){
        System.out.println("Welcome to Java Chess!");

    }
    private static void exit(){
        System.out.println("goodBye!");
        System.exit(1);
    }
    //private static String commandParse(){

    //}
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
}
