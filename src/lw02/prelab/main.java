package lw02.prelab;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class main {
    public static void main(String[] args) {
    Scanner scan = new Scanner(main.class.getResourceAsStream("transactions.txt"));
    LinkedList<String[]> transList = new LinkedList<>();

        while(scan.hasNext()){
            String custname = scan.next();
            String transtype = scan.next();
            String transamount = scan.next();

            String[] transdata = {custname, transtype, transamount};
            transList.add(transdata);
        }
        scan.close();
            
    LinkedList<String[]> custData = new LinkedList<>();

    for (int i = 0; i < transList.size(); i++){
            String checknama = transList.get(i)[0];

        boolean CustomerTidakAda = true;
            for (int j = 0; j < custData.size(); j++){
                if (custData.get(j)[0].equals(checknama)){
                CustomerTidakAda = false;
            }
        }

        if(CustomerTidakAda){
        String[] newCust = {checknama, "0"};
        custData.add(newCust);
         }
    }

    Queue<String[]> transQueue = new LinkedList<>();
    for (int k = 0; k < transList.size(); k++){
    transQueue.add(transList.get(k));
    }

    Stack<String[]> transFail = new Stack<>();

    while(!transQueue.isEmpty()){
        String[] trans = transQueue.poll();
        String custname = trans[0];
        String transtype = trans[1];
        int transamount = Integer.parseInt(trans[2]);

        for (int i = 0; i < custData.size(); i++){
            if (custData.get(i)[0].equals(custname)){
                int balance = Integer.parseInt(custData.get(i)[1]);
                int amount = transamount;

                if (transtype.equals("DEPOSIT")){
                    balance += amount;
                    custData.get(i)[1] = Integer.toString(balance);

                } else if (transtype.equals("WITHDRAW")){
                    if (balance >= amount){
                     balance -= amount;
                        custData.get(i)[1] = Integer.toString(balance);
                     } else {
                            transFail.push(trans);
                        }
                    }
                }
            }
        } 

        System.out.println("=== Final Balances ===");
        for (int i = 0; i < custData.size(); i++) {
            System.out.println(custData.get(i)[0] + " : " + custData.get(i)[1]);
        }
        System.out.println();
        System.out.println("=== Failed Transactions ===");
        // ambil dengan LIFO
        while (!transFail.isEmpty()) {
            String[] fail = transFail.pop();
            System.out.println(fail[0] + " " + fail[1] + " " + fail[2]);
        }

    }   
}
