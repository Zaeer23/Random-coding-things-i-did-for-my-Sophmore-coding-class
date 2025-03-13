import java.io.*;
import java.util.*;

public class Sigma {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Would you like to filter by year, or by state? Please enter a state abbreviation to use a state or a number if you would like to use a ear");
        String ans = in.nextLine();
        int year = -1;
        try {
            year = Integer.parseInt(ans);

        } catch (Exception e) {

        }

        File weather = new File("C:\\Users\\lawson.diggins\\IdeaProjects\\read stuff\\weather.csv");
        try {
            Scanner s = new Scanner(weather);
            s.nextLine();
            Line[] lines = new Line[16743];
            for (int i = 0; i<lines.length; i++) {
                String l = s.nextLine();
//                System.out.println(l);
                lines[i] = new Line(l);

            }
            if (year==-1) {
                for (int i = 0; i<lines.length; i++) {
//                    System.out.println(lines[i].state.replace("\"",""));
                    if (lines[i].state.replace("\"","").equalsIgnoreCase(ans)){
                        System.out.println("\n\nWind speed:"+lines[i].avWin);
                        System.out.println("high t:"+lines[i].hTemp);
                        System.out.println("low h:"+lines[i].lTemp);
                        System.out.println("precip:"+lines[i].prec);
                        System.out.println("avg temp:"+lines[i].aTemp);
                    }
                }
            } else {
                for (int i = 0; i<lines.length; i++) {
//                    System.out.println(lines[i].state.replace("\"",""));
//                    System.out.println(lines[i].year);
                    if (lines[i].year==year){
                        System.out.println("\n\nWind speed:"+lines[i].avWin);
                        System.out.println("high t:"+lines[i].hTemp);
                        System.out.println("low h:"+lines[i].lTemp);
                        System.out.println("precip:"+lines[i].prec);
                        System.out.println("avg temp:"+lines[i].aTemp);

                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
class Line {
    String state;
    int year;
    double prec = -0.0;
    double avWin = 0.0;
    double hTemp = 0;
    double lTemp = 0;
    double aTemp = 0.0;
    public Line(String line) {
        String[] parts = line.split(",\\\"");
//        System.out.println(Arrays.stream(parts).toList());
        state = parts[7].replace("\"","").split(", ")[1];
        year = Integer.parseInt(parts[4].replace("\"",""));
        prec = Double.parseDouble(parts[0].replace("\"",""));
        avWin = Double.parseDouble(parts[13].replace("\"",""));
        hTemp = Double.parseDouble(parts[10].replace("\"",""));
        lTemp = Double.parseDouble(parts[11].replace("\"",""));
        aTemp = Double.parseDouble(parts[12].replace("\"",""));
            }
}   // ","

