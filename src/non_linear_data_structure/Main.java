package non_linear_data_structure;

public class Main {
    public static void main(String[] args){
        Heap heap = new Heap(10);

        heap.insert(20);
        heap.insert(15);
        heap.insert(25);
        heap.insert(10);
        heap.insert(30);
        heap.insert(5);
        heap.insert(3);
        heap.insert(35);
        heap.insert(2);
        heap.insert(1);

        int a = heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        System.out.println(a);
        System.out.println(heap);
    }
}
