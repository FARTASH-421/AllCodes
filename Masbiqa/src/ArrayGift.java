import java.util.Scanner;

public class ArrayGift {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long [] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = input.nextLong();
        int q = input.nextInt();
        for (int i = 0; i <q ; i++) {
            int check = input.nextInt();
            switch (check){
                case 0:
                    int l = input.nextInt()-1;
                    int r = input.nextInt();
                    long res = 0;

                    for (int j = l; j <r ; j++) {
                        res+= arr[j];
                    }
                    System.out.println(res);
                    break;
                case 1:
                   l = input.nextInt()-1;
                   r = input.nextInt();
                   int v = input.nextInt();
                    for (int j = l; j <r ; j++) {
                        arr[j] = arr[j]+ v;
                    }
                    break;
                case 2:
                    l = input.nextInt()-1;
                    r = input.nextInt();
                    v = input.nextInt();
                    for (int j = l; j <r ; j++) {
                        arr[j] = v;
                    }
                    break;
                case 3:
                    l = input.nextInt()-1;
                    r = input.nextInt();
                    v = input.nextInt();
                    for (int j = l; j < r ; j++) {
                        arr[j] = arr[j]+ v;
                    }
                    break;
            }

        }

    }

//    private static void desplay(long[] arr) {
//        for(Long x: arr){
//            System.out.print(x+ " ");
//        }
//        System.out.println();
//    }
}
