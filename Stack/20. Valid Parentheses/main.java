import java.util.Stack;

class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        long start = System.currentTimeMillis();
        pl(sol.isValid("()"));
        pl(sol.isValid("()[]{}"));
        pl(sol.isValid("(]"));
        pl("Time: " + (System.currentTimeMillis() - start));
    }

    public static void pl(Object o) {
        System.out.println(o.toString());
    }

    public static void pl(int[] nums) {
        String s = "{";
        for (int i = 0; i < nums.length - 1; i++) {
            s += nums[i] + ", ";
        }
        s += nums[nums.length - 1] + "}";
        Main.pl(s);
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char c;
        for (char i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (c) {
                case ('('):
                    stack.push(')');
                    break;
                case ('['):
                    stack.push(']');
                    break;
                case ('{'):
                    stack.push('}');
                    break;
                default:
                    if (stack.empty() || c != stack.pop())
                        return false;
            }
        }
        return stack.empty();
    }
}