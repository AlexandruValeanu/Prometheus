import data_structures.tuple.TupleInt;

public class Main {

    public static void main(String[] args) {
        TupleInt tupleInt = TupleInt.valueOf(1, 2, 3);
        TupleInt tupleInt1 = TupleInt.valueOf(1, 3);

        System.out.println(tupleInt.compareTo(tupleInt1));
    }
}
