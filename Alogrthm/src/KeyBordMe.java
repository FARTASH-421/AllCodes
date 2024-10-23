import java.util.ArrayList;
import java.util.Scanner;

public class KeyBordMe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String str2 = in.nextLine();
        boolean check = checkKeyBord(str, str2);
        System.out.println(check);
    }

    private static boolean checkKeyBord(String str, String str2) {
        char [] oneSt = str.toCharArray();
        char [] towSt = str2.toCharArray();
        ArrayList<String> list = new ArrayList<>();

         if(oneSt.length != towSt.length)
            return false;

         else {
             for (int i = 0; i < oneSt.length; i++) {
                 if (list.isEmpty())
                     list.add(towSt[i] + "" + oneSt[i]);
                 else {
                     for (int j = 0; j < list.size(); j++) {
                         String st = list.get(j);
                         if (st.charAt(0) == towSt[i] || st.charAt(1)==oneSt[i]) {
                             if (st.charAt(1) != oneSt[i] || st.charAt(0) != towSt[i])
                                 return false;
                         }
                     }
                     list.add(towSt[i]+""+ oneSt[i]);
                 }
             }
             return true;
         }
    }
}
