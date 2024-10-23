import java.io.*;
import java.util.Scanner;

public class FundPrimeNumber {
    public static void main(String[] args) throws IOException {

        /*
           Pleas change paths
           because the paths file is my computer and not work your computer
        */

        String pathInput = "C:\\Users\\Fartash\\Desktop\\New folder\\DS_MinProject\\src\\input.txt";
        String pathSaveData = "C:\\Users\\Fartash\\Desktop\\New folder\\DS_MinProject\\src\\saveData.txt";

        mySwitch(pathInput, pathSaveData);

    }

    public static void mySwitch(String pathInput, String pathSaveData) throws IOException {

        System.out.println("-----------------------------------------\n\t[A]-> Method (1-n) ");
        System.out.println("\t[B]-> Method (1-sqrt(n))");
        System.out.println("\t[C]-> Method (Array)");
        System.out.println("\t[D]-> Method (Array don't check Mazrab) ");
        System.out.print("Pleas choose which Method Run: ");

        Scanner in = new Scanner(System.in);
        char choose = in.next().toUpperCase().charAt(0);


        File file = new File(pathInput);
        File file1 = new File(pathSaveData);

        Scanner read = new Scanner(file);
        FileWriter writer = new FileWriter(file1, true);
        writer.write("\n===================> Part " + choose + " :\n");
        writer.write("\nvalue\t\t\t time\t\t\tCount PrimeNumber\n");

        long counter = 0, startTime = 0, endTime = 0;

        while (read.hasNextLine()) {
            int value = read.nextInt();

            if (choose == 'A') {
                startTime = System.currentTimeMillis();
                counter = FindPrimeNum_A(value);
                endTime = System.currentTimeMillis();
            } else if (choose == 'B') {
                startTime = System.currentTimeMillis();
                counter = FindPrimeNum_B(value);
                endTime = System.currentTimeMillis();
            } else if (choose == 'C') {
                    startTime = System.currentTimeMillis();
                    counter = FindPrimeNum_C_NonBahena( value);
                    endTime = System.currentTimeMillis();
            } else if (choose == 'D') {
                startTime = System.currentTimeMillis();
                counter = FindPrimeNum_D( value);
                endTime = System.currentTimeMillis();
            }

            double time = (endTime - startTime) / 1000d;
            String copy = value + "\t\t\t\t" + time + "\t\t\t\t" + counter + "\n";
            writer.write(copy);

            System.out.println("n: " + value + "\n\tcount: " + counter + "\n\ttime: " + time + " seconds");
        }
        read.close();
        writer.close();

        System.out.println("Do you want check other Method:[Y]or[N]");

        char again = in.next().toUpperCase().charAt(0);
        if (again == 'Y')
            mySwitch(pathInput, pathSaveData);
        else
            System.out.println("Run Finished");


    }

    public static long FindPrimeNum_A(int value) {
        int counter = 0;

        for (int i = 2; i <= value; i++) {
            int check = 0;
            for (int j = i; j > 0; j--) {
                if (i % j == 0) {
                    check++;
                }
            }
            if (check == 2)
                counter++;
        }
        return counter;
    }

    public static long FindPrimeNum_B(int value) {
        int counter = 0;

        for (int i = 2; i <= value; i++) {
            int check = 1;
            for (int j = (int) Math.sqrt(i); j > 0; j--)
                if (i % j == 0)
                    check++;

            if (check == 2)
                counter++;
        }
        return counter;
    }

    public static int FindPrimeNum_C(int n) {
        int counter = 0;
        boolean[] arr = new boolean[n - 1];

        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    arr[i - 2] = true;

                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (!arr[i])
                counter++;
        }
        return counter;
    }

    public static int FindPrimeNum_D(int n) {
        int counter = 0;
        boolean[] arr = new boolean[n - 1];

        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    arr[i - 2] = true;
                    break;
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (!arr[i])
                counter++;
        }
        return counter;

    }

    public static int FindPrimeNum_C_NonBahena(int n) {
        int counter = 0;
        long[] arr = new long[n - 1];

        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    arr[i - 2] = i;

                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != i + 2) {
                counter++;
            }
        }
        return counter;
    }
}