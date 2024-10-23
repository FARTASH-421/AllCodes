public class LinkedListM<T> {
    private Node<T> head ;
    private Node<T> lastNode ;
    private int size = 0;
    public Node<T> getHead() {
        return head;
    }
    
    public Node<T> getLastNode() {
        return lastNode;
    }
    
    void remove(T data){
        if(size > 0)
            size--;
        if(head == null)
            return;
        if(lastNode.data.equals(data))
            lastNode = lastNode.prev;
        Node<T> temp = head, prev = null;
        if (temp != null && temp.data.equals(data)) {
            head = temp.next;
            return;
        }
        while (temp != null && !temp.data .equals( data)) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null)
            return;
        Node<T> next = temp.next;
        prev.next = next;
        if(next != null)
            next.prev = prev.next;
          
    }
 
   
    public void add(T data){
        Node<T> n = new Node<>(data);
        size++;
        if( head == null){
            head  = n;
            lastNode = head;
        }
        else{
            Node<T> temp = lastNode;
            lastNode.next = n;
            lastNode = lastNode.next;
            lastNode.prev = temp;
        }  
    }
    
    void printNodes(){
        Node<T> temp = head;   
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(); 
    }
    
    Node<T> getNode(T data){
        try {
            if(head == null || data == null)
                return null;
            Node<T> temp = head;
            Node<T> tempLast = lastNode;
            if(head.data.equals(data)){
                return head;
            }else if(lastNode.data.equals(data)){
                return lastNode;
            }else{
                while(temp !=  tempLast){
                    temp = temp.next;
                    tempLast = tempLast.prev;
                    if(temp.data.equals(data))
                        return temp;
                    if(tempLast.data.equals(data))
                        return tempLast;
                    
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    int size(){
        return size;
    }

    boolean isExist(T data){
        return getNode(data)!= null;
    }
}
class Node<T>{
    Node<T> next;
    Node<T> prev;
    T data;

    public Node(T data) {
        this.data = data;
    }
    public static void main(String[] args) {
        LinkedListM<String> list = new LinkedListM<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.remove("c");
        list.printNodes();
    }

}