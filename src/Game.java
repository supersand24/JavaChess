import BoardScripts.Board;
import BoardScripts.Place;

import java.util.Scanner;
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
        //building White pieces
        //building black Pawns
        //building black pieces

        //rowfill all!

        System.out.println("The Game Has begun!");
        System.out.println(b.toString());
        return b;

    }
}
