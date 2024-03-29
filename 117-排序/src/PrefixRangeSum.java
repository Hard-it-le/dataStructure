import utils.Integers;
import utils.Utils;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/11
 * <p>
 * 前缀和
 */
public class PrefixRangeSum extends Utils {

    private static Integer[] prefixSum;

    public static void main(String[] args) {


        Integer[] array = {10, 6, 9, 12, 45, 67, 14, 32};

        Integers.println(array);
        PrefixRangeSum1(array);
        Integers.println(prefixSum);
        int i = rangeSum(2, 5);
        System.out.println(i);
    }


    public static void PrefixRangeSum1(Integer[] array) {
        int n = array.length;
        prefixSum = new Integer[n];
        prefixSum[0] = array[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i];

        }
    }

    public static int rangeSum(int l, int r) {
        if (l == 0) {
            return prefixSum[r];
        } else {
            return prefixSum[r] - prefixSum[l - 1];

        }
    }

}
