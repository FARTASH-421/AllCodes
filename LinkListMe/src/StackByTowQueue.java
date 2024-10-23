class Node1<E>{
    E data;
    Node1<E> next;
    Node1<E> prev;
}

class Queue<E>{
    private Node1<E> head = null;
    private Node1 iter = null;
    public int size = 0;

    public void push(E value){
        size++;
        Node1 temp = new Node1();
        temp.data = value;
        if(head == null){
            iter = temp;
            head = iter;
        }else
            iter.next = temp;
        temp.prev = iter;
        iter = temp;
    }
    public E pop(){
        if(head == null)
            return null;
        size--;
        Node1 temp = head;
        head = head.next;
        return (E) temp.data;
    }

    public boolean isEmpty(){
        if(size == 0)
            return true;
        else
            return false;
    }


    public void show(){
        if(head == null)
            System.out.println("isEmpty");
        Node1 temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Stack<E>{

    private Queue q1 = new Queue();
    private Queue q2 = new Queue();
    private int size = 0;

    public void push(E value){
        size++;
        q1.push(value);

    }

    public E pop (){

        if(q1.isEmpty())
            return null;

        size--;
        int counter = 0;
        while (counter < size) {
            q2.push(q1.pop());
            counter++;
        }
        E temp = (E) q1.pop();
        Queue iter = q1 = q2;
        q2 = iter;
        return temp;
    }

    public void show(){
        q1.show();
    }

}


public class StackByTowQueue{
    public static void main(String[] args) {



    }
}