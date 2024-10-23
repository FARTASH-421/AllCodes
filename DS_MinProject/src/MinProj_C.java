import java.util.Scanner;

public class MinProj_C {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long start = System.currentTimeMillis();
        int count = PrimeNum_C(n);
        long end = System.currentTimeMillis();
        double time =  (end - start) / 1000d;
        System.out.println("Time: " + time+ " \tcount: "+count);
    }

    public static int PrimeNum_C(int n){
        int counter = 0;
        boolean arr[] = new boolean[(int) (n-1)];

        for (int i = 2; i <= n ; i++) {
            for (int j = i-1; j >1 ; j--) {
                if(i % j == 0){
                    arr[i-2] = true;
                }
            }
        }
        for (int i = 0; i < n-1; i++) {
            if(arr[i] == false)
                counter++;
        }
        return counter;
    }
}


