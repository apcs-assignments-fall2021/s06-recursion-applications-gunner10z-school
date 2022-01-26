import java.util.ArrayList;

public class MyMain {
    // **************************
    // In-class Practice Problems
    // **************************

    // Write a method that uses recursion to search for a value in
    // an array using binary search!

    // Examples:
    // binarySearch([5, 2, 4, 3], 4) => true
    // binarySearch([6, 7, 1, 2, 8], 5) => false

    // Wrapper Method
    public static boolean binarySearch(int[] arr, int num) {
        return binarySearchTR(arr, num, 0, arr.length-1);
    }

    // Tail recursive method:
    public static boolean binarySearchTR(int[] arr, int num, int lowerBound, int upperBound) {
        if (upperBound >= lowerBound && lowerBound <= arr.length - 1) {

            int mid = lowerBound + (upperBound - lowerBound) / 2;

            if (arr[mid] == num)
                return true;

            if (arr[mid] > num)
                return binarySearchTR(arr, num, lowerBound, mid - 1);


            return binarySearchTR(arr, num, mid+1, upperBound);
        }

        return false;
    }





    // ********************
    // Methods for homework:
    // ********************

    // This method does not use recursion!

    // Write a method takes two sorted arrays as input and combines them
    // into one large combined arrays.

    // Here is the pseudocode for merge:
    // * Create a new big output array
    // * Start at the beginning of both input arrays
    // * Take the smaller of the two values and add it to the output array
    // * Repeat until we’ve gone through all the values in one of the arrays
    // * Copy the remaining values from the other array into the output array

    // Here's an example of how it looks in action:
    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [                         ]
    //         ^                         ^                           ^
    //     idx1 = 0                  idx2 = 0                   outputIdx = 0

    // The current value in arr1 (1) is smaller than the current value
    // in arr2 (2). So we copy 1 into the output array. Then we increment
    // both idx1 and outputIdx:

    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [1,                       ]
    //            ^                      ^                              ^
    //        idx1 = 1               idx2 = 0                      outputIdx = 1

    // The current value in arr1 (4) is larger than the current value
    // in arr2 (2). So we copy 2 into the output array. Then we increment
    // both idx2 and outputIdx:

    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [1, 2,                     ]
    //            ^                         ^                              ^
    //        idx1 = 1                  idx2 = 1                      outputIdx = 2

    // We continue on until one of the arrays is empty
    // Then we need to copy the rest of the array

    public static int[] merge(int[] arr1, int[] arr2) {
        /*int[] arr3=new int[arr1.length+arr2.length];
        // YOUR CODE HERE
        int count1=0;
        int count2=0;
        int count3=0;
        while(count3<arr1.length+arr2.length){
            if(count2==arr2.length-1){
                arr3[count3]=arr1[count1];
                count3++;
                count1++;
            }
            else if (count1==arr1.length-1){
                arr3[count3]=arr2[count2];
                count3++;
                count2++;
            }
            else if((arr1[count1]<arr2[count2])||(count2==arr2.length-1)){
                arr3[count3]=arr1[count1];
                count3++;
                count1++;
            }
            else if(arr1[count1]>arr2[count2]||count1==arr1.length-1){
                arr3[count3]=arr2[count2];
                count3++;
                count2++;
            }
            else{
                arr3[count3]=arr1[count1];
                count3++;
                count1++;
            }
        }
        return null;*/
        int[] arr3 = new int[arr1.length + arr2.length];
        int idx1 = 0;
        int idx2 = 0;
        int outputIdx = 0;

        while (idx1 < arr1.length && idx2 < arr2.length) {
            if (arr1[idx1] < arr2[idx2]) {
                arr3[outputIdx] = arr1[idx1];
                idx1++;
            } else {
                arr3[outputIdx] = arr2[idx2];
                idx2++;
            }
            outputIdx++;
        }

        while (idx1 < arr1.length) {
            arr3[outputIdx] = arr1[idx1];
            idx1++;
            outputIdx++;
        }

        while (idx2 < arr2.length) {
            arr3[outputIdx] = arr2[idx2];
            idx2++;
            outputIdx++;
        }

        return arr3;
    }
    public static void main(String[] args){
        int[] arr3 = {-4, 5, 7, 8};
        int[] arr4 = {-5, -1, 2, 3};
        merge(arr3, arr4);
    }
}
