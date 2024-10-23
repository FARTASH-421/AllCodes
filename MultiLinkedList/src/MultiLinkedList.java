class Node {
    int data;
    Node next;
    Node prev;
    Node up;
    Node down;
}

class tex{
    public static void main(String[] args) {
        int [][] arr = {{1,2},{3,4}};
        MultiLinkedList list = new MultiLinkedList();
        Node temp = new Node();
       Node iter =  list.TabeyiKeBazgashtiAst(arr,0,0,temp);
        System.out.println(iter.next.down.data);
       while (iter != null){
           temp = iter;
           while (temp!=null){
               System.out.print(temp.data+" ");
               temp = temp.next;
           }
           iter = iter.down;
           System.out.println();


       }
    }
}

public class MultiLinkedList {

    private Node first = null;
    private Node list = null;
    
   public Node TabeyiKeBazgashtiAst(int mtrx[][],int i, int j,Node curr)
    {
        if(i >=mtrx.length ||j >= mtrx.length)
            return null;

        Node temp = new Node(),iter;
        temp.data = mtrx[i][j];
        iter = TabeyiKeBazgashtiAst(mtrx, i, j+1 ,temp );
        temp.next = iter;
        if(iter != null )
            iter.prev = temp;

        iter = TabeyiKeBazgashtiAst(mtrx, i+1 , j,temp);
        temp.down = iter;
        if(iter != null)
            iter.up = temp;

        return temp;

    }


   public Node TabeyiKeBazgashtiNist(int [][] arr,int m, int n)
    {
        int i=0,j=0;
        Node temp = new Node();
        temp.data = arr[i][j];
        list = temp;
        first = list;

        for (i =0;  i<m; i++){
            temp = new Node();
            temp.data =arr[i][0];
            list.down = temp;
            temp.up = list;
            Node p  = temp, check = list.next;
            list = p;

            for (j =1; j< n; j++){

                temp = new Node();
                temp.data = arr[i][j];
                temp.prev = p;
                p.next = temp;
                p = temp;

                if(check != null){
                    check.down = temp;
                    temp.up =check;
                    check = check.next;
                }

            }
        }

        return first.down;
    }


   public int AdadeshoBede(int i , int j , Node head)
    {
        for (int k = 0; k <= i; k++) {
            Node p = head;
            for (int l = 0; l <= j; l++) {
                if(k == i && l ==j)
                    return p.data;
                p = p.next;
            }
            head = head.down;
        }
        return -1 ;
    }
    
    
    public int BeSotunEzafeKon(int indexCol, int value , Node head)
    {
        for (int j = 0; j  < indexCol ; j++) {
            head = head.next;
        }

        while (head.down != null){
            head = head.down;
        }


        Node temp = new Node();
        temp.data = value;
        head.down = temp;
        temp.up = head;
        head = temp;

        return 1;
    }


    public int BeSatrEzafeKon(int indexRow, int value , Node head)
    {

            for (int j = 0; j < indexRow ; j++) {
                head = head.down;
            }
            while (head.next != null){
                head = head.next;
            }
            Node temp = new Node();
            temp.data = value;
            head.next = temp;
            temp.prev = head;
            head = temp;


        return 1;
    }


    public int AdadeshoTaghirBede(int i , int j , int value , Node head)
    {
        for (int k = 0; k <= i; k++) {
            Node p = head;
            for (int l = 0; l <= j; l++) {
                if(k == i && l ==j){
                    p.data = value;
                    return 1;
                }
                p = p.next;
            }
            head = head.down;
        }
        return  0;
    }

}