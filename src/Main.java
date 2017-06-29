import data_structures.interfaces.iPriorityQueue;
import data_structures.priority_queues.MeldableHeap;

public class Main {

    public static void main(String[] args) {
        iPriorityQueue<Integer> heap = new MeldableHeap<>(Integer::compare);
        heap.add(2);
        heap.add(3);
        heap.add(1);

        System.out.println(heap.size());
        System.out.println(heap.extractMin());

        System.out.println(heap.size());
        System.out.println(heap.extractMin());

        System.out.println(heap.size());
        System.out.println(heap.extractMin());
    }
}
