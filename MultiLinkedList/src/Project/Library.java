class Node<E>{
    E data;
    Node next;
    Node prev;
    public Node(E name){

        this.data = name;
    }
}

class SaveData <E>{
    private Node head = null;
    private Node iter = null;
    int size = 0;

    public void add(E name){
        size++;
        Node temp = new Node(name);
        if(head == null){
            head = temp;
            iter = head;
        }else {
            boolean check = found(name);
            if(!check) {
                head.prev = null;
                iter.next = temp;
                temp.prev = iter;
                iter = temp;
            }
        }
    }

    public Node getHead() {
        Node temp = head;
        return temp;
    }

    public E remove(E name){
        E data= null;
        if(name.equals(head.data)) {
            size--;
            data = (E) head.data;
            head = head.next;
            return data;
        }
        if(name.equals(iter.data)) {
            size--;
            data = (E) iter.data;
            iter = iter.prev;
            return data;
        }
        Node temp = head.next;
        while (temp.next !=null){
            if(temp.data.equals(name)){
                size--;
                data = (E) temp.data;
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                return data;
            }
            temp = temp.next;
        }
        return (E) "Not Found!";
    }

    public boolean found(E name){
        if(head==null)
            return false;

        Node temp = head;
        while (temp !=null){
            if(temp.data.equals(name)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void show(){
        Node iter = head;
        while (iter!= null){
            System.out.print(iter.data+ ", ");
            iter = iter.next;
        }
        System.out.println();
    }
}

public class Library {

    private static SaveData<String> logInMember = new SaveData<String>();
    private static SaveData<String> logOutMember = new SaveData<String>();
    private static SaveData<DataInfo> allBorrowBook = new SaveData<DataInfo>();
    private static SaveData<String> saveBook = new SaveData<>();
    private static SaveData<DataInfo> haveBook =  new SaveData<>();

    public void arrive(String personName){

        /*
             method add doesn't accept repeat Name,Object,etc....
             don't need checking the name, Object and anything
             because the List is Unique
         */
           logInMember.add(personName);

    }

    public void exit(String personName){

        logOutMember.add(personName);

        Node temp = haveBook.getHead();
        while (temp!= null){
            allBorrowBook.add( (DataInfo) temp.data);
            temp = temp.next;
        }
    }

    public boolean sInLib(String personName){

        boolean checkOutLi = logOutMember.found(personName);
        boolean checkInLi = logInMember.found(personName);

        if(!checkOutLi && checkInLi)
            return true;
        else
            return false;
    }

    public String borrowBook(String personName, String bookName){
        DataInfo save = new DataInfo(personName,bookName);
        allBorrowBook.add(save);
        return "This book "+bookName + "Borrow by "+ personName;
    }

    public boolean returnBook(String  bookName, String personName){

        Node temp = allBorrowBook.getHead();

        while (temp!= null){
           DataInfo save = (DataInfo) temp.data;
           if(save.getNamePerson().equals(personName) && save.getNameBook().equals(bookName)){
               System.out.println("This book '"+save.getNameBook() + "' return by "+save.getNamePerson());
               allBorrowBook.remove(save);
               return true;
           }
            temp = temp.next;
        }

        return false;

    }

    public int TotalTimeInLib(String personName, int startTime, int endTime){

        boolean checkInLi = logInMember.found(personName);
        boolean checkOutLi = logOutMember.found(personName);
        return checkInLi && checkOutLi? endTime-startTime: -1 ;

    }


    public void addNewBook(String bookName, int count){
        for (int i = 0; i < count; i++)
            saveBook.add(bookName);
    }


    public void shouldBring(String bookName, String personName){

        boolean checkOutLi = logOutMember.found(personName);
        boolean checkExtantBook = saveBook.found(bookName);

        if(checkExtantBook && !checkOutLi) {
            DataInfo data = new DataInfo(personName,bookName);
            haveBook.add(data);
            String str = "This book '"+bookName+"' shouldBring by "+personName;
            System.out.println(str);
            return;
        }
        if(!checkExtantBook) {
            String name = "book is not Extant";
            System.out.println(name);
            return;
        }
            String str = "Person exit in the library";
            System.out.println(str);
    }

    public void allPersonCurrentBooks(String personName){

        SaveData listSortPersonName = new SaveData();
        String str1, str2;
        Node temp = haveBook.getHead();
        System.out.println("The "+personName+" give these books: ");

        while (temp!=null){

            DataInfo s = (DataInfo) temp.data;
            if(personName.equals(s.getNamePerson())) {
                Node hList = listSortPersonName.getHead();
                str1 = s.getNameBook();

                while ( hList!= null){
                    str2 = (String) hList.data;
                    if(str2.charAt(0) > str1.charAt(0)){
                        hList.data = str1;
                        str1 = str2;
                    }
                    hList = hList.next;
                }

                listSortPersonName.add(str1);
            }
            temp = temp.next;
        }
        System.out.print("\t\t"); listSortPersonName.show();
    }


    public String allPersonsHaveThisBook(String bookName){

        SaveData listSortBook = new SaveData();
        String str1, str2;
        Node temp = haveBook.getHead();
        System.out.println("The "+bookName+" give these books: ");

        while (temp!=null){

            DataInfo s = (DataInfo) temp.data;
            if(bookName.equals(s.getNameBook())) {
                Node hList = listSortBook.getHead();
                str1 = s.getNamePerson();

                while ( hList!= null){
                    str2 = (String) hList.data;
                    if(str2.charAt(0) > str1.charAt(0)){
                        hList.data = str1;
                        str1 = str2;
                    }
                    hList = hList.next;
                }
                listSortBook.add(str1);
            }
            temp = temp.next;
        }
        System.out.print("\t\t\t"); listSortBook.show();
        return "Hello";
    }

    public static void main(String[] args) {
        Library li = new Library();

        li.addNewBook("Roman",5);
        li.addNewBook("LiveHuman",10);
        li.addNewBook("AaStory",6);
        li.addNewBook("Acutemic",2);

        li.arrive("Fartash");
        li.shouldBring("Roman","Fartash");
        li.shouldBring("AaStory","Fartash");
        li.shouldBring("Acutemic","Fartash");
        li.exit("Fartash");

        li.arrive("Qadir");
        li.shouldBring("Roman","Mahdi");
        li.shouldBring("Roman","Qadir");
        li.shouldBring("Roman","Hadi");
        li.shouldBring("Roman","Qasem");
        li.shouldBring("Roman","Hadi");
        li.allPersonCurrentBooks("Fartash");
//        li.allPersonsBorrowedThisBook("Roman");
//        li.allPersonsHaveThisBook("Roman");
         int x =  li.allPersonAllTimeBooks("Fartash");
        System.out.println(x);
//        li.allPersonCurrentBooks("Qasem");


    }

    public String  allPersonsBorrowedThisBook(String bookName){
        SaveData list = new SaveData();
        allPersonsHaveThisBook(bookName);
        Node temp = allBorrowBook.getHead();

        while (temp != null){
            DataInfo info = (DataInfo) temp.data;
            if(bookName.equals(info.getNameBook()))
                System.out.println(info.getNamePerson());
            temp = temp.next;
        }
        return "  ";
    }

    public int  allPersonAllTimeBooks(String personName){
        int counter = 0;
        Node temp = haveBook.getHead();
        while (temp != null){
            DataInfo s = (DataInfo) temp.data;
            if(s.getNamePerson().equals(personName))
                counter++;
            temp = temp.next;
        }
        return counter;
    }

}
