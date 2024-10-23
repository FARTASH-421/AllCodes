import java.util.Scanner;

public class Basafa {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int [] queue = new int[in.nextInt()];
        long [] lists = new long[in.nextInt()];
        int j=0;
        long temp = 0L;

        for (int i = 0; i < lists.length; i++) {
            int check = in.nextInt();
            if (check == 1) {
                temp += in.nextInt();
                lists[j] = temp;
                j++;
                continue;
            } else if(check == 2) {
                int index = in.nextInt() - 1;
                int indexBeforeSum = queue[index]-1;
                queue[index]  = queue[index] + in.nextInt();
                int fine = queue[index]-1;
                if (-1 < fine && fine < j) {
                    if (indexBeforeSum == -1)
                        System.out.println(lists[fine]);
                    else
                        System.out.println(lists[fine] - lists[indexBeforeSum]);
                }else
                    System.out.println(0);

            }else in.nextLine();
        }
    }
}
