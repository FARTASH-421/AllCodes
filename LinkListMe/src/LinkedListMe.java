class Node<E>{
    Node<E> next;
    E item;
}

public class LinkedListMe<E> {
    Node<E> first = null;
    private Node<E> list = null;
    int size =0;

    public void lastAdd(E item){
        size++;
        Node<E> temp = new Node<>();
        temp.item = item;
        list.next = temp;
        list = temp;
    }


    public void firstAdd(E item){
        size++;
        Node<E> temp = new Node<>();
        temp.item = item;
        temp.next = first;
        first = temp;
    }

    public void add(E item){
        size++;
        Node<E> temp = new Node<>();
        temp.item = item;

        if(list == null){
            list = temp;
            first = temp;
            return;
        }
        list.next = temp;
        list = temp;
    }

    public E firstRemove(){

        Node<E> temp = first;
        if(first == null)
            return null;
        else
            size--;
            first = first.next;
        return temp.item;
    }

    public E removeList(){

        Node<E> temp = new Node<>();
        Node<E> check = first;
        if(first == null)
            return null;
        else
            size--;
            while (check.next != null){
                temp = check;
                check = check.next;
            }
            list = temp;
            list.next = null;

            return check.item;

    }
    public boolean remove(E value){

        if(value == null)
            throw  new NullPointerException();
        if(first == null)
            return false;
        Node<E> iter = first;
        if(iter.item.equals(value))
            first = first.next;

        while (iter.next != null ){
            if(iter.next.item.equals(value)){
                iter.next = iter.next.next;
                size--;
                return true;
            }
            iter = iter.next;

        }
        return false;

    }

    Node<Integer> mergeSort(LinkedListMe fistList, LinkedListMe secondList){

        Node<Integer> nodeL1 = fistList.first;
        Node<Integer> nodeL2 =  secondList.first;
        Node<Integer> head, p, temp = new Node<>() ;
        if(nodeL2.item < nodeL1.item){
           temp  = nodeL2;
           nodeL2 = nodeL1;
           nodeL1 = temp;
        }

         temp.item = nodeL1.item;
         p = temp;
         head = temp;
         nodeL1 = nodeL1.next;

        while (nodeL1 != null && nodeL2 != null){
            if(nodeL2.item < nodeL1.item){
                temp  = nodeL2;
                nodeL2 = nodeL1;
                nodeL1 = temp;
            }
                temp = new Node<>();
                temp.item = nodeL1.item;
                p.next = temp;
                p = temp;
                nodeL1 =nodeL1.next;
        }
        if(nodeL1 == null){
            nodeL1 = nodeL2;
        }
        p.next = nodeL1;

        return head;
    }

    public boolean removeLoop(LinkedListMe list){
        Node<E> node = list.first;

        while (node.next!= null){

            Node<E> temp = node.next;
            while (node.next != null){
                if(node.equals(temp.next))
                    temp.next = null;
                temp = temp.next;
            }
            node = node.next;
        }
        return false;
    }

    public Node union(LinkedListMe list1, LinkedListMe list2){

        Node<E> list = new Node<E>();
        Node<E> iter = list2.first;
        Node<E> temp ,head;
        head = list;

        while (iter != null){
            temp = list1.first;
            while (temp!= null){
                   if(iter.item.equals(temp.item)){
                       Node<E> p = new Node<>();
                       p.item = iter.item;
                       list.next = p;
                       list = p;
                   }
                temp = temp.next;
            }
            iter = iter.next;
        }
        return head.next;
    }


    public Node intersection(LinkedListMe list1, LinkedListMe list2){

        Node<E> iter  = list1.first;

        Node<E> result = new Node<>();
            result = iter;

            while (iter.next != null){
                iter = iter.next;
            }
            iter.next = list2.first;;

        removeRepeated(result);
        return (result);
    }

    public Node removeRepeatedRecursive(Node first)
    {
        if (first == null)
            return null;
        first.next = removeRepeatedRecursive(first.next);
        if (first.next != null && first.next.item == first.item){

            return first.next;
        }
        return first;
    }


    public void removeRepeated(Node first) {

        Node<E> iter = first;
        Node<E> index, temp;

        while (iter != null) {
            temp = iter;
            index = iter.next;

            while (index != null) {
                if (iter.item == index.item) {
                    temp.next = index.next;
                } else {
                    temp = index;
                }
                index = index.next;
            }
            iter = iter.next;
        }
    }

    void show(){

       Node<E> iter = first;
       System.out.print("[");
       while (iter != null){
           System.out.print(iter.item+", ");
           iter = iter.next;
       }
        System.out.println("]");
    }
}

class Test{
    public static void main(String[] args) {

        //**********  Abdul Qadir Fartash **************
        // ***********     99243100      ***************


        //*************   pleas check all function

        /* for check Question 1 ues methode " removeRepeatedRecursive(Node first) "
           for check Question 2 use methode " removeLoop(LinkedListMe list) "
           for check Question 3 use methode " mergeSort(LinkedListMe fistList, LinkedListMe secondList) "
           for check Question 4 use methode " union(LinkedListMe list1, LinkedListMe list2) "
           for check Question 5 use methode " intersection(LinkedListMe list1, LinkedListMe list2) "
         */

    }
}