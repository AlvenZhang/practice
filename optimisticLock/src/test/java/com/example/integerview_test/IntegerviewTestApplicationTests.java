package com.example.integerview_test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IntegerviewTestApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        new IntegerviewTestApplicationTests().canPartition2(new int[]{2,2,3,5});
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int[][] dp = new int[nums.length][sum / 2 + 1];
        // 初始化dp
        for (int i = nums[0]; i <= sum / 2; i++) {
            dp[0][i] = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if(j >= nums[i]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][sum/2] == sum/2;
    }


    public boolean canPartition2(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum % 2 != 0) {
                return false;
            }
            int[] dp = new int[sum / 2 + 1];
            // 初始化dp
            for (int i = nums[0]; i <= sum / 2; i++) {
                dp[i] = nums[0];
            }

            for (int i = 1; i < nums.length; i++) {
                for (int j = sum/2; j > nums[i]; j--) {
                        dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
                }
            }
            return dp[sum/2] == sum/2;
    }

}
