import data_structures.interfaces.iPriorityQueue;
import data_structures.priority_queues.BinaryHeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(5 - i);
        }

        Collections.shuffle(list);

        iPriorityQueue<Integer> queue = new BinaryHeap<>(list, Integer::compareTo);

        while (queue.isNonEmpty()){
            System.out.println(queue.extractMin());
        }
    }
}
