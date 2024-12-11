/*
Given an array of positive integers arr[] of size n, the task is to find second largest distinct element in the array.

Note: If the second largest element does not exist, return -1.

------------------------------------------------------------------------------------------------------------------------
*/

import java.util.*;
public class secondLargest1{

    // Using Sorting
    /*
     * The idea is to sort the array in non-decreasing order. Now, we know that the largest element will be at index n - 1. So, starting from index (n - 2), traverse the remaining array in reverse order. As soon as we encounter an element which is not equal to the largest element, return it as the second largest element in the array. If all the elements are equal to the largest element, return -1.
     */
    public static int secondLargest(int arr[])
    {
        int n=arr.length;
        Arrays.sort(arr);

        for(int i=n-1;i>=0;i--)
        {
            if(arr[i]!=arr[n-1]){
                return arr[i];
            }
        }
        return -1;
    }
    // [Naive Approach] Using Sorting - O(n*logn) Time and O(1) Space

    //--------------------------------------------------------------------------------------------------------------------------------------

    // Two Pass Search
    /*
     * The approach is to traverse the array twice. In the first traversal, find the maximum element. In the second traversal, find the maximum element ignoring the one we found in the first traversal.
     */
    public static int secondLargest2(int arr[])
    {
        int n=arr.length;
        int largest=-1;
        int secondLargest=-1;

        for(int i=0;i<n;i++)
        {
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]>secondLargest && arr[i]<largest)
            {
                secondLargest=arr[i];
            }
        }
        return secondLargest;
    }
    // [Better Approach] Two Pass Search - O(n) Time and O(1) Space

    //--------------------------------------------------------------------------------------------------------------------------------------


    // One Pass Search
    /*
     * The idea is to keep track of the largest and second largest element while traversing the array. Initialize largest and second largest with -1. Now, for any index i,

            If arr[i] > largest, update second largest with largest and largest with arr[i].

            Else If arr[i] < largest and arr[i] > second largest, update second largest with arr[i].
     */
    public static int secondLargest3(int[]arr)
    {
        int n=arr.length;
        int largest=-1,secondLargest=-1;

        for(int i=0;i<n;i++)
        {
            if(arr[i]>largest){
                secondLargest=largest;
                largest=arr[i];
            }

            else if(arr[i]<largest &&arr[i]>secondLargest){
                secondLargest=arr[i];
            }
        }
        return secondLargest;
    }
    // [Expected Approach] One Pass Search - O(n) Time and O(1) Space

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,7,8,8};
        System.out.println(secondLargest(arr));
        System.out.println(secondLargest2(arr));
        System.out.println(secondLargest3(arr));
    }
}