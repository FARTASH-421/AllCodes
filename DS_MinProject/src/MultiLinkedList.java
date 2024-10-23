import java.util.Scanner;

class FindFamily {
    public  static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        char[] list = new char[size];

        for (int i =0; i<size; i++)
            list[i] = in.next().charAt(0);
        String str = in.next();

        int counter = FindFamily(list,str,size);
        System.out.println(counter);

    }
    public static int FindFamily(char[] list, String str,int size){

        int counter=0;
        char [] arr = str.toCharArray();
        for (int i = 0; i+2 < size; i++) {

            String myStr = ""+list[i]+list[i+1]+list[i+2];
            int a=0, b=1, c=2;

            for (int m = 0; m < 2 * arr.length ; m++) {

                String find = ""+arr[a]+arr[b]+arr[c];
                if(find.equals(myStr))
                    counter++;

                if( (m +1 )% 2== 1) {
                    int temp = b + c;
                    c = temp - c;
                    b = temp - b;
                }

                if((m+1) % 2 == 0){
                    int temp = b;
                    b = a;
                    a++;
                    if(b+a>=3)
                        c= 3-(a+b);
                    else
                        c = temp;

                }
            }

        }

        return counter > 0 ? counter : -1;
    }
}
