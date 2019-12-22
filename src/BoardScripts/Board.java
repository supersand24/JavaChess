package BoardScripts;

import java.util.Arrays;
import java.util.Stack;

public class Board {
    Place[][] myboard;
    int team;//0 = white 1 = black
    int[] width;

    //empty board
    Board(){
        width = new int[] {1,2,3,4,5,6,7,8};
        //height = width;
        team = 0;
        myboard = new Place[8][8];
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                myboard[i][j] = new Place(new int[] {i,j});
            }
        }
    }
    /*Board(Stack<TestPiece>rowOne,Stack<TestPiece>rowTwo/*,
          Stack<TestPiece>rowSev,Stack<TestPiece>rowEig){
        team = 0;
        myboard = new Place[8][8];
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                myboard[i][j] = new Place(new int[] {i,j});
            }
        }
        //if(!rowOne.empty()) rowFill(0,rowOne);
        if(!rowTwo.empty()) rowFill(1,rowTwo);
        //if(!rowSev.empty()) rowFill(6,rowSev);
        //if(!rowEig.empty()) rowFill(7,rowEig);
    }*/
    public void rowFill(int rowN,Stack<TestPiece>row){
        for(int i = 0;i<8;i++) {
            TestPiece cur = row.pop();

            if (cur!=null) {
                myboard[rowN][i].addArtifact(cur);
            }
        }
    }

    public Place[][] getMyboard() {
        return myboard;
    }
    public void setMyboard(Place[][] myboard) {
        this.myboard = myboard;
    }
    public int getTeam() {
        return team;
    }
    public void setTeam(int team) {
        this.team = team;
    }
    public int[] getWidth() {
        return width;
    }
    public void setWidth(int[] width) {
        this.width = width;
    }
    //public int[] getHeight() {
    //    return height;
    //}
    //public void setHeight(int[] height) {
    //    this.height = height;
    //}

    public boolean isPlaceFull(int[] cords){
        return myboard[cords[0]][cords[1]].isFull;
    }
    public void ChangePlace(int[] cords){
        myboard[cords[0]][cords[1]].removeArtifact();
    }
    public void ChangePlace(int[] cords,TestPiece X){
        myboard[cords[0]][cords[1]].removeArtifact();
        myboard[cords[0]][cords[1]].addArtifact(X);
    }
    public void flipBoard(){
        Stack<Integer> mystack = new Stack<Integer>();
        Stack<Place> myPlaces = new Stack<Place>();
        if(team==0) team =1;
        else team = 0;
        for (int i =0;i<8;i++) mystack.push(width[i]);
        for (int i =0;i<8;i++) width[i]=mystack.pop();
        //switch x
        for (int i =0;i<8;i++){
            for(int j=0;j<8;j++) myPlaces.push(myboard[i][j]);
            for(int j=0;j<8;j++) myboard[i][j]=myPlaces.pop();
        }
        //switch y
        for (int i =0;i<8;i++){
            for(int j=0;j<8;j++) myPlaces.push(myboard[j][i]);
            for(int j=0;j<8;j++) myboard[j][i]=myPlaces.pop();
        }
    }
    public char numToChar(int num){
        char c;
        switch(num){
            case 1: c = 'a';
                break;
            case 2: c = 'b';
                break;
            case 3: c = 'c';
                break;
            case 4: c = 'd';
                break;
            case 5: c = 'e';
                break;
            case 6: c = 'f';
                break;
            case 7: c = 'g';
                break;
            case 8: c = 'h';
                break;
            default: c = 'X';
        }
        return c;
    }

    @Override
    public String toString() {
        String str = "";
        System.out.println(str);
        for(int i =7;i>=0;i--){
            str = str+width[i]+' ';
            //System.out.println(str);
            for(int j=0;j<8;j++){
                str = str+myboard[i][j].toString(team);
            }
            str=str+"\n";
        }
        str = str+numToChar(0)+' ';
        for(int i=0;i<8;i++){
            str = str+" "+numToChar(width[i])+" ";
        }
        return str;
    }
}
