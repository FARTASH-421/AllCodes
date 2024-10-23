import java.util.Scanner;
import javax.swing.JOptionPane;
public class JavaXs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstName;
        String modelName;
        String lastName;


        firstName = JOptionPane.showInputDialog("What is your name: ");

        modelName = JOptionPane.showInputDialog("What is your modle name: ");

        lastName = JOptionPane.showInputDialog("What is last name: ");

        JOptionPane.showInputDialog("your name is "+firstName+ " module name "+modelName+" last name "+lastName);
        System.exit(0);
    }
}
