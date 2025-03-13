import java.util.Scanner;

public class CaesarCipherDecoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            System.out.println("Choose: (1) Encode, (2) Decode, (3) Help! i forgot my shift!");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                System.out.print("well whaddya wanna encode: ");
                String inputString = scanner.nextLine();
                int shift = getShiftValue(scanner);

                String cleanedString = cleanString(inputString);
                String encodedString = caesarify(cleanedString, shift);

                System.out.println("Encoded String: " + encodedString);
            } else if (choice == 2) {
                System.out.print("well whatdya wanna decode?: ");
                String encodedString = scanner.nextLine();
                int shift = getShiftValue(scanner);

                String cleanedString = cleanString(encodedString);
                String decodedString = caesarify(cleanedString, -shift);

                System.out.println("Decoded String: " + decodedString);
            } else if (choice == 3) {
                System.out.print("well what did you forget?: ");
                String inputString = scanner.nextLine();
                String cleanedString = cleanString(inputString);
                printAllShifts(cleanedString);
            } else {
                System.out.println("enter 1 2 or 3 dummy");
            }

            System.out.println("wanna do something else? (yes/no): ");
            playAgain = scanner.nextLine().trim().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("ok now get out.");
        scanner.close();
    }

    public static String caesarify(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                int offset = (character - base + shift) % 26;
                if (offset < 0) {
                    offset += 26;
                }
                result.append((char) (base + offset));
            }
        }

        return result.toString();
    }

    public static void printAllShifts(String text) {
        for (int shift = 0; shift < 26; shift++) {
            String shiftedText = caesarify(text, -shift);
            System.out.println("Shift " + shift + ": " + shiftedText);
        }
    }

    public static int getShiftValue(Scanner scanner) {
        int shift;
        do {
            System.out.print("shift? (1-25): ");
            shift = Integer.parseInt(scanner.nextLine());
        } while (shift < 1 || shift > 25);
        return shift;
    }

    public static String cleanString(String input) {
        return input.replaceAll("[^a-zA-Z]", "").toUpperCase();
    }
}


