package BoardScripts;

import BoardScripts.TestPiece;

public class Place {
    Boolean isFull;
    TestPiece Piece;
    char displayChar;
    char offChar;
    int[] cords = new int[2];
    int team;

    Place(int[] cords){
        this.cords[0] = cords[0];
        this.cords[1] = cords[1];
        isFull = false;
        displayChar = ' ';
        offChar = ' ';
        team = 0;

    }
    Place(int[] cords,TestPiece A){
        this.cords[0] = cords[0];
        this.cords[1] = cords[1];
        addArtifact(A);
    }
    public void addArtifact(TestPiece A){
        isFull = true;
        Piece = A;
        displayChar = A.getDisplayChar();//sub with a real method soon
        offChar = A.offChar;
        team = A.team;
    }
    public void removeArtifact(){
        Piece = null;
        displayChar = ' ';
        offChar = ' ';
        isFull = false;
    }

    public Boolean getFull() {
        return isFull;
    }
    public void setFull(Boolean full) {
        isFull = full;
    }
    public Object getPiece() {
        return Piece;
    }
    public void setPiece(TestPiece piece) {
        Piece = piece;
    }
    public char getDisplayChar() {
        return displayChar;
    }
    public void setDisplayChar(char displayChar) {
        this.displayChar = displayChar;
    }
    public int[] getCords() {
        return cords;
    }
    public void setCords(int[] cords) {
        this.cords = cords;
    }


    public String toString(int turn){
        String str;
        if(turn == team){
        str= "["+displayChar+"]";
        }else str = "["+offChar+"]";
        return str;
    }
}
