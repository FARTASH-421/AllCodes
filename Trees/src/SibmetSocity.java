import java.util.Scanner;

public class SibmetSocity {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] tree = new int[2 * size];

        for(int i =0; i< size; i++){
            tree[2*i] = in.nextInt();
            tree[2*i+1] = in.nextInt();
        }

        int index = in.nextInt();
        System.out.println(findSubTree(index, tree));

    }

    public static int findSubTree(int root,int[] arr){
        int index = 1;
        if (root == -1)
            return 0;
        int LC = findSubTree(arr[2*root],arr);
        int RC = findSubTree(arr[2*root +1],arr);
        if(RC != 0 && LC != 0) {
            return index + LC + RC + 1;
        }if(RC != 0 || LC !=0) {
            return index+RC+LC;
        }

        return index;
    }
}
class Test{
    public static void main(String[] args) {
        int [] arr = {3,6,4,8,2,9,1,7,0};
        int size = arr.length;
        arrs(arr, size);
    }

    public static void arrs (int[] arr,int n){
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < i; j++) {
                    if(arr[i] < arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}