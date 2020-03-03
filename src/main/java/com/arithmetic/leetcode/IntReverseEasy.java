package com.arithmetic.leetcode;

import java.util.*;

/**
 * @author LiuPeng
 * @description
 * @date 2019/2/28
 */
public class IntReverseEasy {

    public static void main(String[] args) {

        //System.out.println(isPalindrome(10));
        //System.out.println(intReverse(1234));
        //System.out.println(romanToInt("MCMXCIV"));
        /*String[] compare = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(compare));*/
        //System.out.println(isValid("()"));
       /* ListNode n1 = new ListNode();
        n1.add(1);
        n1.add(3);
        n1.add(6);
        System.out.println(n1.getLength());

        ListNode n4 = new ListNode();
        n4.add(2);
        n4.add(4);
        n4.add(5);
        System.out.println(n4.getLength());
        mergeTwoLists(n1.head, n4.head);*/
       /*int[] num = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeElement(num, 2));*/

        String haystack = "aaa", needle = "a";
        System.out.println(strStr(haystack, needle));
    }




    /*
    实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
    */
    public static int strStr(String haystack, String needle) {
        try {
            if ("".equals(needle)) return 0;
            if (haystack.contains(needle)) {
                for (int i = 0; i < haystack.length(); i++) {
                    if (haystack.charAt(i) == needle.charAt(0)) {
                        if (haystack.substring(i, i + needle.length()).equals(needle)) return i;
                    }
                }
            }
            return -1;
        } catch (Throwable t) {
            return -1;
        }
    }

