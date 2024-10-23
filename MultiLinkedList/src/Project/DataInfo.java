import javax.management.NotificationEmitter;

public class DataInfo {
    private String namePerson;
    private String nameBook;

    public DataInfo(String nPerson, String nBook){
        this.nameBook = nBook;
        this.namePerson = nPerson;
    }

    public String getNameBook() {
        return nameBook;
    }

    public String getNamePerson() {
        return namePerson;
    }
}













class Mian{
    public static void main(String[] args) {
        SaveData<String > lis = new SaveData();
        lis.add("Adaaaa");
        lis.add("Fartash");
        lis.add("Humaira");
        lis.add("Abdul");

        lis.add("Hamin");
        lis.add("Kawser");
        lis.add("Kaewm");
        lis.show();
        lis = sort(lis);
        lis.show();
    }

    public static SaveData sort(SaveData name){
       Node temp = name.getHead();
       String f1, f2;

       while (temp != null){
           Node iter = temp.next;

           f1 = (String) temp.data;
           while (iter!= null){

               f2 = (String) iter.data;
               if(f1.charAt(0)> f2.charAt(0)){
                   temp.data = f2;
                   iter.data = f1;
               }
               iter = iter.next;
           }
           temp = temp.next;
       }
        return name;
    }
}