package lw03.prelab;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Scanner;

/*
playlist : penggunaan LIST (add, insert, remove)
participants : penggunaan SET
inventory : penggunaan MAP
 */

public class Main {
    public static void main(String[] args){

        List<String> playlist = new LinkedList<String>();

        Scanner scan = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        Scanner scan2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Scanner scan3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        while(scan.hasNext()){
            String order = scan.next();

            String songName = scan.nextLine().trim();

            if(order.equals("ADD")){
                playlist.add(songName);
            }

            if(order.equals("INSERT")){
                String[] songsplit = songName.split(" ", 2);
                int songIndex = Integer.parseInt(songsplit[0]);
                playlist.add(songIndex, songsplit[1]);
            }
            
            if(order.equals("REMOVE")){
                playlist.remove(songName);
            }
        
        }


        Set<String> participants = new LinkedHashSet<>();
        int duplikat = 0;
        while(scan2.hasNext()){
            String namaMahasiswa = scan2.nextLine().trim();

            if(participants.contains(namaMahasiswa)){
                duplikat++;
            } else {
                participants.add(namaMahasiswa);
            }
        }
        
        
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int salesGagal = 0;

        while(scan3.hasNext()){
            String type = scan3.next();
            String product = scan3.next();
            int quantity = scan3.nextInt();

            if(type.equals("ADD")){
                if (inventory.containsKey(product)){
                    int stock = inventory.get(product);
                    inventory.put(product, quantity + stock);
                }else {
                    inventory.put(product, quantity);
                }
            }

            if(type.equals("SELL")){

                if (inventory.containsKey(product) &&  inventory.get(product) >= quantity){
                    int stock = inventory.get(product);
                    inventory.put(product, stock - quantity);
                
                } else {
                    salesGagal++;
                }

            }
        }

        scan.close();
        scan2.close();
        scan3.close();


        //output of EVERYTHING

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }


        System.out.println();
        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());

        int no = 1;
        for (String name : participants) {
            System.out.println(no + ". " + name);
            no++;
        }

        System.out.println("Duplicate registrations: " + duplikat);



        System.out.println();
        System.out.println("===== Problem 3 =====");
    
        inventory.forEach((product, quantity) -> {
        System.out.println(product + ": " + quantity);
        });

        System.out.println("Failed sales: " + salesGagal);


    }
}
