public class Place {
    Boolean isFull;
    TestPiece Piece;
    char displayChar;
    int[] cords = new int[2];

    Place(int[] cords){
        this.cords[0] = cords[0];
        this.cords[1] = cords[1];
        isFull = false;
        displayChar = ' ';

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
    }
    public void removeArtifact(){
        Piece = null;
        displayChar = ' ';
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

    @Override
    public String toString(){
        String str = "["+displayChar+"]";
        return str;
    }
}
