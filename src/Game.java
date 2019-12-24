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

        do{
            String command;
            //System.out.println("Please enter a command");
            //command = x.nextLine();
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

            //activeGame = commandParse(userIn,activeGame);
        }while(activeGame);
        System.out.println("goodBye!");
        System.exit(1);
    }

    private static void intro(){
        System.out.println("Welcome to Java Chess!");

    }
    private static void exit(){
        System.out.println("goodBye!");
        System.exit(1);
    }
    //private static boolean commandParse(){

    //}
    private static Board startGame(Board b){
        b = new Board();
        //building White pawns
        Stack<Artifact> wPawns = new Stack<Artifact>();
        for(int i = 0; i<8;i++) wPawns.push(new Pawn());
        //building White pieces
        Stack<Artifact> wArts = new Stack<Artifact>();
        wArts.push(new Rook());wArts.push(new Knight());
        wArts.push(new Bishop());wArts.push(new Queen());
        wArts.push(new King());wArts.push(new Bishop());
        wArts.push(new Knight());wArts.push(new Rook());

        //building black Pawns note teams are not set here
        Stack<Artifact> bPawns = new Stack<Artifact>();
        for(int i = 0; i<8;i++) bPawns.push(new Pawn());
        //building black pieces
        Stack<Artifact> bArts = new Stack<Artifact>();
        bArts.push(new Rook());bArts.push(new Knight());
        bArts.push(new Bishop());bArts.push(new Queen());
        bArts.push(new King());bArts.push(new Bishop());
        bArts.push(new Knight());bArts.push(new Rook());

        //rowfill all!
        b.rowFill(0,wArts);
        //setBlack


        System.out.println("The Game Has begun!");
        System.out.println(b.toString());
        return b;

    }
}
