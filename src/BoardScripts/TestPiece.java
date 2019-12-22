package BoardScripts;

public class TestPiece {
char displayChar;
char offChar;
int team;
    TestPiece(){
        this.displayChar = 'X';
        offChar = 'y';
        team = 0;
    }
    TestPiece(int x){
        displayChar = 'X';
        offChar = 'y';
        team = x;
    }

    public char getDisplayChar() {
        return displayChar;
    }

    public void setDisplayChar(char displayChar) {
        this.displayChar = displayChar;
    }


}
