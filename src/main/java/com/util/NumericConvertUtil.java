//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.util;

public class NumericConvertUtil {
    private static final char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '-', '_'};

    public NumericConvertUtil() {
    }

    private static String toBaseString(long n, int base) {
        long num = 0L;
        if (n < 0L) {
            num = 4294967294L + n + 2L;
        } else {
            num = n;
        }

        char[] buf = new char[32];

        int charPos;
        for(charPos = 32; num / (long)base > 0L; num /= (long)base) {
            --charPos;
            buf[charPos] = digits[(int)(num % (long)base)];
        }

        --charPos;
        buf[charPos] = digits[(int)(num % (long)base)];
        return new String(buf, charPos, 32 - charPos);
    }

    public static String toBaseString(long n, NumericConvertUtil.BaseType baseType) {
        return toBaseString(n, baseType.getBase());
    }

    private static long toDecimal(String str, int base) {
        char[] buf = new char[str.length()];
        str.getChars(0, str.length(), buf, 0);
        long num = 0L;

        for(int i = 0; i < buf.length; ++i) {
            for(int j = 0; j < digits.length; ++j) {
                if (digits[j] == buf[i]) {
                    num = (long)((double)num + (double)j * Math.pow((double)base, (double)(buf.length - i - 1)));
                    break;
                }
            }
        }

        return num;
    }

    public static long toDecimal(String str, NumericConvertUtil.BaseType baseType) {
        return toDecimal(str, baseType.getBase());
    }

    public static void main(String[] args) {
        String s = "";
        char[] arr$ = digits;
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            char c = arr$[i$];
            s = s + c;
        }

        System.out.println(s);
        System.out.println(s.matches("[\\w|\\-]{1,10}"));
    }

    public static enum BaseType {
        BASE_64(64),
        BASE_16(16);

        private final int base;

        private BaseType(int base) {
            this.base = base;
        }

        public int getBase() {
            return this.base;
        }
    }
}
