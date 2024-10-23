import java.util.Scanner;

class Node{
    char data;
    Node up;
    Node down;
    Node L;
    Node R;
    public Node(char data){
        this.data = data;
    }
}

public class SearchTow_to_Tow {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        Node go_right = null;
        Node go_down = null;
        Node head = null;
        in.nextLine();
        for (int i = 0; i < row; i++) {
            String ss = in.nextLine();
            Node temp = new Node(ss.charAt(0));

            if(head == null){
                head = temp;  go_right = head; go_down = head;
            }else{
                go_down.down = temp;
                temp.up = go_down;
                go_down = temp;
                go_right = temp;
            }
            for (int j = 1; j < col; j++) {
                temp = new Node(ss.charAt(j));
                    go_right.R = temp;
                    temp.L = go_right;
                    if(i>0) {
                        go_right.up.R.down = temp;
                        temp.up = go_right.up.R;
                    }if(i==0){
                        go_right.up = null;
                        go_right.down = null;
                }
                    go_right = temp;
            }
        }
        Node itr = head;
        while (itr!=null){
            Node it = itr;
            while (itr != null){
                if(itr.data == 'W') {
                    if (check(itr))
                        System.out.print(1);
                    else
                        System.out.print(0);
                }
                else {
                    System.out.print(0);
                }
                itr = itr.R;
            }
            System.out.println();
            itr = it.down;
        }

    }

    private static boolean check(Node itr) {
        return ch_goL_D(itr)||ch_goL_U(itr)||ch_goR_D(itr)||ch_goR_U(itr);
    }

    private static boolean ch_goR_U(Node itr){
        if(itr == null)
            return true;
        if(itr.data == 'R')
            return false;
        return (ch_goR_U(itr.R)|| ch_goR_U(itr.up));
    }
    private static boolean ch_goR_D(Node itr){
        if(itr == null)
            return true;
        if(itr.data == 'R')
            return false;
        return (ch_goR_D(itr.R)|| ch_goR_D(itr.down));
    }
    private static boolean ch_goL_U(Node itr){
        if(itr == null)
            return true;
        if(itr.data == 'R')
            return false;
        return (ch_goL_U(itr.L)|| ch_goL_U(itr.up));
    }
    private static boolean ch_goL_D(Node itr){
        if(itr == null)
            return true;
        if(itr.data == 'R')
            return false;
        return (ch_goL_D(itr.L)|| ch_goL_D(itr.down));
    }

}