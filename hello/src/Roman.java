import java.util.Scanner;

public class Roman {
    public static String rNum(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] +
                hundreds[(num % 1000) / 100] +
                tens[(num % 100) / 10] +
                ones[num % 10];
    }

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Convert a number!:");
            String num = input.next();
            int ber = Integer.parseInt(num);
            System.out.println(ber + " is " + rNum(ber));
        } catch (NumberFormatException e) {
            System.out.println("Put a number cheater!");
        } catch (Exception e){
            System.out.println("Something went wrong!");
        }


    }











}
