package lw01.prelab;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("jobs.txt"));
        int n = 5;

        PrintJob[] jobs = new PrintJob[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String id = scanner.next();
            int pages = scanner.nextInt();

            if (type.equals("MONO")) {
                jobs[i] = new MonoPrint(id, pages);
            } 
            else {
                jobs[i] = new ColourPrint(id, pages);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(jobs[i].summary());
        }

        scanner.close();
    }
}