package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengnanfa
 * @date 2021/5/25 23:15
 */
public class TestData {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>(4);
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }
    boolean solve(List<Double> nums){
        if(nums.size() == 1){
            return Math.abs(nums.get(0) - 24) <= 0.00001;
        }
        for(int i = 0; i < nums.size(); i++){
            for(int j = i + 1; j < nums.size(); j++){
                List<Double> copy = new ArrayList<>(nums);
                double b = copy.remove(j), a = copy.remove(i);
                boolean valid = false;
                // 这里数组减少了一位，这里的组合种类有以下六种
                copy.add(a + b);
                // 这里是取异或操作
                valid |= solve(copy);
                // 更新最后一个位置的值，做计算
                copy.set(copy.size() - 1, a - b);
                valid |= solve(copy);
                copy.set(copy.size() - 1, a * b);
                valid |= solve(copy);
                copy.set(copy.size() - 1, a / b);
                valid |= solve(copy);
                copy.set(copy.size() - 1, b - a);
                valid |= solve(copy);
                copy.set(copy.size() - 1, b / a);
                valid |= solve(copy);
                if(valid) return true;
            }
        }
        return false;
    }
}
