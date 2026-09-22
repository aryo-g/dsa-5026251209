package lw01.unguided;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(Main.class.getResourceAsStream("washes.txt"));

        int count = scanner.nextInt();

        WashService[] washes = new WashService[count];
        int[] units = new int[count];


         while (count-- > 0) {
            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            units[count] = scanner.nextInt();

            if(type.equals("CAR")){
                washes[count] = new CarWash(id, days);
            } else if(type.equals("MOTORCYCLE")) {
                washes[count] = new MotorcycleWash(id, days);
            }
            
        }

        for(int i = 0; i < washes.length; i++) {
            System.out.println(washes[i].summary(units[i]));
        }
        scanner.close();
    }
}
