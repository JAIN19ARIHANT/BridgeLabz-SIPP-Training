public class PeakElementFinder {
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean leftIsSmaller = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean rightIsSmaller = (mid == arr.length - 1) || (arr[mid] > arr[mid + 1]);

            if (leftIsSmaller && rightIsSmaller) {
                return mid;
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {70, 22, 687, 31, 71, 43};
        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element is " + arr[peakIndex] + " at index " + peakIndex);
    }
}