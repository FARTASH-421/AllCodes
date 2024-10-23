class NodeMe{
    int data;
    NodeMe next;
    NodeMe prev;
    public NodeMe(int data){
        this.data = data;
    }

}

class Queue{
    NodeMe first = null;
    NodeMe tail = null;
    NodeMe prev = null;


    public void push(int value){
        NodeMe temp = new NodeMe(value);
        if(first == null){
            tail = temp;
            first = tail;
        }else
            first.prev = null;
            tail.next = temp;
            temp.prev = tail;
            tail = temp;

    }
    public int pop(){
        int temp = first.data;
        first = first.next;
        return temp;
    }

    public void show(){
        NodeMe temp = first;
        while (temp != null){
            System.out.print(temp.data+ ", ");
            temp = temp.next;
        }
    }
}

class Stack{
    private Queue q1 = new Queue();
    private Queue q2 = new Queue();

    public void push(int data){
        q1.push(data);
    }
    public int pop(){
      NodeMe temp = q1.tail.prev;

        q1.tail = q1.tail.prev;
        return .data;
    }

    public void show(){
        NodeMe temp = q1.first;
        while (temp != null){
            System.out.print(temp.data+", ");
            temp = temp.next;
        }
        System.out.println();
    }

}

class Test{
    public static void main(String[] args) {
        Stack s= new Stack();
        s.push(12);
        s.push(55);
        s.push(1);
        s.push(2);
        s.push(9);
        s.push(7);
        s.push(87);
        s.push(4);
        s.show();
        s.pop();
        s.show();


    }
}