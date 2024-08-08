import java.util.Scanner;

class MyException extends Exception {
    private int debdoot;

    public MyException(int debdoot) {
        this.debdoot = debdoot;
    }

    @Override
    public String toString() {
        return "MyException[" + debdoot + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Your main code logic goes here
            // For demonstration, let's add some code that might throw these exceptions
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int num = Integer.parseInt(scanner.nextLine());

            int result = 10 / num; // Potential division by zero

            String str = "Hello";
            char ch = str.charAt(10); // Potential string index out of bounds

            int[] arr = new int[5];
            arr[10] = 50; // Potential array index out of bounds

            if (num == 5) {
                throw new MyException(num);
            }

        } catch (ArithmeticException e) {
            System.out.println("Invalid division");
        } catch (NumberFormatException e) {
            System.out.println("Format mismatch");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Index is invalid");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is invalid");
        } catch (MyException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("Exception encountered");
        } finally {
            System.out.println("Exception Handling Completed");
        }

        System.out.println("This Practical is made by 23CS043 Debdoot Manna");
    }
}