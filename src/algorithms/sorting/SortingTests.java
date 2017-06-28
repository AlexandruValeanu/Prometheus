package algorithms.sorting;

class SortingTests {
    private SortingTests(){
    }

    public static void main(String[] args){
        assert SortingUtility.isSorted(new int[]{1, 2, 2, 3, 3});
        assert !SortingUtility.isSorted(new int[]{1, 2, 4, 3, 3});
    }
}
