import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CSVFileReader {

    public static void main(String[] args) {
        String csvFile = "persons.csv";
        String line;
        String cvsSplitBy = ",";

        List<Integer> ages = new ArrayList<>();
        Map<String, Integer> nationalityFrequency = new HashMap<>();
        List<String> incorrectPhoneNumbers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] person = line.split(cvsSplitBy);
                String name = person[1];
                int age;
                age = Integer.parseInt(person[2]);

                ages.add(age);

                String nationality = person[6];
                String phoneNumber = person[5];


                nationalityFrequency.put(nationality, nationalityFrequency.getOrDefault(nationality, 0) + 1);


                if (!phoneNumber.matches("^1? ?(\\(\\d{3}\\)|\\d{3})[- ]?\\d{3}[- ]?\\d{4}$")) {
                    incorrectPhoneNumbers.add(name + ": " + phoneNumber);
                }
            }

            double meanAge = ages.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            System.out.println("Mean Age: " + meanAge);

            Collections.sort(ages);
            double medianAge;
            if (ages.size() % 2 == 0) {
                medianAge = (ages.get(ages.size() / 2 - 1) + ages.get(ages.size() / 2)) / 2.0;
            } else {
                medianAge = ages.get(ages.size() / 2);
            }
            System.out.println("Median Age: " + medianAge);

            Map<String, Integer> sortedNationalities = nationalityFrequency.entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ));

            System.out.println("Nationality Frequency:");
            sortedNationalities.forEach((k, v) -> System.out.println(k + ": " + v));

            System.out.println("Incorrectly Formatted Phone Numbers:");
            incorrectPhoneNumbers.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
