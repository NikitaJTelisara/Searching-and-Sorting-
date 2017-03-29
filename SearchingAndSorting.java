import java.lang.Math;
/* Merge Sort, Quick Sort and Bucket
Sort are the most commonly used in interviews */

public class SearchingAndSorting {
    public static void main(String[] args) {
        int[] arr1 = {6, 5, 4, 1, 2, 4, 5};

        //selection Sort
        int[] arr2 = doSelectionSort(arr1);
        for (int i : arr2) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.print("\n");
        //Insertion Sort
        arr2 = doInsertionSort(arr1);
        for (int i : arr2) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.print("\n");
        //Bubble Sort
        arr2 = doBubbleSort(arr1);
        for (int i : arr2) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.print("\n");
        //Quick Sort
        arr2 = doQuickSort(arr1, 0, arr1.length - 1);
        for (int i : arr2) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.print("\n");
        //Merge Sort
        int[] a = {2, 6, 4, 2, 9, 3, 8, 6};
        int[] helper = new int[a.length];
        int[] res = doMergeSort(a, 0, a.length - 1, helper);
        for (int i : res) {
            System.out.print(i);
            System.out.print(",");
        }
    }

    public static int[] doSelectionSort(int[] a) {
        for (int i = 0; i <= a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int smallerNumber = a[i];
                    a[i] = a[j];
                    a[j] = smallerNumber;
                }
            }
        }
        return a;
    }
    /* selection sort best Runtime : best and worst =O(n^2) 
                           Space : O(1)          
    */

    public static int[] doInsertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        return a;
    }

    /* insertion sort best =O(n)
  worst =O(n^2) */

    public static int[] doBubbleSort(int[] a) {
        for (int i = a.length; i > 0; i--) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    /* bubble sort best Runtime : best and worst =O(n^2) 
                           Space : O(1)          
    */

    public static int[] doQuickSort(int[] arr, int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        int p = lowerIndex + (higherIndex - lowerIndex) / 2;
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */

            while (arr[i] < arr[p]) {
                i++;
            }
            while (arr[j] > arr[p]) {
                j--;
            }
            if (i <= j) {
                int smallerNumber = arr[i];
                arr[i] = arr[j];
                arr[j] = smallerNumber;
                i++;
                j--;
            }

        }
        if (lowerIndex < j) {
            doQuickSort(arr, lowerIndex, j);
        }
        if (higherIndex > i) {
            doQuickSort(arr, i, higherIndex);
        }
        return arr;
    }
    /* QuickSort best =Simple Partition O(nlogn), 3 way partition O(n)
                      worst =O(n^2) 
                      Average O(nlogn)  */

    public static int[] doMergeSort(int[] inputArr, int low, int high, int[] helper) {
        int[] result = new int[inputArr.length];
        if (low < high) {
            int middle = low + (high - low) / 2;
            doMergeSort(inputArr, low, middle, helper);
            doMergeSort(inputArr, middle + 1, high, helper);
            result = mergeParts(inputArr, low, middle, high, helper);
        }
        return result;
    }

    public static int[] mergeParts(int[] inputArr, int low, int middle, int high, int[] helper) {
        for (int i = low; i <= high; i++) {
            helper[i] = inputArr[i];
        }
        int k = low;
        int i = low;
        int j = middle + 1;
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                inputArr[k] = helper[i];
                i++;
            } else {
                inputArr[k] = helper[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            inputArr[k] = helper[i];
            k++;
            i++;
        }
        return inputArr;
    }

    /* MergeSort best Runtime: worst =O(n)
                               best and Average O(nlogn) 
                        Spsce: Depends       
                               */
}


