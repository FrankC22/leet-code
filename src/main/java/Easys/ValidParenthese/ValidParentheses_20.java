package Easys.ValidParenthese;

import java.util.Stack;

public class ValidParentheses_20 {

    public static void main(String[] args) {

        String case1 = "()"; //True
        String case2 = "()[]{}"; //True
        String case3 = "(]"; // False
        String case4 = "(()(){{}}[()(())])"; // True
        String case5 = "["; //False

        System.out.println("Case1: " + isValid(case1));
        System.out.println("Case2: " + isValid(case2));
        System.out.println("Case3: " + isValid(case3));
        System.out.println("Case4: " + isValid(case4));
        System.out.println("Case5: " + isValid(case5));

    }


    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(char curr : s.toCharArray()) {

            if(curr == ('(') || curr == ('{') || curr == ('[')) {
                stack.push(curr);

            } else {

                if(stack.isEmpty())
                    return false;

                char pop = stack.pop();

                if((curr == (')') && pop != ('(')) ||
                   (curr == ('}') && pop != ('{')) ||
                   (curr == (']') && pop != ('['))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
