public class PlusOne {
    public static void main(String[] args) throws Exception {
        int[] a = {1, 1, 1, 1};
        int[] b = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        Solution solution = new Solution();
        int[] result = solution.plus(a, b);
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
    public int[] plus(int[] a, int[] b) throws Exception {
        if (a.length <= 0 || b.length <= 0) {
            throw new Exception("input error");
        }

        for (int i : a) {
            if (i < 0 || i > 9) {
                throw new Exception("input error");
            }
        }

        for (int i : b) {
            if (i < 0 || i > 9) {
                throw new Exception("input error");
            }
        }

        int[] c = add(a, b);
        return c;
    }

    private int[] add(int[] a, int[] b) {
        int lena = a.length;
        int lenb = b.length;
        int maxLen = lena > lenb ? lena : lenb;

        int[] c = new int[maxLen + 1];
        int[] an = format(a, maxLen);
        int[] bn = format(b, maxLen);

        boolean flag = false;
        for (int i = maxLen - 1; i >= 0; i--) {
            int tmp = 0;
            if (flag) {
                tmp = an[i] + bn[i] + 1;
            } else {
                tmp = an[i] + bn[i];
            }

            if (tmp >= 10) {
                c[i + 1] = tmp % 10;
                flag = true;
            } else {
                c[i + 1] = tmp;
                flag = false;
            }
        }

        if (flag) {
            c[0] = 1;
        }

        return c;
    }

    private int[] format(int[] digits, int len) {
        if (digits.length == len) {
            return digits;
        }

        int[] c = new int[len];
        for (int i = len - 1, j = digits.length - 1; j >= 0; i--, j--) {
            c[i] = digits[j];
        }

        return c;
    }
}
