import java.math.BigInteger;

public class PlusOne {

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 9};
        print(nums);

        Solution solution = new Solution();
        int[] result = solution.plusOne(nums);

        print(result);
    }

    static void print(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int i : digits) {
            sb.append(i);
        }

        System.out.println(sb.toString());
    }
}

class Solution {
    private static BigInteger one = new BigInteger("1");

    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int i : digits) {
            sb.append(i);
        }

        BigInteger bi = new BigInteger(sb.toString());
        BigInteger result = bi.add(one);

        String s = String.valueOf(result);
        int len = s.length();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = s.charAt(i) - '0';
        }

        return array;
    }
}
