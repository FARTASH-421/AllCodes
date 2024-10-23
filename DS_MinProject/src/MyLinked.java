
class Node1<E>{
    E item;
    Node<E> next;
}


public class MyLinked<E>  {

    private Node<E> first = null;
    private Node<E> head = null;
    private int size = 0;



    public void add(E value) {
        size++;
        Node<E> temp = new Node<>();
        temp.item = value;
        if(first == null){
            first = temp;
            head = temp;
            return;
        }

         first.next = temp;
         first  = temp;
    }


    public boolean remove(E value) {
        if(value == null)
            throw new NullPointerException();

        Node<E> iter = head;
        if(iter == null){
            return false;
        }
        if(iter.item.equals(value)){
            head = head.next;
            size--;
            return true;
        }
        while(iter.next!=null){
            if(iter.next.item.equals(value)){
                iter.next = iter.next.next;
                size--;
                return true;
            }
            iter = iter.next;
        }
        return false;
    }


    public E get(int index) {

        if(index < 0 || index > size-1 )
            throw new NullPointerException();
        Node<E> iter =head;
        if(iter == null){
            return null;
        }
        int i = 0;
        while(iter != null){
            if(i == index){
                return (iter.item);
            }else
                i++;
                iter = iter.next;

        }
        return null;
    }



    public int size() {
        return size;
    }

}


class Tests{
    public static void main(String[] args) {
        MyLinked list = new MyLinked();
        list.add(2);
        list.add(3);
//        list.add(8);
//        list.remove(3);
        list.add(9);
        list.add(8);
        list.remove(8);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" , ");
        }

    }
}