import java.util.Scanner;

public class Library{
    private LinkedListM<Person> members = new LinkedListM<>();
    LinkedListM<String> inLibs = new LinkedListM<>();
    private LinkedListM<Book> books = new LinkedListM<>();
    
    public static void main(String[] args) {
        // Library lib = new Library();
        // lib.addNewBook("math", "3");
        // lib.addNewBook("dari", "1");
        // lib.arrive("bsmjtbcwxknzxyplvmj", "759");
        // lib.arrive("Ali", "423");
        // lib.arrive("ntiwoauznl", "96");
        // lib.exit( "Ali", "712");
        // lib.inLibs.remove("Ali");
        // lib.isInLib( "Ali");
        // lib.inLibs.printNodes();


        
        Scanner input = new Scanner(System.in);

        Library lib = new Library();
            
            while(input.hasNextLine() ){
                String command = input.nextLine();
               
                String [] parts = command.split(" ");
                switch(parts[0]){
                    
                    case "arrive":
                        lib.arrive(parts[1], parts[2]);
                        break;
                    case "exit": 
                        lib.exit(parts[1], parts[2]);
                        break;
                    case "isInLib": lib.isInLib(parts[1]);
                        break;
                    case "returnBook": lib.returnBook(parts[2], parts[1]);
                        break;
                    case "borrowBook": lib.borrowBook(parts[1], parts[2]);
                        break;
                    case "addNewBook": lib.addNewBook(parts[1], parts[2]);
                        break;
                    case "totalTimeInLib": lib.TotalTimeInLib(parts[1], parts[2], parts[3]);
                        break;
                    case "shouldBring": lib.shouldBring(parts[1], parts[2]);
                        break;
                    case "allPersonAllTimeBook": lib.allPersonAllTimeBooks(parts[1]);
                        break;
                    case "allPersonCurrentBook": lib.allPersonCurrentBooks(parts[1]);
                        break;
                    case "allPersonBorrowed": lib.allPersonsBorrowedThisBook(parts[1]);
                        break;
                    case "allPersonHave": lib.allPersonsHaveThisBook(parts[1]);
                        break;
                    case "inLibs": lib.inLibs.printNodes();;
                        break;
                }
            }
        
        input.close();
       
    }
    void arrive(String personName, String start){
        Person p = new Person(personName);
        int startTime = Integer.parseInt(start);
        inLibs.add(personName);
        try {
            Node<Person> temp = members.getNode(new Person(personName));
            temp.data.startTime = startTime;
        } catch (Exception e) {
            p.startTime = startTime;
            members.add(p);
        }
    }

    void exit(String personName, String endTime){

        inLibs.remove(personName);
        try{
            Node<Person> p = members.getNode(new Person(personName));
            p.data.endTime = Integer.parseInt(endTime);
        }catch (Exception e){


        }

    }
    void isInLib(String personName){
        if(inLibs.isExist(personName))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    void borrowBook(String personName, String bookName) {
        
        Book book = new Book(bookName);
        Person person = new Person(personName);
        Node<Book> b = books.getNode(book);
        int count = b.data.getCount();
        if( count <= 0 ){
            return;
        }
        
        members.getNode(person).data.addBook(bookName);;
        b.data.addPerson(personName);
        b.data.setCount(count-1);
    }
    void returnBook(String bookName, String personName) {
       
        Book book = new Book(bookName);
        Person person = new Person(personName);
        try {
            
            Node<Person> p = members.getNode(person);
            Node<Book> b = books.getNode(book);
            int count = b.data.getCount();
            p.data.getBooks().remove(bookName);
            b.data.getPersons().remove(personName);
            b.data.setCount(count+1);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    void TotalTimeInLib(String personName, String startTime, String endTime){
         Node<Person> temp = members.getNode(new Person(personName));
         int start = Integer.parseInt(startTime);
         int startTemp = temp.data.startTime;
         int end = Integer.parseInt(endTime);
         int endTemp = temp.data.endTime;
         int finalStart, finalEnd;
         if(startTemp > start){
            finalStart = startTemp;
         }else{
            finalStart = start;
         }
         if(endTemp < end && endTemp >= finalStart){
            finalEnd = endTemp;
         }else{
            finalEnd = end;
         }
         System.out.println(finalEnd - finalStart);
    }
    void addNewBook(String bookName, String count) {
    
        Book b = new Book(bookName);
        int number = Integer.parseInt(count);
        b.setCount(number);
        try {
            Node<Book> temp = books.getNode(b);
            temp.data.setCount(temp.data.getCount()+number);
        } catch (Exception e) {
            books.add(b);
        }
    }
    void shouldBring(String bookName, String personName) {
        try {
            if(inLibs.isExist(personName)){
                Node<Book> book = books.getNode(new Book(bookName));
                if(book != null){
                    if(book.data.getCount() > 0){
                        Node<Person> member = members.getNode(new Person(personName));
                        member.data.addBook(bookName);
                        book.data.addPerson(personName);
                        book.data.setCount(book.data.getCount()-1);
                    }
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    void allPersonCurrentBooks(String personName) {
        try {
            
            LinkedListM<String> temp =  members.getNode(new Person(personName)).data.getBooks();
            if(temp.getHead() == null)
                System.out.println("empty");
            else{
                temp.printNodes();
            }
        } catch (Exception e) {
            System.out.println("empty");
        }
    }

    void allPersonsHaveThisBook(String bookName) {
        try {
            
            Node<Book> book = books.getNode(new Book(bookName));
            LinkedListM<String> temp =  book.data.getPersons();
            if(temp.getHead() == null)
                System.out.println("empty");
            else{
                temp.printNodes();
            }
        } catch (Exception e) {
            System.out.println("empty");
        }
    }
    void allPersonsBorrowedThisBook(String bookName) {
        Node<Book> temp =  books.getNode(new Book(bookName));
        if(temp != null && temp.data.getHistory().size() > 0)
            temp.data.getHistory().printNodes();
        else{
            System.out.println("empty");
        }
        
    }
    void allPersonAllTimeBooks(String personName) {
        Node<Person> temp = members.getNode(new Person(personName));
        int size = temp.data.getHistoy().size();
        if(temp != null )
            System.out.println( size);
        
        
    }

}
