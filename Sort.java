import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;


public class Sort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Bubble sort 2. Insertion Sort 3. Selection Sort");
        int number = value(input);
        int[] arr = {5, 1, 4, 2, 8, 3, 7, 6, 12, 10, 11, 9};
        if (number == 1) {
            BubbleSort(arr); //maybe now?
        }
        if (number == 2) {
            InsertionSort(arr);
        }
        if (number == 3) {
            SelectionSort(arr);
        }
    }


    public static int value(Scanner input) {
        int number;
        // this is fixed yaay!

        do {
            System.out.print("1-3: ");
            number = Integer.parseInt(input.nextLine());


        } while (number < 1 || number > 3);
        return number;
    }

    public static void BubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    //make a temp variable
                    //put thing a in temp
                    //put b in a
                    //put temp in b
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    System.out.println(Arrays.toString(arr));
                    // i am john bubblesort

                }
    }


    public static void InsertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int t = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > t) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = t;
            System.out.println(Arrays.toString(arr));
            // i am now also john insertion sort
        }
    }


    public static void SelectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int something = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[something]) {

                    //find something smaller than something (probably should NOT have named it something but it isnt hurting anything i guess..)
                   something = j;
                }
            }
            int a_temporary_variable = arr[i];
            arr[i] = arr[something];
            arr[something] = a_temporary_variable;
            System.out.println(Arrays.toString(arr));
        // i am become Herman Hollerith, destroyer of sorting algorithms
        }
    }
}