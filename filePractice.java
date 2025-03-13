import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class filePractice {
    private static List<List<String>> readFile(String CSV_FILE_NAME) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(CSV_FILE_NAME))) {
            List<List<String>> input = reader.lines().map(line -> Arrays.asList(line.split(",")))
                    .collect(Collectors.toList());
            return input;
        } catch (IOException e) {
            //code to handle exception
        }
        return null;
    }

    public static void main(String[] args) {
        List<List<String>> input = readFile("exportdata.csv");
        for (int i = 0; i < input.size(); i++) {
            for (int j = 1; j < input.get(i).size(); j++) {
               // if (input.get(i).get(j).contains("") && input.get(i).get(j).contains("")){
                int n = input.get(i).size()-5;
                if(n >= 0 && input.get(i).get(n).contains("$"))
                    System.out.println(input.get(i).get(0));
                }

            }

        }

                }
                //System.out.println(input.get(1).toString());

