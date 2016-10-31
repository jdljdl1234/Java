import java.util.Scanner;

public class StringTest
{
  public static void main (String[] args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter an upper case A");
    String answer = scan.next(); // Now the String created from the input is not an alias of the String literal "A"
    if (answer == "A")
      System.out.println("== said they are aequal");
    if (answer.equals("A"))
      System.out.println("equals said they are equal");
    
  }
}
