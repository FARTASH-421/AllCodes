import java.util.LinkedList;
import java.util.Scanner;

public class MinProj_B{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int [] arr = {2,25,50,100,250,500,750,1000};
//        int value = in.nextInt();
        for (int j : arr) {
            Long start = System.currentTimeMillis();
            int counter = FindPrimeNum(j);
            Long end = System.currentTimeMillis();
            System.out.println("value: "+j+"\n\tcounter PrimeNumber: "+counter);
            System.out.print("\t\tExecution time is " + (end - start) / 1000d + " seconds\n");
        }

    }

    public static int FindPrimeNum(int value){
        int counter = 0;

        for (int i = 2; i <= value ; i++) {
            int check = 1;
            for (int j = (int) Math.sqrt(i); j >0; j--)
                if(i % j == 0)
                    check++;

            if(check == 2)
                counter++;
        }
        return counter;
    }
}











class Test{
    public static void main(String[] args) {
        LinkedList my = new LinkedList();
        my.get(9);
        int size  = 8;
        System.out.println(size >> 1);
    }
}