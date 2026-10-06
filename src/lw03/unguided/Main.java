package lw03.unguided;
import java.util.*;

public class Main {
     public static void main(String[] args) {
        
        Scanner scan1 = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        Scanner scan2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));

        Set<String> regList = new HashSet<>();
        Set<String> checkList = new HashSet<>();
        int checkins = 0;
        int absent = 0;
        int rejected = 0;

        while (scan1.hasNextLine()){
            String studentID = scan1.nextLine();
            regList.add(studentID);
        }

        System.out.println("===== Event Check-In Results =====");
        while (scan2.hasNextLine()){
            String checkID = scan2.nextLine();

            if(!regList.contains(checkID)){
                System.out.println(checkID + ": Rejected (not registered)");
                rejected++;
            } else if (checkList.contains(checkID)){
                System.out.println(checkID + ": Rejected (already checked in)");
                rejected++;
            } else {
                System.out.println(checkID + ": Checked in");
                checkList.add(checkID);
                checkins++;
            }
        }

        scan1.close();
        scan2.close();

        System.out.println();
        int registered = regList.size();
        absent = registered - checkins;
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + registered);
        System.out.println("Successful check-ins: " + checkins);
        System.out.println("Absent students: " + absent);
        System.out.println("Rejected attempts: " + rejected);
    }
}
