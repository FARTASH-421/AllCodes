import java.util.Scanner;

public class Queue1 {
    public static void main(String[] args) {

        int sizeSum = 0;
        int c1, c2;
        Scanner scan = new Scanner(System.in);
        int queues[] = new int[scan.nextInt()];
        long[] sum = new long[scan.nextInt()];
        long allSumValue = 0;

        for (int i = 0; i < sum.length; i++) {
            int input = scan.nextInt();
            if (input == 1) {
                allSumValue += scan.nextInt();
                sum[sizeSum] = allSumValue;
                sizeSum++;
            } else if (input == 2) {
                c1 = scan.nextInt()-1;
                c2 = scan.nextInt();
                int indexBe = queues[c1];
                queues[c1] = c2+indexBe;

                if(-1 < queues[c1]-1 && queues[c1]-1 <  sizeSum){
                    if(indexBe == 0)
                        System.out.println(sum[queues[c1]-1]);
                    else {
                        System.out.println(sum[queues[c1] - 1] - sum[indexBe-1]);
                    }
                }else System.out.println(0);
            }
            scan.nextLine();
        }

    }
}