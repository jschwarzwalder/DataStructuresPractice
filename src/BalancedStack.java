import java.util.Stack;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedStack {
    public static char[][] Tokens = {{'{', '}'}, {'[', ']'}, {'(', ')'}};

    public static boolean isOpenTerm(char c) {
        for (char[] array : Tokens) {
            if (array[0] == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean matches(char openTerm, char closeTerm) {
        for (char[] array : Tokens) {
            if (array[0] == openTerm) {
                if (array[1] == closeTerm) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : expression.toCharArray()) {
            if (isOpenTerm(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!matches(top, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ArrayList<String> Tests = new ArrayList<String>();
        for (String string : args) {
            Tests.add(string);
        }
        Tests.add("{}[]()");
        Tests.add("{[()]}");
        Tests.add("");
        Tests.add("{[(}])");
        Tests.add("}])");
        Tests.add("(x, y)");

        for (String test : Tests) {
            System.out.print(test + ": ");
            System.out.print(isBalanced(test));
            System.out.print("\n");
        }
    }
}
