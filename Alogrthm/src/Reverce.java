import java.util.Scanner;
class Node{
    String data;
    Node next;
}
public class Reverce {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int k = in.nextInt();
        Node head = new Node();

       Baraxeshkon(head, k, n);
       head = head.next;
       while (head != null)
       {
           System.out.print(head.data);
           head = head.next;
       }

    }

    public static Node Baraxeshkon(Node head, int k, int n) {
        in.nextLine();
        Node iter = head;
        String sr = in.nextLine();
        String[] arr = sr.split(" ");


        for (int i = 0; i < n; i++) {
            int numRe = in.nextInt();
            arr = revers(arr,numRe);
        }

        for (String s: arr) {
            Node temp = new Node();
            temp.data = s;
            if(head == null){
                head = temp;
                iter = head;
            }else {
                iter.next = temp;
                iter = temp;
            }

        }
        return head ;
    }

    private static String[] revers(String[] arr, int numRe) {
        int size = arr.length;
        int index = numRe-1, j = 0,k=2;

        for (int i = 0; i <size ; i++) {
            if(index>j && index<size) {
                String temp = arr[j];
                arr[j] = arr[index];
                arr[index] = temp;
                j++;
                index--;
            }else {
                index = (k) * numRe -1;
                k++;
                j = (index - numRe) + 1;
                if(index >= size)
                    break;
            }
        }
        return arr;
    }

}