package book.objectorienteddesign.recursion;

public class Method {

    // Code Fragment Summing an array of integers using linear recursion.

    /**
     * Returns the sum of the first n integers of the given array.
     */
    public static int linearSum(int[] data, int n) {
        if (n == 0)
            return 0;
        else
            return linearSum(data, n - 1) + data[n - 1];
    }

    // Code Fragment Reversing the elements of an array using linear recursion.

    /**
     * Reverses the contents of subarray data[low] through data[high] inclusive.
     */
    public static void reverseArray(int[] data, int low, int high) {
        if (low < high) { // if at least two elements in subarray
            int temp = data[low]; // swap data[low] and data[high]
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low + 1, high - 1); // recur on the rest
        }
    }

    // Code Fragment Reversing the elements of a sequence using iteration.

    /**
     * Reverses the contents of the given array.
     */
    public static void reverseIterative(int[] data) {
        int low = 0, high = data.length - 1;
        while (low < high) { // swap data[low] and data[high]
            int temp = data[low];
            data[low++] = data[high]; // post-increment of low
            data[high--] = temp; // post-decrement of high
        }
    }

    // Code Fragment Computing the power function using trivial recursion.

    /**
     * Computes the value of x raised to the nth power, for nonnegative integer n.
     */
    public static double power1(double x, int n) {
        if (n == 0)
            return 1;
        else
            return x * power1(x, n - 1);
    }

    // Code Fragment Computing the power function using repeated squaring.

    /**
     * Computes the value of x raised to the nth power, for nonnegative integer n.
     */
    public static double power2(double x, int n) {
        if (n == 0)
            return 1;
        else {
            double partial = power2(x, n / 2); // rely on truncated division of n
            double result = partial * partial;
            if (n % 2 == 1) // if n odd, include extra factor of x
                result *= x;
            return result;
        }
    }

    // Code Fragment Summing the elements of a sequence using binary recursion

    /**
     * Returns the sum of subarray data[low] through data[high] inclusive.
     */
    public static int binarySum(int[] data, int low, int high) {
        if (low > high) // zero elements in subarray
            return 0;
        else if (low == high) // one element in subarray
            return data[low];
        else {
            int mid = (low + high) / 2;
            return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
        }
    }


}
