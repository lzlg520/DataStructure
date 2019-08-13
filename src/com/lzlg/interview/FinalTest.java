package com.lzlg.interview;

public class FinalTest {
    public static void main(String[] args) {
        final int x = 0;
        int y = 1;
        int[] z = {2};
        final int[] n = {3};

        use(x, y, z, n);
    }

    static void use(final int x, int y, final int[] z, int[] n) {
//        x++;
        y++;
        y = x;
        z[0]++;
        n[0]++;
//        z = n;
    }
}
