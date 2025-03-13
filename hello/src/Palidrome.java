import java.util.Scanner;

public class Palidrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Check for Palindromes: ");
        String name = input.nextLine();
        System.out.println("Result: " + PalindromeScanner(name));
    }
    public static boolean PalindromeScanner(String str) {
        str = str.trim();
        str = cleanString(str);
        int len = str.length();
        for(int i=0; i<len;i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
            
        }
        return true;
    }
    public static String cleanString(String str){
        String output = "";
        str = str.toLowerCase();
        for(int i = 0; i < str.length(); i++){
            if(str.substring(i, i+1).matches("[a-z0-9]")){
                output += str.substring(i, i+1);
            }
        }
        return output;
    }
}
