import java.util.Scanner;

public class FindSomeFamily {
    public  static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        MyLinkedList list = new MyLinkedList();

        for (int i =0; i<size; i++)
            list.add(in.next().charAt(0));


        String str = in.next();
        MyLinkedList strLi = new MyLinkedList();


        for (int i = 0; i < str.length(); i++) {
            strLi.add(str.charAt(i));
        }

        MyLinkedList count = new MyLinkedList();
       int a = count.findSomeFamily(list,strLi);
        System.out.println(a);
    }
}

class Node<E>{
    E item;
    Node<E> next;
}

class MyLinkedList<E>  {

    private Node<E> first = null;
    private Node<E> head = null;
    int size = 0;

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

    public int findSomeFamily(MyLinkedList list, MyLinkedList str){
        int size = str.size;
        int counter = 0;
        Node<E> headlist = list.head;

            while (headlist.next != null){
                Node<E> temp = headlist, headStr = str.head,p;
                String list1 ="", list2 = "";

                while (headStr != null){

                    list1 += temp.item;
                    list2 += headStr.item;
                    if(temp.next != null)
                        temp = temp.next;
                    headStr = headStr.next;
                }
                boolean chek = check(list2, list1);
                if(chek)
                    counter++;
                headlist = headlist.next;
            }

            return counter > 0 ? counter : -1;
        }

        public boolean check(String str1, String str2){
            int count = 0;
            MyLinkedList list = new MyLinkedList();

            for (int i = 0; i < str1.length(); i++) {
                for (int j = 0; j < str2.length(); j++) {
                    if(str1.charAt(i) == str2.charAt(j)){
                       list.add(str1.charAt(i));
                       count++;
                       break;

                    }
                }
            }
            if ( count == str1.length()) {

                for (int i = 0; i < list.size; i++) {
                    if (!list.get(i).equals(str1.charAt(i)))
                        return false;
                }

                return true;
            }
            return false;
        }

    public boolean remove(E value) {
        if(value == null)
            throw new NullPointerException();
        Node<E> iter = head;
        if(iter == null){
            return false;
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
}
