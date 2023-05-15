public class RecursiveSearch {
    public static void main(String[] args) {
        String[] arr = {"hey", "there", "you"};
        System.out.println(recursiveSearch("hey", arr, 0)); // Output: 0
        System.out.println(recursiveSearch("porcupine", arr, 0)); // Output: -1
    }

    public static int recursiveSearch(String target, String[] arr, int index) {
        if (index >= arr.length) {
            return -1;
        }
        if (arr[index].equals(target)) {
            return index;
        } else {
            return recursiveSearch(target, arr, index + 1);
        }
    }
}

// O(n), where n is the size of the input array