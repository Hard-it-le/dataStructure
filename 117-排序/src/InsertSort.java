import utils.Integers;
import utils.Utils;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/10
 * <p>
 * 插入排序
 */
public class InsertSort extends Utils {

    public static void main(String[] args) {

        Integer[] array = {10, 6, 9, 12, 45, 67, 14, 32};
        Integers.println(array);
        insertSortTest02(array);
        Integers.println(array);
    }

    public static void insertSortTest01(Integer[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int n = array.length;
        for (int end = 1; end < n; end++) {
            int curIndex = end;
            while (curIndex - 1 >= 0 && array[curIndex - 1] > array[curIndex]) {
                swap(array, curIndex - 1, curIndex);
                curIndex--;
            }
        }
    }


    public static void insertSortTest02(Integer[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int n = array.length;

        for (int end = 1; end < n; end++) {
            //pre : newValue的前一个位置
            for (int pre = end - 1; pre >= 0 && array[pre] > array[pre+1]; pre--) {
                swap(array, pre, pre + 1);
            }
        }
    }
}
