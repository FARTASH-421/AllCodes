import java.io.*;
import java.util.Scanner;

public class MinPro {
    public static void main(String[] args) throws IOException {



        File file = new File("C:\\Users\\Fartash\\Desktop\\New folder\\DS_MinProject\\src\\input.txt");
        File file1 =  new File("C:\\Users\\Fartash\\Desktop\\New folder\\DS_MinProject\\q1.txt");

        Scanner read = new Scanner(file);
        FileWriter writer = new FileWriter(file1,true);

        writer.write("\n===================> Part A :\n");


        while (read.hasNextLine()){
            int value = read.nextInt();

            long start = System.currentTimeMillis();

            long counter = Part_D(value);       // change method
            long end = System.currentTimeMillis();


            System.out.println("value: "+value+"\n\tcounter PrimeNumber: "+counter);
            double time =  (end - start) / 1000d;
            String copy = "value: "+value+"\t\t\tTime: "+time+"\t\t\tCount "+counter+"\n";
            writer.write(copy);
            System.out.print("\t\tExecution time is " +time + " seconds\n");
        }
        read.close();
        writer.close();



    }

    public static long Part_A(int value){
        long counter = 0;

        for (long i = 2; i <= value ; i++) {
            long check = 0;
            for (long j = 1; j <=i ; j++) {
                if(i % j == 0){
                    check++;
                }
            }
            if(check == 2)
                counter++;
        }
        return counter;
    }

    public static int Part_B(int value){
        int counter = 0;

        for (long i = 2; i <= value ; i++) {
            int check = 1;
            for (long j = 1; j <= (long)Math.sqrt(i); j++)
                if(i % j == 0)
                    check++;

            if(check == 2)
                counter++;
        }
        return counter;
    }

    public static int Part_C(int n){
        int counter = 0;
        boolean arr[] = new boolean[(int) (n-1)];

        for (int i = 2; i <= n ; i++) {
            for (int j =2 ; j<=i-1; j++) {
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

    public static int Part_D(int n){
        int counter = 0;
        boolean arr[] = new boolean[(int) (n-1)];

        for (int i = 2; i <= n ; i++) {
            for (int j = 2; j <= i-1 ; j++) {
                if(i % j == 0){
                    arr[i-2] = true;
                    break;
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
