package com.maccoy.algorithm;

import java.util.*;

/**
 * @author Maccoy
 * @date 2022/12/5
 * Description 找到出现了k次的数(只有一种数字出现了k次, 剩下的数字只出现了n次, (k<n && n>1))
 * 要求: 时间复杂度O(n), 空间复杂度O(1)
 */
public class KN {

    public static void main(String[] args) {
        int maxKinds = 100;
        int range = 200;
        int testTime = 100000;
        int timesMax = 100;
        for (int i = 0; i < testTime; i++) {
            int a = (int) (Math.random() * timesMax) + 1;
            int b = (int) (Math.random() * timesMax) + 1;
            int k = Math.min(a, b);
            int n = Math.max(a, b);
            if (k == n) {
                n++;
            }
            int[] arr = randomArray(maxKinds, range, k, n);
            int ans_1 = test(arr, k, n);
            int ans_2 = onlyKTimes(arr, k, n);
            if (ans_1 != ans_2) {
                System.err.println("error! array: " + Arrays.toString(arr));
            }
        }
    }

    public static int[] randomArray(int maxKinds, int range, int k, int n) {
        int kTimesNumber = randomNumber(range);
        int numberKinds = (int) (Math.random() * maxKinds) + 2;
        int[] arr = new int[(numberKinds - 1) * n + k];
        int cur = 0;
        for (int i = 0; i < k; i++) {
            arr[cur++] = kTimesNumber;
        }

        Set<Integer> containsSet = new HashSet<>();
        containsSet.add(kTimesNumber);
        for (int i = 0; i < numberKinds - 1; i++) {
            int nTimesNumber = 0;
            do {
                nTimesNumber = randomNumber(range);
            } while (containsSet.contains(nTimesNumber));
            for (int i1 = 0; i1 < n; i1++) {
                arr[cur++] = nTimesNumber;
            }
        }
        return arr;
    }

    /**
     * [-range, +range]
     */
    public static int randomNumber(int range) {
        return ((int) (Math.random() * range) + 1) - ((int) (Math.random() * range) + 1);
    }

    public static int test(int[] arr, int k, int n) {
        Map<Integer, Integer> container = new HashMap<>();
        for (int i : arr) {
            if (container.containsKey(i)) {
                container.put(i, container.get(i) + 1);
            } else {
                container.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : container.entrySet()) {
            if (integerIntegerEntry.getValue().equals(k)) {
                return integerIntegerEntry.getKey();
            }
        }
        return -1;
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
