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

    // Next Greater Element to the Right
    public static int[] nge(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (st.size() > 0 && arr[st.peek()] < arr[i]) {
                ans[st.pop()] = arr[i];
            }
            st.push(i);
        }

        while (st.size() > 0) {
            ans[st.pop()] = -1;
        }

        return ans;
    }

    public static int[] nge1(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }

    // Stock Span
    public static int[] stockSpan(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] < arr[i]) {
                ans[st.pop()] = i;
            }
            st.push(i);
        }

        while (st.size() > 0) {
            ans[st.pop()] = -1;
        }

        for (int i = 0; i < n; i++) {
            ans[i] = i - ans[i];
        }
        return ans;
    }

    // Largest Area Histogram
    public static int largestAreaHistogram(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nsl = new int[n];
        int[] nsr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            while (st.size() > 0 && arr[st.peek()] > arr[i]) {
                nsr[st.pop()] = i;
            }
            st.push(i);
        }

        while (st.size() > 0) {
            nsr[st.pop()] = n;
        }

        st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] > arr[i]) {
                nsl[st.pop()] = i;
            }
            st.push(i);
        }

        while (st.size() > 0) {
            nsl[st.pop()] = -1;
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int ht = arr[i];
            int width = nsr[i] - nsl[i] - 1;

            maxArea = Math.max(maxArea, ht * width);
        }

        return maxArea;
    }

    public static void main(String[] args) {

    }
}
