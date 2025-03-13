import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
public class ReadItDummy {
    public static void main(String[] args) {
        try {
           String filePath;
           if (args.length >0) {
               filePath = args[0];
           } else {
           System.out.print("Howdy, give me a file path buckaroo!:    ");
           filePath = new Scanner(System.in).next();
           }
           String text = readFileAsString(filePath);


            runReadabilityCalculator(text);

        } catch (IOException exception) {
            System.out.println("fish");
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println("i aint readin allat!");
        }
    }


    public static void runReadabilityCalculator(String text) {
        try {
            /* lord forgive me for making this next part nearly unreadable to a rookie
             and lord forgive me for getting this next part from a stack overflow thread
             also if your reading this Dr. Stevenson I used this tutorial for my code https://youtu.be/xvFZjo5PgG0?si=EA6LiHxW8yT-HKBm
             regex is so fun, I should try coding in Hebrew next
             */
            int sentenceCount = text.split("[\\.\\?!][\s]+").length;
            /* ([.?!]) just matches something else along with any character
             cause theres a period ([.?!])
            [\\s]+ just matches one or many whitespaces.
            its like phone number validator again! But way worse cause now there's 4 of the damned things!
             */
            int wordCount = text.split("[\s]+").length;

            int charCount = text.replaceAll("[\s]+", "").length();
            double scoreARI = (4.71 * charCount / wordCount) +
                    (0.5 * wordCount / sentenceCount) - 21.43;
            System.out.println(scoreARI + wordCount + sentenceCount + charCount);



        } catch (ArithmeticException exception) {
            System.out.println("the code dun goofed!");
        }
    }
    public static String readFileAsString(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}





