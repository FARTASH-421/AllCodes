class NodeMe{
    NodeMe next, per;
    long data;
    public NodeMe(long item){
        this.data = item;
    }
}
class ListMe{
    private NodeMe head = null;
    private NodeMe end = null;
    private int size = 0;


    public void push_end(long num){
        size++;
        NodeMe temp = new NodeMe(num);
        if(head == null){
            head = temp;
            end = head;
        }else {

            temp.per = end;
            end.next = temp;
        }
    }
    public void push_front(long num){
        size++;
        NodeMe temp = new NodeMe(num);
        if(head == null){
            head = temp;
            end = head;
        }else {
            head.data = temp.data;
            temp.per = end;
            end.next = temp;
        }
    }
    public void push_wasat(long num){

    }

    public void show(){
        NodeMe copy = head;
        while (copy != null ){
            System.out.print(copy.data+" ");
            copy = copy.next;
        }
    }
}
public class Q1 {
}
