public class Driver {
    public static void main(String[] args) {
        KnightBoard test = new KnightBoard(4, 4);
        System.out.println(test + "\n");
        test = new KnightBoard(10, 4);
        System.out.println(test + "\n");

        try {
            test = new KnightBoard(3, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception Caught!\n");
        } try {
            test = new KnightBoard(-4, 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception Caught!\n");
        } try {
            test = new KnightBoard(0, -4);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception Caught!\n");
        }

        /*
        test.board[0][0] = 4;
        test.board[0][3] = 23;
        test.isBlank = false;
        System.out.println(test + "\n");
        */


    }
}
