import java.lang.Math;

public class SearchingAndSorting{
    public static void main(String[] args){
        int[] arr1 = {6,5,4,1,2,4,5};

        //selection Sort
       int[] arr2 = doSelectionSort(arr1);
        for(int i:arr2){
            System.out.print(i);
            System.out.print(",");
        }
        System.out.print("\n");
        //Insertion Sort
        arr2 = doInsertionSort(arr1);
        for(int i:arr2){
            System.out.print(i);
            System.out.print(",");
        }
        System.out.print("\n");
        //Bubble Sort
        arr2 = doBubbleSort(arr1);
        for(int i : arr2){
            System.out.print(i);
            System.out.print(",");
        }
        System.out.print("\n");
        //Quick Sort
        arr2 = doQuickSort(arr1 ,0, arr1.length - 1);
        for (int i: arr2){
            System.out.print(i);
            System.out.print(",");
        }

    }

    public static int[] doSelectionSort(int[] a){
        for(int i = 0; i<=a.length; i++){
            for(int j = i+1; j<a.length; j++){
                if(a[i] > a[j]){
                    int smallerNumber = a[i];
                    a[i] = a[j];
                    a[j] = smallerNumber;
                }
            }
        }
        return a;
    }


    public static int[] doInsertionSort(int[] a){
        for(int i = 0; i < a.length; i++){
            for(int j =i ; j > 0 ;j--){
                if(a[j] < a[j-1]) {
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
        return a;
    }

    public static int[] doBubbleSort(int[] a){
        for(int i = a.length; i>0 ; i--){
            for(int j = 0; j < a.length-1; j++) {
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }

    public static int[] doQuickSort(int[] arr, int lowerIndex, int higherIndex){
        int i = lowerIndex;
        int j = higherIndex;
        int p = lowerIndex + (higherIndex - lowerIndex) /2;
        while(i <= j){
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */

            while (arr[i] < arr[p]){
                i++;
            }
            while (arr[j] > arr[p]){
                j--;
            }
            if(i <= j){
                int smallerNumber = arr[i];
                arr[i] = arr[j];
                arr[j] = smallerNumber;
                i++;
                j--;
            }

        }
        if(lowerIndex < j){
            doQuickSort(arr, lowerIndex, j);
        }
        if(higherIndex > i){
            doQuickSort(arr, i,higherIndex);
        }
        return arr;
    }
}
