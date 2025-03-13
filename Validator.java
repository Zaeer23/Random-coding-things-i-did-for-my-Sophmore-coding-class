import java.util.Scanner;
class Validator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a phone number: ");
        System.out.println(input.nextLine().matches( "^1? ?(\\(\\d{3}\\)|\\d{3})[- ]?\\d{3}[- ]?\\d{4}$"));
    }
}