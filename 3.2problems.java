import java.util.Scanner;

public class Problems3_2
{
  public static void main (String[] args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter the word \"title\" ");
    String answer = scan.next(); // Now the String created from the input is not an alias of the String literal "A"
    System.out.println(answer.toUpperCase());
    
  }
}
