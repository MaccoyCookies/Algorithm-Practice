package com.maccoy.algorithm;

/**
 * @author Maccoy
 * @date 2022/12/5
 * Description 找到出现了k次的数(只有一种数字出现了k次, 剩下的数字只出现了n次, (k<n && n>1))
 * 要求: 时间复杂度O(n), 空间复杂度O(1)
 */
public class KN {





















    public static void main(String[] args) {
        int[] test = new int[]{
                5, 5, 5, 5, 5, 5,
                7, 7, 7, 7, 7, 7,
                8, 8, 8, 8, 8, 8,
                1,
        };
        System.out.println(onlyKTimes(test, 1, 6));
    }

    public static int onlyKTimes(int[] arr, int k, int n) {
        int[] t = new int[32];
        for (int i = 0; i < t.length; i++) {
            for (int i1 : arr) {
                t[i] += ((i1 >> i) & 1);
            }
        }
        int result = 0;
        for (int i = t.length - 1; i >= 0; i--) {
            if (t[i] % n != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }

}
