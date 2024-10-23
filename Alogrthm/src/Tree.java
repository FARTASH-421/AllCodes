import java.util.ArrayList;
import java.util.Scanner;

class MyNode{
    MyNode next;
    long data;
    public MyNode(long item){
        this.data = item;
    }
}
class Queue{
    private MyNode head = null;
    private MyNode iter = null;
    private MyNode getHead = null;
    int size = 0;

    public void push(long item){
        size++;
        MyNode temp = new MyNode(item);
        if(head == null){
            head = temp;
            iter = head;
            getHead = head;
        }else {
            iter.next = temp;
            iter = temp;
        }

    }
    public boolean findNodePa(long x){
        if(x == head.data)
            return true;
        else
            return false;
    }
    public long pop(){
        if(head == null)
            return 0;
        size--;
        long temp = head.data;
        head = head.next;
        return temp;
    }

    public long findMaxValue(){
        long max = 0;
        MyNode temp = head;
        while (temp != null){
            if(max<temp.data)
                max = temp.data;
            temp = temp.next;
        }
        return max;
    }
    public boolean findValue(long find){
        MyNode temp = head;
        while (temp != null){
            if(find == temp.data)
                return true;
            temp = temp.next;
        }
        return false;
    }
    int sizeTemp = size;
    public long get(){
        if(getHead == null)
            return 0;
        sizeTemp--;
        long temp = getHead.data;
        getHead = getHead.next;
        return temp;
    }
    public void diplay(){
        MyNode tem = head;
        System.out.print("[");
        while (tem != null){
            System.out.print(tem.data+", ");
            tem = tem.next;
        }
        System.out.println("]");
    }

}

public class Tree{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Queue> tree = new ArrayList<>();
        Queue qu = new Queue();
        int n = in.nextInt();
        long rootTree = in.nextLong();
        qu.push(rootTree);
        tree.add(qu);

        for (int i = 1; i <n ; i++) {
            long parent = in.nextLong();
            long child = in.nextLong();
            boolean pushOnQue = true;


            for( Queue myQu: tree) {
                if (myQu.findNodePa(parent)) {
                    myQu.push(child);
                    pushOnQue = false;
                    break;
                }
                if (myQu.findNodePa(child)) {
                    myQu.push(parent);
                    pushOnQue = false;
                    break;
                }
            }
            if(pushOnQue){
                for(Queue myQu: tree){
                    boolean checkPar = myQu.findValue(parent);
                    if(checkPar){
                        Queue qq = new Queue();
                        qq.push(parent);
                        qq.push(child);
                        tree.add(qq);
                        break;
                    }else{
                        Queue qq = new Queue();
                        qq.push(child);
                        qq.push(parent);
                        tree.add(qq);
                        break;
                    }
                }
            }
        }
        long max = findSubTree(tree,rootTree);
        System.out.println(max);

    }

    public static long findSubTree(ArrayList<Queue> tree, long root){

        long max = 0;
        Queue q = new Queue();
        Queue temp = null;

        for(Queue x: tree){
            if(x.findNodePa(root)) {
                temp = x;
                break;
            }
        }
        if(temp == null) {
            return 0;
        }
        temp.get();
        for (int i =1; i< temp.size;i++) {
            long child  = temp.get();
            if (max < child)
                max = child;
            System.out.println(child+ " after");
            long re = findSubTree(tree, child);
//            System.out.println(re+ " <<--");
            q.push(re);
        }

        if(q.findValue(0)) {
            if(max > root)
                return max;
            else
                return root;
        }
        long large = q.findMaxValue();
        if(large > root)
            return large;
        else
            return root;
    }
}


class Tes{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt();
            int y = in.nextInt();
            int result = fun(x, y);
            System.out.println("the result: " +result);
    }

    public static int fun(int n, int m){

        if(m == 0)
            return 1;
        int a = fun(n, m/2);
        System.out.println("n: "+n + "\t\tm: "+m+ " --> a: "+a);
        if(m%2 == 0)
            return a * a * n;
        return a * a;
    }
}