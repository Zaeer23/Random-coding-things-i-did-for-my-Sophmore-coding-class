import java.util.Scanner;
public class Hello {
    private static String countYZ;
    private static String gHappy;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the string? ");
        String name = input.nextLine();
        System.out.println("Result: " + countTriple(name));
    }

    public static int countYZ(String str) {
        int count = 0;
        int limit = str.length() - 1;
        char ch;
        str = str.toLowerCase();
        ch = str.charAt(0);
        for (int i = 1; i <= limit; i++) {
            if (ch == 'y' || ch == 'z') {
                ch = str.charAt(i);
                if (!Character.isLetter(ch))
                    count++;
            } else
                ch = str.charAt(i);
        }
        if (ch == 'y' || ch == 'z') {
            count++;
        }
        return count;
    }

    public static boolean gHappy(String str) {
        int check = 0;
        int limit = str.length();
        for (int i = 0; i < limit; i++) {
            if (str.charAt(i) == 'g') {
                check = 0;
                if (i > 0) {
                    if (str.charAt(i - 1) != 'g')
                        check++;
                } else
                    check++;
                if (i < limit - 1) {
                    if (str.charAt(i + 1) != 'g')
                        check++;
                } else
                    check++;
                if (check == 2)
                    return false;
            }
        }
        return str.contains("g");
    }

    public static int countTriple(String str) {
        int count = 0;
        for(int i = 0; i < (str.length()-2); i++) {
            String integer = str.substring(i,i+3);
            if (isJack(integer)) count++;
        }
        return count;
    }
    public static boolean isJack(String str){
       if (str.length() != 3) return false;
    char a = str.charAt(0);
    char b = str.charAt(1);
    char c = str.charAt(2);
    return a == b && b == c;
    }
}
