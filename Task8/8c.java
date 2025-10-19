import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build multi-digit number
                k = k * 10 + (ch - '0');
            } 
            else if (ch == '[') {
                // Push current number and string to stacks
                countStack.push(k);
                stringStack.push(currentString);
                // Reset for new segment
                k = 0;
                currentString = "";
            } 
            else if (ch == ']') {
                // Pop and build repeated substring
                int repeatTimes = countStack.pop();
                StringBuilder decoded = new StringBuilder(stringStack.pop());
                for (int i = 0; i < repeatTimes; i++) {
                    decoded.append(currentString);
                }
                currentString = decoded.toString();
            } 
            else {
                // Normal character
                currentString += ch;
            }
        }
        return currentString;
    }

    // Test the code
    public static void main(String[] args) {
        DecodeString decoder = new DecodeString();

        System.out.println(decoder.decodeString("3[a]2[bc]"));         // aaabcbc
        System.out.println(decoder.decodeString("3[a2[c]]"));         // accaccacc
        System.out.println(decoder.decodeString("2[abc]3[cd]ef"));    // abcabccdcdcdef
        System.out.println(decoder.decodeString("10[a]"));            // aaaaaaaaaa
    }
}
