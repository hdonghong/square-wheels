package pers.hdh.recursion;

/**
 * Sum class<br/>
 * 递归求数组和
 * @author hdonghong
 * @date 2018/05/06
 */
public class Sum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(sum(arr));
    }

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int lo) {
        return lo == arr.length ? 0 : arr[lo] + sum(arr, lo + 1);
    }
}
