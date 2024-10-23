class MyNode<E>{
    E data;
    MyNode<E> next;
    MyNode<E> prev;
    public MyNode(E value) {
        this.data = value;
    }
}

class Stack<E>{
    private MyNode<E> head = null;
    private MyNode<E> iter = null;
    int size = 0;

    public void push(E value){
        MyNode<E> temp = new MyNode<>(value);
        size++;
        if(head == null){
            iter = temp;
            head  = iter;
        }else
            head.prev= null;
            iter.next = temp;
            temp.prev = iter;
            iter = temp;
    }
    public E pop(){
        if(head == null)
            return null;
        size--;
        MyNode temp = iter;
        iter = iter.prev;
        iter.next = null;
        return (E) temp.data;
    }
    public boolean isEmpty(){
        if(this.size == 0)
            return true;
        else
            return false;
    }

    public void show(){
        MyNode temp = head;

        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

}


public class FindPrantens {
    public static void main(String[] args) {
        String str = "))()()(()(";
       int num =  foundGoodPran(str);
        System.out.println(num);
    }
    public static int foundGoodPran(String str){
        int counter = 0;
        char[] pra = str.toCharArray();
        int size = pra.length;
        Stack stack = new Stack();
        int temp = 0;

        for (int i = 0; i < size; i++) {
            if(pra[i] == '('){
                stack.push(pra[i]);
            }else if(pra[i] == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                    temp +=2;
                    if(stack.isEmpty()){
                        counter +=temp;
                        temp = 0;
                    }

                }
            }
        }
        return counter;
    }
}
