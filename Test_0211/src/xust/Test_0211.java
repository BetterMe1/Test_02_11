package xust;

import java.util.Arrays;

/*
1. �������
���� N ���˶�Ա�ĳɼ����ҳ����ǵ�������β�����ǰ������Ӧ�Ľ��ơ�ǰ�����˶�Ա���ᱻ�ֱ����� �����ơ��������ơ� �͡� ͭ�ơ���"Gold Medal", "Silver Medal", "Bronze Medal"����
(ע������Խ�ߵ�ѡ�֣�����Խ��ǰ��)

ʾ�� 1:
����: [5, 4, 3, 2, 1]
���: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
����: ǰ�����˶�Ա�ĳɼ�Ϊǰ���ߵģ���˽���ֱ����� �����ơ��������ơ��͡�ͭ�ơ� ("Gold Medal", "Silver Medal" and "Bronze Medal").
���µ������˶�Ա������ֻ��Ҫͨ�����ǵĳɼ����㽫��������μ��ɡ�
��ʾ:
N ��һ�����������Ҳ��ᳬ�� 10000��
�����˶�Ա�ĳɼ�������ͬ��
 */
/*
 * ������
 * �Ƚ�nums�е��������ַ�������ʽ���ݵ�����array�У��ٽ�nums����Ȼ�����nums�����е�˳���޸�array�����ݣ�
 * ����array���飬��nums���ҵ��������ͬ����������i�������������nums.length-1��nums.length-2 �� nums.length-3����array�д��ַ�����Ӧ��Ϊ"Gold Medal", "Silver Medal" �� "Bronze Medal"��
 * ��������½�nums.length-iתΪ�ַ������滻array��ԭ�ַ����������󷵻�����array��
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
//        //��������
//        for(int i=0; i<nums.length; i++){
//        	array[i] = String.valueOf(nums[i]);
//        }
//        //��������
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
2. ������
����һ�� ��������������ͳ������������������������֮����ȣ����ǳ���Ϊ������������
����һ�� ������ n�� ������������������� True�����򷵻� False

ʾ����
����: 28
���: True
����: 28 = 1 + 2 + 4 + 7 + 14
ע��:
��������� n ���ᳬ�� 100,000,000. (1e8)
 */
/*
 * ������
 * ��temp��num���������������������֮��,temp��ʼΪ1����i=(int)Math.sqrt(num)���£�iÿ�μ�һ��i>1,������,���num%i����0����˵��i��num/i��num�������ӣ���temp += (i+num/i)��
 * ����1��������ֻ��������1�����������������num=1,temp-=1,��󷵻�temp��
 */
//public class Test_0211 {
//	public static void main(String[] args) {
//		int num = 1;
//		Solution So = new Solution();
//		if(So.checkPerfectNumber(num))
//			System.out.println(num+"��������");
//		else
//			System.out.println(num+"����������");
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
 * 쳲���������ͨ���� F(n) ��ʾ���γɵ����г�Ϊ쳲��������С��������� 0 �� 1 ��ʼ�������ÿһ�����ֶ���ǰ���������ֵĺ͡�Ҳ���ǣ�
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), ���� N > 1.
���� N������ F(N)��

ʾ�� 1��
���룺2
�����1
���ͣ�F(2) = F(1) + F(0) = 1 + 0 = 1.

ʾ�� 2��
���룺3
�����2
���ͣ�F(3) = F(2) + F(1) = 1 + 1 = 2.

ʾ�� 3��
���룺4
�����3
���ͣ�F(4) = F(3) + F(2) = 2 + 1 = 3.
��ʾ��
0 �� N �� 30
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