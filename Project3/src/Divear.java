import java.util.ArrayList;
import java.util.Scanner;

public class Divear{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<User> list_register = new ArrayList<>();

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            String [] lis = in.nextLine().split(" ");
            if(lis[0].equals("register")){
                String userName = lis[1];
                if(list_register.isEmpty()){
                    User us = new User(userName);
                    list_register.add(us);
                }else{
                    boolean check = true;
                    for (int j = 0; j < list_register.size(); j++) {
                        if(userName.equals(list_register.get(i).userName)){
                            System.out.println("invalid username");
                            check = false;
                        }
                    }
                    if(check){
                        User us = new User(userName);
                      list_register.add(us);
                    }
                }
            }else if(lis[0].equals("add_advertise")){
                String user = lis[1];
                String title = lis[3];
                int index_User = -1;
                boolean check = true;
                for (int j = 0; j < list_register.size(); j++) {

                    if(list_register.get(i).userName.equals(user)){
                        index_User = i;
                    }

                    for (String s : list_register.get(i).product) {
                        if(title.equals(s)){
                            System.out.println("invalid title");
                            check = false;
                        }
                    }
                }
                if(check && index_User > -1){
                    list_register.get(index_User).product.add(title);
                    System.out.println("posted successfully");
                }else{
                    System.out.println("invalid username");
                }
            }else if (lis[0].equals("rem_advertise")){
                String userN = lis[1];
                String title = lis[2];
                int index_User = -1;
                boolean check = true;

                for (int j = 0; j < list_register.size(); j++) {

                    if(list_register.get(i).userName.equals(userN)){
                        index_User = i;
                    }

                    for (String s : list_register.get(i).product) {
                        if(title.equals(s) && !list_register.get(i).userName.equals(userN)){
                            System.out.println("access denied");
                            check = false;
                        }
                    }
                }
                if(check && index_User > -1){
                    list_register.get(index_User).product.add(title);
                    System.out.println("posted successfully");
                }else{
                    System.out.println("invalid username");
                }

            }

        }




    }
}

class User{
    String userName;
    ArrayList<String> product;
    ArrayList<String> favorite;
    public User(String n){
        this.userName = n;
        this.product = new ArrayList<>();
        this.favorite = new ArrayList<>();
    }

    public void add_advertise(String prod){
        this.product.add(prod);
    }
    public void rem_advertise(String prod){
        boolean ss = this.product.remove(prod);
        System.out.println(ss);

    }
    public void show_list_my_advertises(){

        for (int i = 0; i < product.size(); i++) {
            System.out.print(product.get(i)+" ");
        }
        System.out.println();
    }
    public void add_favorite(String pro){
        this.favorite.add(pro);
    }

    public void rem_favorite(String pro){
        if(this.favorite.remove(pro)){
            System.out.println("removed successfully");
        }
    }

    public void list_favorite_advertises(){
        for (int i = 0; i < this.favorite.size(); i++) {
            System.out.print(favorite.get(i)+" ");
        }
        System.out.println();
    }
}