public class Option implements Comparable<Option> {

    private int rowInc, colInc, val;
    //RowInc is the amount needed to get from the knight square to the option in question
    //ColInc is the amount needed to get from the knight square to the option in question
    //Val is the value of the option (the number of outgoing possible moves)

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
        return getVal() - other.getVal();
    }
}
