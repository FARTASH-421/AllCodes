import java.util.Scanner;

public class MySort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] grades = new int[len];
        grades[0] = in.nextInt();

        for (int i = 1; i < grades.length ; i++) {
            int num = in.nextInt();
            for (int j = 0 ; j < i; j++) {
                if (grades[j] > num) {
                    int temp = grades[j];
                    grades[j] = num;
                    num = temp;
                }
            }            grades[i] = num;
        }
    }
}