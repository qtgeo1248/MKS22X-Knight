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
        test = new KnightBoard(5, 5);
        System.out.println(test.solve(0, 0));
        //System.out.println("isBlank " + test.isBlank);
        System.out.println(test + "\n");

        test = new KnightBoard(5, 5);
        System.out.println(test.solve(0, 0));
        System.out.println(test + "\n");
        test = new KnightBoard(3, 3);
        System.out.println(test.solve(0, 0));
        System.out.println(test + "\n");
        test = new KnightBoard(10, 2);
        System.out.println(test.solve(0, 0));
        System.out.println(test + "\n");
        test = new KnightBoard(1, 1);
        System.out.println(test.solve(0, 0));
        System.out.println(test + "\n");
        test = new KnightBoard(8, 5);
        System.out.println(test.solve(4, 2));
        System.out.println(test + "\n");
    }
}
