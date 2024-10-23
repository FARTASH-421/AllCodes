public class Book{
    private String name;
    private int count = 1;
    private LinkedListM<String> persons = new LinkedListM<>();
    private LinkedListM<String> history = new LinkedListM<>();

    public Book(String name) {
        this.name = name;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }
    

    public void setCount(int count) {
        this.count = count;
    }

    public LinkedListM<String> getPersons() {
        return persons;
    }
    public LinkedListM<String> getHistory(){
        return history;
    }
    public void addPerson(String personName){
        if(!history.isExist(personName)){
            history.add(personName);
        }
        persons.add(personName);
        // Node<String> index = persons.getHead();
        // Node<String> last = persons.getLastNode();
        // while(index != last){
        //     if(last.data.charAt(0) <  index.data.charAt(0)){  
        //         String t = index.data;
        //         index.data =  last.data;
        //         last.data = t; 
        //     }
        //     index= index.next;
        // }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return   name ;
    }
}
