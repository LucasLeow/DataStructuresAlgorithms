public class ReverseString {

    public static String reverseString(String s) {
        String rString = "";
        Stack<Character> charStack = new Stack<>();

        char[] cArray = s.toCharArray();
        for (char c: cArray) {
            charStack.push(new Character(c));
        }

        while (!charStack.isEmpty()) {
            rString += charStack.pop();
        }

        return rString;
    }

    public static void main(String[] args) {

        String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);

        /*
            EXPECTED OUTPUT:
            ----------------
            olleh
        */

    }

}
