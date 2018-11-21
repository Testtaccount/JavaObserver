package book.objectorienteddesign.recursion.binary;

public class Binary {

    /**
     * Returns true if the target value is found in the data array.
     */
    public static int binarySearch(int[] data, int target) {
        return binarySearch(data, target, 0, data.length - 1); // use parameterized version
    }

    public static int binarySearch(int[] sortedArray, int key, int low, int high) {
        int middle = low + (high - low) / 2;
        if (high < low) return -1;
        if (key == sortedArray[middle]) return middle;
        else if (key < sortedArray[middle]) return binarySearch(sortedArray, key, low, middle - 1);
        else return binarySearch(sortedArray, key, middle + 1, high);
    }

    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    //Code Fragment a nonrecursive implementation of binary search.

    /**
     * Returns true if the target value is found in the data array.
     */
    public static boolean binarySearchIterative(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == data[mid]) // found a match
                return true;
            else if (target < data[mid])
                high = mid - 1; // only consider values left of mid
            else
                low = mid + 1; // only consider values right of mid
        }
        return false; // loop ended without success
    }
}
