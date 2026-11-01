package lw04.prelab;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int n = scan.nextInt();
        int[] branches = new int[n];

        for (int i = 0; i < n; i++) {
            branches[i] = scan.nextInt();
        }

        int n2 = scan.nextInt();
        int[] targets = new int[n2];
        for (int i = 0; i < n2; i++) {
            targets[i] = scan.nextInt();
        }

        int[] targetIndex = new int[n2];
        for (int i = 0; i < n2; i++) {
            targetIndex[i] = -1;
        }

        insertionSort3(branches);

        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n; j++) {
                if (targets[i] == branches[j]) {
                    targetIndex[i] = j;
                }
            }
        }

        // dispaly

        for (int i : branches) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < n2; i++) {
            if (targetIndex[i] == -1) {
                System.out.println(targets[i] + ": NOT FOUND");
            } else {
                System.out.println(targets[i] + ": FOUND at index " + targetIndex[i]);
            }
        }

        scan.close();
    }

    //untuk method insertion
    static void insertionSort3(int[] br) {
        int pass = 3;
        for (int i = 1; i <= pass; i++) {
            int key = br[i];
            int j = i - 1;

            while (j >= 0 && br[j] < key) {
                br[j + 1] = br[j];
                j--;
            }
            br[j + 1] = key;
        }
    }
}
