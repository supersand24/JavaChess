package BoardScripts;

public class PlaceTester {
    public static void main(String[] args) {
        System.out.println("This is the place tester");
        Place myPlace = new Place(new int[]{0,0});
        System.out.print(myPlace.toString());
        TestPiece myPiece = new TestPiece();
        Place myFullP = new Place(new int[]{0,1},myPiece);
        System.out.println(myFullP);

    }
}
