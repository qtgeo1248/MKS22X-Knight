public class Driver {
    public static void main(String[] args) {
        KnightBoard test = new KnightBoard(4, 4);
        System.out.println(test + "\n");
        test = new KnightBoard(10, 4);
        System.out.println(test + "\n");

        try {
            test = new KnightBoard(3, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception Caught1!\n");
        } try {
            test = new KnightBoard(-4, 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception Caught2!\n");
        } try {
            test = new KnightBoard(0, -4);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception Caught3!\n");
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
        System.out.println(test.solve(1, 0));
        System.out.println(test + "\n");
        test = new KnightBoard(10, 2);
        System.out.println(test.solve(0, 0));
        System.out.println(test + "\n");
        test = new KnightBoard(1, 1);
        System.out.println(test.solve(0, 0));
        System.out.println(test + "\n");
        test = new KnightBoard(3, 4);
        System.out.println(test.solve(0, 0));
        System.out.println(test + "\n");
        /* this is literally too long to keep testing everytime
        test = new KnightBoard(8, 5);
        System.out.println(test.solve(4, 2));
        System.out.println(test + "\n");
        */

        try {
            test.solve(0, 0);
        } catch (IllegalStateException e) {
            System.out.println("Exception Caught4!\n");
        } try {
            test = new KnightBoard(5, 5);
            test.solve(0, 0);
            test.solve(0, 0);
        } catch (IllegalStateException e) {
            System.out.println("Exception Caught5!\n");
        } try {
            test = new KnightBoard(5, 5);
            test.solve(2, -4);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception Caught6!\n");
        } try {
            test = new KnightBoard(5, 5);
            test.solve(2, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception Caught7!\n");
        }

        try {
            test.solve(0, 0);
            test.countSolutions(0, 0);
        } catch (IllegalStateException e) {
            System.out.println("Exception Caught8!\n");
        } try {
            test = new KnightBoard(5, 5);
            test.solve(0, 0);
            test.countSolutions(0, 0);
        } catch (IllegalStateException e) {
            System.out.println("Exception Caught9!\n");
        } try {
            test = new KnightBoard(5, 5);
            test.countSolutions(2, -4);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception Caught0!\n");
        } try {
            test = new KnightBoard(5, 5);
            test.countSolutions(2, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception Caught1!\n");
        }

        test = new KnightBoard(3, 3);
        int total = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                total += test.countSolutions(i, j);
            }
        }
        System.out.println(test);
        System.out.println("3 by 3 all: " + total + "\n");
        test = new KnightBoard(1, 1);
        System.out.println("1 by 1, (0, 0): " + test.countSolutions(0, 0) + "\n");
        test = new KnightBoard(5, 5);
        System.out.println("5 by 5, (0, 0): " + test.countSolutions(0, 0) + "\n"); //tested this case with THE Vincent Fongtastic
        test = new KnightBoard(3, 4);
        System.out.println("3 by 4, (0, 0): " + test.countSolutions(0, 0) + "\n"); //tested this case with THE stuyVincent Fong
    }
}
