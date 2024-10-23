public class Person{
    private String name;
    int startTime = 0;
    int endTime = 0;
    private LinkedListM<String> books = new LinkedListM<>();
    private LinkedListM<String> history = new LinkedListM<>();
    

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addBook(String bookName){
        if(!history.isExist(bookName)){
            history.add(bookName);
        }
        books.add(bookName);
        // Node<String> index = books.getHead();
        // Node<String> last = books.getLastNode();
        // while(index != last){
        //     if(last.data.charAt(0) <  index.data.charAt(0)){  
        //         String t = index.data;
        //         index.data =  last.data;
        //         last.data = t; 
        //     }
        //     index= index.next;
        // }
    }
    
    public LinkedListM<String> getBooks() {
        return books;
    }
    public LinkedListM<String> getHistoy(){
        return history;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    @Override
    public String toString(){
        return name;
    }

    
}
