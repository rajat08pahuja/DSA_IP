import java.util.*;

public class questions {

    // Duplicate Brackets
    public static boolean duplicateBrackets(String exp) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == ')') {
                if (st.peek() == '(') {
                    return true;
                } else {
                    while (st.size() > 0 && st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }

        return false;
    }

    // Balanced Brackets
    public static boolean balancedBrackets(String exp) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (ch == ')') {
                    if (st.size() > 0 && st.peek() == '(') {
                        st.pop();
                    } else {
                        return false;
                    }
                } else if (ch == '}') {
                    if (st.size() > 0 && st.peek() == '{') {
                        st.pop();
                    } else {
                        return false;
                    }
                } else {
                    if (st.size() > 0 && st.peek() == '[') {
                        st.pop();
                    } else {
                        return false;
                    }
                }
            } else {
                // do nothing
            }
        }
        
        if (st.size() > 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
