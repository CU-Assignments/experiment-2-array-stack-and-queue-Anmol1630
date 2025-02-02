package exp2;
import java.util.*;
public class SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); 
                }
            } else if (!part.equals("") && !part.equals(".")) {
                stack.push(part); 
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        return result.length() == 0 ? "/" : result.toString();
    }
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter absolute Unix path: ");
        String path = scanner.nextLine();

        String result = simplifyPath(path);
        System.out.println("Simplified Path:" + result);

        scanner.close();
    }
}
