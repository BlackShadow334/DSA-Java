package data_structure;

import java.util.NoSuchElementException;

public class UserLInkedList {
    private class Node {
        private int value;
        private Node next;

        Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    UserLInkedList(){
    }

    public void addFirst(int value){
        Node temp = new Node(value);
        if (isEmpty())
            first = last = temp;
        else {
            temp.next = first;
            first = temp;
        }
        size++;
    }

    public void addLast(int value){
        Node temp = new Node(value);
        if (isEmpty())
            first = last = temp;
        else{
            last.next = temp;
            last = temp;
        }
        size++;
    }

    public void deleteFirst(){
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last)
            first = last = null;
        else{
            Node ptr = first.next;
            first.next = null;
            first = ptr;
        }
        size--;
    }

    public void deleteLast(){
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last)
            first = last  = null;
        else{
            Node ptr = getPreviousNode(last);
            ptr.next = null;
            last = ptr;
        }
        size--;
    }

    public int indexOf(int value){
        Node ptr = first;
        int count = 0;
        while (ptr != null){
            if (ptr.value == value) return  count;
            ptr = ptr.next;
            count++;
        }
        return -1;
    }

    public boolean contains(int value){
        return indexOf(value) != -1;
    }

    public void print(){
        Node ptr = first;
        while (ptr != null){
            System.out.println(ptr.value);
            ptr = ptr.next;
        }
    }

    public int getSize(){
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        Node ptr = first;
        int i = 0;
        while (ptr != null){
            array[i++] = ptr.value;
            ptr = ptr.next;
        }
        return array;
    }

    public void reverse(){
        if (isEmpty() || first == last) return;
        if (first.next.next == null){
            last.next = first;
            first.next = null;
            Node temp = first;
            first = last;
            last = temp;
            return;
        }
        Node previous = first;
        Node ptr = first.next;
        while (ptr.next != null){
            Node temp = ptr.next;
            ptr.next = previous;
            previous = ptr;
            ptr = temp;
        }
        last.next = previous;

        Node temp = first;
        first.next = null;
        first = last;
        last = temp;
    }

    public int getKthFromTheEnd(int k){
        if (isEmpty()) throw new IllegalStateException();
        Node ptr1 = first;
        Node ptr2 = first;
        for (int i = 0; i < k - 1; i++){
            ptr2 = ptr2.next;
            if (ptr2 == null) throw new IllegalArgumentException();
        }

        while (ptr2 != last){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1.value;
    }

    private boolean isEmpty(){
        return first == null;
    }

    private Node getPreviousNode(Node node){
        Node ptr = first;
        while (ptr != null){
            if (ptr.next == node) return ptr;
            ptr = ptr.next;
        }
        return null;
    }
}

