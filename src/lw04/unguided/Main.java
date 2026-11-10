package lw04.unguided;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(Main.class.getResourceAsStream("parcels.txt"));

        int n = scan.nextInt();
        int[] shelf = new int[n];
        for (int i = 0; i < n; i++) {
            shelf[i] = scan.nextInt();
        }
        // targget
        int m = scan.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = scan.nextInt();
        }

        //DUA PASS 
        bubbleSort(shelf, 0, 2);

        int[] after2Passes = new int[n];
        for (int i = 0; i < n; i++) {
            after2Passes[i] = shelf[i];
        }

        bubbleSort(shelf, 2, n - 1);

        scan.close();

        System.out.println("==== After 2 Passes ====");
        for (int i = 0; i < n; i++) {
            System.out.print(after2Passes[i] + " ");
        }

        System.out.println();
        System.out.println();

        // 6. Tampilkan shelf terurut penuh (descending)
        System.out.println("==== Fully Sorted ====");
        for (int i = 0; i < n; i++) {
            System.out.print(shelf[i] + " ");
        }

        System.out.println();
        System.out.println();

        System.out.println("==== Search Results ====");
        for (int i = 0; i < m; i++) {
            binarySearch(shelf, targets[i]);
        }
    }

    static void bubbleSort(int[] arr, int startPass, int endPass) {
        int n = arr.length;
        for (int i = startPass; i < endPass; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int steps = 0;
        int foundIndex = -1;

        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                foundIndex = mid;
                break;
            } else if (target > arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (foundIndex != -1) {
            System.out.println(target + ": FOUND at index " + foundIndex + " (steps: " + steps + ")");
        } else {
            System.out.println(target + ": NOT FOUND (steps: " + steps + ")");
        }
    }
}
