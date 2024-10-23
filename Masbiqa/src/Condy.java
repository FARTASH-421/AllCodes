import java.util.Scanner;

public class Condy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt() ;
        long v = input.nextLong();
        int n = input.nextInt();
        long [] cost = new long[n];
        long [] candy = new long[n];

        for (int i = 0; i < n; i++)
            candy[i] = input.nextLong();
        for (int i = 0; i < n; i++)
            cost[i] = input.nextLong();
        long costCandy = 0;

        for (int i = 0; i < n; i++) {
            if(v > cost[i]){
                if(candy[i]>= k+1) {
                    if (candy[i] % (k+1) == 1) {
                        costCandy += cost[i];
                        v = v - cost[i];
                    }
                }
            }
        }
        System.out.println(costCandy);
    }
}