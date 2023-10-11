import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestNumbers {

    public static String[] findClosestPairs(int[] arr) {
        if (arr.length < 2 || arr.length > 1000) {
            throw new IllegalArgumentException("Array boyutu 2 ile 1000 arasında olmalıdır.");
        }

        for (int num : arr) {
            if (num < -20000 || num > 20000) {
                throw new IllegalArgumentException("Array elemanları -20.000 ile 20.000 arasında olmalıdır.");
            }
        }

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < minDiff && diff > 0) {
                minDiff = diff;
            }
        }

        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == minDiff) {
                resultList.add(arr[i] + " " + arr[i + 1]);
            }
        }

        return resultList.toArray(new String[0]);
    }

}
