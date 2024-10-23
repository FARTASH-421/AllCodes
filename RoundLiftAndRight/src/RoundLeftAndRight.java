import java.util.Scanner;

class Node{
    String item;
    Node next;
    Node perv;
    Node(String data){
        this.item = data;
    }
}



public class RoundLeftAndRight {

    Node first = null;
    Node iter = null;

    public void add(String data){

        Node temp = new Node(data);

        if(first == null){
            temp.perv = null;
            iter = temp;
            first = iter;

        }else
            first.perv = null;
            iter.next = temp;
            temp.perv = iter;
            iter = temp;
    }
    public int findPol() {
        int count = 0;

        Node headLeft = first, temp, endLeft = iter;
        Node headRight = first, endRight = iter;
        Node current = first;


        while (current != null) {

            boolean check = checkPal(headLeft , endLeft);
            if (check)
                break;
            check = checkPal(headRight, endRight);
            if (check)
                break;
            else

                count++;
            temp = headLeft;
            headLeft = headLeft.next;
            headLeft.perv = null;
            endLeft.next = temp;
            temp.perv = endLeft;
            endLeft = temp;


            temp = endRight;
            endRight = endRight.perv;
            headRight.perv = temp;
            temp.next = headRight;
            temp.perv = null;
            headRight = temp;

            current = current.next;
        }
    return count;
    }

    public String  get(int i){
        Node temp = first;
        int index = 0;
        if(first == null)
            return null;
        else
            while (temp != null){
                if(i == index)
                    return temp.item;
                else
                    temp= temp.next;
                index++;
            }
            return "Not found";
    }
    public boolean checkPal(Node head, Node last){

        while (head != null && last != null){
            if(!head.item.equals(last.item))
                return false;
            else

                head = head.next;
                last = last.perv;
        }
        return true;
    }



    public void show(){
        Node temp = first;
       while (temp.next!=null){
           System.out.print(temp.item+" ");
           temp = temp.next;
       }
        System.out.println();
    }


}
class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RoundLeftAndRight list = new RoundLeftAndRight();

        int size = in.nextInt();
        for (int i = 0; i < size; i++) {
            list.add(in.next());
        }
       int count =  list.findPol();
        System.out.println(count);

    }
}
