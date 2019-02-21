public class Option implements Comparable<Option> {

    private int rowInc, colInc, val;

    public Option(int rowPlus, int colPlus, int newVal) {
        rowInc = rowPlus;
        colInc = colPlus;
        val = newVal;
    }

    public int getVal() {
        return val;
    }
    public int getRowInc() {
        return rowInc;
    }
    public int getColInc() {
        return colInc;
    }

    public int compareTo(Option other) {
        return 0;
    }
}
