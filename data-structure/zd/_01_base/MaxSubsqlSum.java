package _01_base;

/**
 * MaxSubsqlSum class<br/>
 * 最大子序列和问题
 * 给定N个整数序列，求最大子序列的和
 *
 * @author hdonghong
 * @date 2018/04/09
 */
public class MaxSubsqlSum {

    /** O(n3次幂) */
    public int maxSubsqlSum_1(int[] A, int N) {
        int i, j, k;
        int thisSum = 0, maxSum = 0;
        for (i = 0; i < N; i++) {
            for (j = i; j < N; j++) {
                thisSum = 0;
                for (k = i; k <= j; k++) {
                    thisSum += A[k];
                }
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    /** O(n2次幂) */
    public int maxSubsqlSum_2(int[] A, int N) {
        int i, j, k;
        int thisSum = 0, maxSum = 0;
        for (i = 0; i < N; i++) {
            thisSum = 0;
            for (j = i; j < N; j++) {
                thisSum += A[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    /** 分而治之 O(nlgn) */
    public int maxSubsqlSum_3(int[] A, int N) {
        return divideAndConquer(A, 0, N-1);
    }

    private int divideAndConquer(int A[], int left, int right) {
        // 递归的终止条件
        if (left == right) {
            if (A[left] > 0) return left;
            else return 0;
        }

        int center = (left + right) >> 1;// 中心边界
        int maxLeft = divideAndConquer(A, left, center);// 求左边最大子序列和
        int maxRight = divideAndConquer(A, center+1, right);// 求右边最大子序列和

        // 跨越边界
        int i;
        int leftBorder = 0, maxLeftBorder = 0;
        for (i = center; i >= left; i--) {// 求左边界最大子序列和
            leftBorder += A[i];
            if (leftBorder > maxLeftBorder)
                maxLeftBorder = leftBorder;
        }
        int rightBorder = 0, maxRightBorder = 0;
        for (i = center + 1; i <= right; i++) {// 求右边界最大子序列和
            rightBorder += A[i];
            if (rightBorder > maxRightBorder) {
                maxRightBorder = rightBorder;
            }
        }

        return max3(maxLeft, maxRight, maxLeftBorder+maxRightBorder);
    }
    private int max3(int a, int b, int c) {
        return a > b ? a > c ? a : c : b > c ? b : c;
    }

    /** 在线处理 O(n) */
    public int maxSubsqlSum_4(int[] A, int N) {
        int thisSum = 0, maxSum = 0;
        int i;
        for (i = 0; i < N; i++) {
            thisSum += A[i];
            if (thisSum > maxSum)
                maxSum = thisSum;
            else if (thisSum < 0)// 如果当前子序列和为负，则不可能使后面的部分和增大，抛弃之
                thisSum = 0;
        }
        return maxSum;
    }
}
