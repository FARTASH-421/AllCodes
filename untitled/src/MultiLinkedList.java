class Node{
    int data;
    Node head;
    Node next ;
    Node prev;
    Node up ;
    Node down;
    public Node(int item){
        this.data = item;
    }



}


//    private Node<E> first = null;
//    private Node<E> head = null;
//    private int size = 0;
//
//    public void add(E value) {
//        size++;
//        Node<E> temp = new Node<>(value);
//        if(first == null){
//            first = temp;
//            head = temp;
//            return;
//        }
//
//        first.next = temp;
//        first  = temp;
//    }

public class MultiLinkedList {

    private static Node next = null;
    private static Node prev = null;
    private static Node up = null;
    private static Node down = null;
    private static Node head = null;


    static Node NotReversFun(int [][] arr,int m, int n)
    {
        Node temp = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp = new Node(arr[i][j]);
                next.next = temp;
                next  = temp;
            }
            temp.down = temp;
            down = temp;
        }

        return temp;

    }


}