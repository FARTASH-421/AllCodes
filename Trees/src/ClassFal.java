import java.util.Scanner;
class Node<E>{
    public E data;
    public Node<E> next;

    public Node(E itme){
        this.data = itme;
    }
}

class QueueMe<E>{
    public int size = 0;
    private Node<E> head = null;
    private Node<E> iter = null;

    public void push(E item){
        size++;
        Node temp = new Node(item);
        if(head == null){
            iter = temp;
            head = iter;
        }else
            iter.next = temp;
            iter = temp;
    }

    public E pop(){
        if(head == null)
            return null;
        size--;
        Node<E> itme = head;
        head = head.next;
        return  itme.data;
    }
}
public class ClassFal {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] tree = new int[2 * size];

        for(int i =0; i< size; i++){
            tree[2*i] = in.nextInt();
            tree[2*i+1] = in.nextInt();
        }

        int rootTree = findRoot(0, tree);
        showLeftRoot(rootTree,tree);

    }

    public static void showLeftRoot(int rootTree, int[] tree){
        QueueMe q = new QueueMe();
        q.push(rootTree);

        int n = 0, temp = 0;
        while (q.size != 0){
            int pow = (int) Math.pow(2,n);
            int result = -1;
            for (int i = 0; i < pow ; i++) {
                if(q.size != 0) {
                    temp = (int) q.pop();
                    if(temp != -1) {
                        result = temp;
                        int CL = tree[temp * 2];
                        int RL = tree[temp * 2+1];
                        q.push(RL);
                        q.push(CL);
                    }
                }
            }
            n++;
            if(result != -1)
                System.out.println(result);
        }
    }

    public static int findRoot(int index, int[] arr){
        for (int i=0; i<arr.length;i++){
            if(index == arr[i]) {
               return findRoot(i / 2, arr);
            }
        }
        return index;
    }
}