    public static int strStr2(String haystack, String needle) {
        char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == chars1[0]) {
                boolean falg = true;
                for (int j = 1; j < chars1.length; j++) {
                    if (chars[i + j] != chars1[j]) {
                        falg = false;
                        break;
                    }
                }
                if (falg) {
                    return i;
                }
            }
        }
        return count;
    }

   /* 我写的失败代码，不能通过测试
   public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (needle.length() > haystack.length())
            return -1;
        int count = -1;
        a:
        for (int i = 0; i < haystack.length(); i++) {
            char start = haystack.charAt(i);
            for (int j = 0; j < needle.length() && start == needle.charAt(0); j++) {
                count = i;
                if (++i < haystack.length() && ++j < needle.length()) {
                    if (haystack.charAt(i) != needle.charAt(++j)) {
                        count = -1;
                        break;
                    } else {
                        String substring = haystack.substring(count, i);
                        if (substring.equals(needle)) {
                            break a;
                        }
                        continue;
                    }
                } else {
                    break;
                }
            }
        }
        return count;
    }*/


    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.println(nums[i]);
        }
        return count;
    }

    /*
    给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:

给定数组 nums = [1,1,2],

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

你不需要考虑数组中超出新长度后面的元素。
示例 2:

给定 nums = [0,0,1,1,1,2,2,3,3,4],

函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

你不需要考虑数组中超出新长度后面的元素。
说明:

为什么返回数值是整数，但输出的答案是数组呢?

请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下:

// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
    */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[count] != nums[i]) {
                ++count;
                nums[count] = nums[i];
            }
        }
        for (int i = 0; i <= count; i++) {
            System.out.println(nums[i]);
        }
        return count + 1;
    }

    // 定义一个节点
    public static class ListNode {
        private ListNode head;

        private int val;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int data) {
            this.val = data;
        }

        // 添加节点
        public void add(int data) {
            ListNode node = new ListNode(data);
            if (null == head) { // 头节点是否为空
                head = node;
                return;
            }
            ListNode addNode = head;
            while (null != addNode.next) {
                addNode = addNode.next;
            }
            addNode.next = node;
        }

        public int getLength() {
            int length = 0;
            if (null != head) {
                ListNode node = head;
                ++length;
                while (null != node.next) {
                    ++length;
                    node = node.next;
                }
            }
            return length;
        }

    }


    /*将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

    示例：

    输入：1->2->4, 1->3->4
    输出：1->1->2->3->4->4*/
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                node = node.next; // 1 3
                l1 = l1.next;
            } else {
                node.next = l2;
                node = node.next;// 2 4
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            node.next = l2;
        } else {
            node.next = l1;
        }
        return dummyHead.next;
    }
   /* public static Node mergeTwoLists(Node l1, Node l2) {
        Node node = new Node();
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                node.add(l1.data);
                l1 = l1.next;
            } else {
                node.add(l2.data);
                l2 = l2.next;
            }
        }
        while (l1 != null){
            node.add(l1.data);
            l1 = l1.next;
        }

        while (l2 != null){
            node.add(l2.data);
            l2 = l2.next;
        }
        return node;
    }*/


    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * <p>
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * <p>
     * 所有输入只包含小写字母 a-z 。
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
       /* String prefix = "";
        // 1. 先找到数组中长度最小的
        // 2. 循环找到公共前缀
        if (null != strs && strs.length > 0) {
            String strShort = "";
            int length = Integer.MAX_VALUE;
            for (String str : strs) {
                if (length > str.length()) {
                    length = str.length();
                    strShort = str;
                }
            }
            falg : for (int i = 0; i < length; i++) {
                Character compare = strShort.charAt(i);
                for (int j = 0; j < strs.length; j++) {
                    if (!compare.equals(strs[j].charAt(i))) {
                        break falg;
                    }
                }
                prefix = prefix + strShort.charAt(i);
            }
        }
        return prefix;*/
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     * <p>
     * 输入: "{[]}"
     * 输出: true
     */

    public static boolean isValid(String bracket) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        Stack<Character> stack = new Stack();
        Character sol = null;
        for (int i = 0; i < bracket.length(); i++) {
            sol = bracket.charAt(i);
            if (brackets.containsKey(sol)) {
                // 左边的出栈
                Character pop = stack.empty() ? '#' : stack.pop();
                if (!brackets.get(sol).equals(pop)) {
                    return false;
                }
            } else {
                // 把右边的括号入栈
                stack.push(sol);
            }
        }
        return stack.empty();
    }

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
     * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     */
    // 罗马数字转整数
    public static int romanToInt(String s) {

        if (s == null || s.length() == 0) return -1;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length(), result = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--) {
            int x = map.get(s.charAt(i));
            int y = map.get(s.charAt(i + 1));
            if (x >= y)
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));
        }
        return result;
    }

  /*  String[] split = s.split("");
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (String str : split) {
            switch (str) {
                case "I" : num = "1"; break;
                case "V" : num = "5"; break;
                case "X" : num = "10"; break;
                case "L" : num = "50"; break;
                case "C" : num = "100"; break;
                case "D" : num = "500"; break;
                case "M" : num = "1000"; break;
            }
            sb.append("," + num );
        }
        String substring = sb.substring(1, sb.length());
        String[] last = substring.split(",");
        int count = 0;
        for (int i =1; i<last.length ; i++){
            int x = Integer.parseInt(last[i-1]);
            int y = Integer.parseInt(last[i]);
            if (x >= y) {
                count += x;
            } else if (x < y) {
                count += y - x;
                i++;
                int countOld= i + 1;
                if (countOld == last.length) {
                    count += Integer.parseInt(last[countOld-1]);
                }
            }
        }

        return  count;
    }*/

    // 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 121：true -121：false
    public static boolean isPalindrome(int x) {
        int rev = 0;
        int first = x;
        while (x != 0) {
            int pop = x % 10;
            if (pop < 0) { // 负数不可能是回文数
                return false;
            }
            x /= 10;
            rev = rev * 10 + pop;
        }
        return rev == first;
    }

    // 整数的反转
    public static int intReverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10; // 取到最后一位
            x /= 10; // 用来判断是否已经是最后一位了
            rev = rev * 10 + pop; // 每次乘以10 加最后一位（这是重点思路）
        }
        return rev;
    }
}