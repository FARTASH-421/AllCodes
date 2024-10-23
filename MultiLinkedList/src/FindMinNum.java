class MyString{
    String value ;
    public MyString(String str){
        this.value = str;
    }
    public int len (){
        return value.length();
    }

    public String subMyString(int firstIndex,int endIndex){
        if(endIndex > value.length())
            throw new NullPointerException();
        String temp = "";
        char[] ch =  this.value.toCharArray();
        for (int i = firstIndex; i <endIndex ; i++) {
            temp +=ch[i];
        }
        return temp;
    }
}

public class FindMinNum {
    public static void main(String[] args){
    String str = "100935204";
    int k = 6;


    foundMinNum(str,k);

    }

    public static int foundMinNum(String value, int n){
        int min = Integer.valueOf(value);
        MyString str = new MyString(value);
        int size = str.len();

        for (int i = 0; n <= size; i++) {

            String frist = str.subMyString(0,i);
           //  String del = str.subMyString(i,n);           ->> this section is deleted
            String temp = str.subMyString(n,size);

            n++;
           int find =Integer.valueOf(frist+temp);
            if(find < min){
                min = find;
            }
        }
        return min;
    }


    public static String makeMatrixMu(String str){

        String temp = str.charAt(0)+"";
        int size = str.length()-1;
        int i = 1;

        while (i< size) {
            char s = str.charAt(i);
            if (s == '[' || s == ']') {
                i++;
                continue;
            }
            temp += s;
            i++;
        }
        temp += str.charAt(i);
        return temp;
    }


}