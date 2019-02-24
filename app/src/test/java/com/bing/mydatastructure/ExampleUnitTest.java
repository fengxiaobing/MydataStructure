package com.bing.mydatastructure;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        int[] ints = {2,3,4};
        System.out.println(sum(ints));
    }

    public int sum(int[] nums){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}