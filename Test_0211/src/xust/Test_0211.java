package xust;

import java.util.Arrays;

/*
1. 相对名次
给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
(注：分数越高的选手，排名越靠前。)

示例 1:
输入: [5, 4, 3, 2, 1]
输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
提示:
N 是一个正整数并且不会超过 10000。
所有运动员的成绩都不相同。
 */
/*
 * 分析：
 * 先将nums中的内容以字符串的形式备份到数组array中，再将nums排序，然后对照nums数组中的顺序修改array的内容，
 * 遍历array数组，在nums中找到与此数相同的数的索引i，如果索引等于nums.length-1、nums.length-2 或 nums.length-3，将array中此字符串对应改为"Gold Medal", "Silver Medal" 或 "Bronze Medal"，
 * 其他情况下将nums.length-i转为字符串来替换array中原字符串，结束后返回数组array。
 */
//public class Test_0211 {
//	public static void main(String[] args) {
//		int[] nums ={5, 4, 3, 2, 1};
//		Solution So = new Solution();
//		String[] array = So.findRelativeRanks(nums);
//		for(int i=0; i<array.length; i++){
//			System.out.print(array[i]+", ");
//		}
//	}
//}
//
//class Solution {
//    public String[] findRelativeRanks(int[] nums) {
//        String[] array = new String[nums.length] ;
//        //备份数组
//        for(int i=0; i<nums.length; i++){
//        	array[i] = String.valueOf(nums[i]);
//        }
//        //数组排序
//        Arrays.sort(nums);
//        for(int j=0; j<array.length; j++){
//        	for(int i=nums.length-1; i>=0; i--){
//        		if(array[j].equals(String.valueOf(nums[i]))){
//        			if(i == nums.length-1)
//        				array[j] = "Gold Medal";
//        			else if(i == nums.length-2)
//        				array[j] = "Silver Medal";
//        			else if(i == nums.length-3)
//        				array[j] = "Bronze Medal";
//        			else{
//        				array[j] = String.valueOf(nums.length-i);
//        			}
//        			break;
//        		}
//        	}
//        }
//        return array;
//    }
//}
/*
2. 完美数
对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
给定一个 正整数 n， 如果他是完美数，返回 True，否则返回 False

示例：
输入: 28
输出: True
解释: 28 = 1 + 2 + 4 + 7 + 14
注意:
输入的数字 n 不会超过 100,000,000. (1e8)
 */
/*
 * 分析：
 * 用temp存num除自身以外的所有正因子之和,temp初始为1，从i=(int)Math.sqrt(num)向下（i每次减一，i>1,）遍历,如果num%i等于0，则说明i、num/i是num的正因子，则temp += (i+num/i)，
 * 由于1是特例，只有正因子1，且是它本身，因此若num=1,temp-=1,最后返回temp。
 */
//public class Test_0211 {
//	public static void main(String[] args) {
//		int num = 1;
//		Solution So = new Solution();
//		if(So.checkPerfectNumber(num))
//			System.out.println(num+"是完美数");
//		else
//			System.out.println(num+"不是完美数");
//		
//	}
//}
//class Solution {
//    public boolean checkPerfectNumber(int num) {
//    	int temp = 1;
//        for(int i=(int)Math.sqrt(num); i>1; i--){
//        	if(num % i == 0)
//        		temp += (i+num/i);
//        }
//        if(num == 1)
//        	temp-=1;
//        return temp == num;
//    }
//}
/*
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
给定 N，计算 F(N)。

示例 1：
输入：2
输出：1
解释：F(2) = F(1) + F(0) = 1 + 0 = 1.

示例 2：
输入：3
输出：2
解释：F(3) = F(2) + F(1) = 1 + 1 = 2.

示例 3：
输入：4
输出：3
解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
提示：
0 ≤ N ≤ 30
 */
public class Test_0211 {
	public static void main(String[] args) {
		int N = 4;
		Solution So = new Solution();
		System.out.println(So.fib2(N));
	}
}
class Solution {
    public int fib1(int N) {
    	if(N < 2)
    		return N;
    	int left = 0;
    	int right = 1;
    	int ret = 0;
        for(int i=2; i<=N; i++){
        	ret = left + right;
        	left = right;
        	right = ret;
        }
        return ret;
    }
    public int fib2(int N) {
    	if(N < 2)
    		return N;
    	return fib2(N-1)+fib2(N-2);
    }
}