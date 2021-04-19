/*
 * The given code is provided to assist you to complete the required tasks. But the given code is
 * often incomplete. You have to read and understand the given code carefully, before you can apply
 * the code properly.
 */


/*
 * Please review Lecture 5 Algorithms Part I, slide 20 to complete this task.
 */
public class MergeSort {

  /**
   * Sorts an array [1...n] by divide-and-conquer. It must use merge() method.
   *
   * @param input array a needs to be sorted.
   */
  public static void mergeSort(int[] a) {
    /*  */
    int[] L = null; // This array will store the left half of array
    int[] R = null; // This array will store the right half of array
    // TODO: Complete this method
    // START YOUR CODE
    if (a.length <= 1)
      return;

    L = new int[a.length / 2];
    R = new int[a.length - L.length];
    for (int i = 0; i < L.length; i++) {
      L[i] = a[i];
    }
    for (int i = L.length; i < a.length; i++) {
      R[i - L.length] = a[i];
    }
    mergeSort(L);
    mergeSort(R);



    // END YOUR CODE
    merge(a, L, R); // Do not modify this part of code.
  }


  /**
   * Merges sorted subarray L and subarray R into sorted array a.
   *
   * @param merged array a,
   * @param input sorted subarray L,
   * @param input sorted subarray R.
   */
  public static void merge(int[] a, int[] L, int[] R) {

    tracker.calltracking(a, L, R); // Do not modify this method. Otherwise, you will be penalized
                                   // for violation.
    // TODO: Complete this method
    // START YOUR CODE
    int[] result = new int[L.length + R.length];
    int i = 0;
    int j = 0;
    int k = 0;

    do {
      if (L[i] < R[j])
        result[k++] = L[i++];

      else
        result[k++] = R[j++];

    } while (i < L.length && j < R.length);
    if (j >= R.length)
      while (i < L.length)
        result[k++] = L[i++];
    else
      while (j < R.length)
        result[k++] = R[j++];
    for (i = 0, j = 0; i <= L.length + R.length - 1; i++, j++)
      a[i] = result[j];


    // END YOUR CODE

  }

}
