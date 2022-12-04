package com.maccoy.algorithm;

/**
 * @author Maccoy
 * @date 2022/12/5
 * Description
 */
public class CommonMethod {

    public static void swapIntegerArray(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
