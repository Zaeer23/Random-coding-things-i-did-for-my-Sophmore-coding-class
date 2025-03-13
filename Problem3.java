import java.util.Scanner;
public class Problem3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Check for Palindromes: ");
        String name = input.nextLine();
        System.out.println("Result: " + PalindromeScanner(name));
    }

    public static boolean PalindromeScanner(String str) {
        str = str.trim();
        str = str.toLowerCase();
        int len = str.length();
        for(int i=0; i<len;i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }

        }
        return true;
    }


}

