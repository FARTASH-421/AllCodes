import java.util.Scanner;


public class MinProj_A {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int value = in.nextInt();

            Long start = System.currentTimeMillis();
            int counter = FindPrimeNum(value);
            Long end = System.currentTimeMillis();
            System.out.println("value: "+value+"\n\tcounter PrimeNumber: "+counter);
            System.out.print("\t\tExecution time is " + (end - start) / 1000d + " seconds\n");


    }

    public static int FindPrimeNum(int value){
        int counter = 0;

        for (int i = 2; i <= value ; i++) {
            int check = 0;
            for (int j = i; j >0 ; j--) {
                if(i % j == 0){
                    check++;
                }
            }
            if(check == 2)
                counter++;
        }
        return counter;
    }
    
}
