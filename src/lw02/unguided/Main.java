package lw02.unguided;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args){

        Scanner scan = new Scanner(Main.class.getResourceAsStream("orders.txt"));
        Queue<String[]> processOrder = new LinkedList<>();
        LinkedList<String[]> foodStockList = new LinkedList<>();
        LinkedList<String[]> drinkStockList = new LinkedList<>();
        LinkedList<String[]> processedList = new LinkedList<>();
        Stack<String[]> failedStack = new Stack<>();


        while(scan.hasNext()){
            String[] order = new String[4];
            order[0] = scan.next();
            order[1] = scan.next();
            order[2] = scan.next();
            order[3] = scan.next();

            processOrder.add(order);
        }
        scan.close();

        foodStockList.add(new String[] {"Bakso", "2"});
        foodStockList.add(new String[] {"Sate", "1"});
        foodStockList.add(new String[] {"Soto", "2"});
        drinkStockList.add(new String[] {"EsTeh", "4"});
        drinkStockList.add(new String[] {"EsJeruk", "2"});

        while (!processOrder.isEmpty()) {
            String[] o = processOrder.poll();
            String name = o[0];
            String food = o[1];
            String drink = o[2];
            int table = Integer.parseInt(o[3]);

            boolean foodAvailable = true;
            boolean drinkAvailable = true;
            int foodIndex = -1;
            int drinkIndex = -1;


            if (!food.equals("-")) {
                foodAvailable = false;
                for (int i = 0; i < foodStockList.size(); i++) {
                    if (foodStockList.get(i)[0].equals(food)) {
                        int stock = Integer.parseInt(foodStockList.get(i)[1]);
                        if (stock > 0) {
                            foodAvailable = true;
                            foodIndex = i;
                        }
                        break;
                    }
                }
            }


            if (!drink.equals("-")) {
                drinkAvailable = false;
                for (int i = 0; i < drinkStockList.size(); i++) {
                    if (drinkStockList.get(i)[0].equals(drink)) {
                        int stock = Integer.parseInt(drinkStockList.get(i)[1]);
                        if (stock > 0) {
                            drinkAvailable = true;
                            drinkIndex = i;
                        }
                        break;
                    }
                }
            }
            if (foodAvailable && drinkAvailable) {
                if (foodIndex != -1) {
                    int stock = Integer.parseInt(foodStockList.get(foodIndex)[1]);
                    foodStockList.get(foodIndex)[1] = String.valueOf(stock - 1);
                }
                if (drinkIndex != -1) {
                    int stock = Integer.parseInt(drinkStockList.get(drinkIndex)[1]);
                    drinkStockList.get(drinkIndex)[1] = String.valueOf(stock - 1);
                }

                processedList.add(o);
            } else {

                failedStack.push(o);
            }
        }

        System.out.println("=== Successfully Processed Orders ===");
        for (String[] order : processedList){
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }

        System.out.println("=== Remaining Food Stock ===");
        for (String[] food : foodStockList){
            System.out.println(food[0] + " : " + food[1]);
        }

        System.out.println("=== Remaining Drink Stock ===");
        for (String[] drink : drinkStockList){
            System.out.println(drink[0] + " : " + drink[1]);
        }

        System.out.println("=== Failed Orders ===");
        while (!failedStack.isEmpty()){
            String[] order = failedStack.pop();
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }
    }
}