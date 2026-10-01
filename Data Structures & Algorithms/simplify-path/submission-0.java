class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] files = path.split("/");
        for (String p : files) {
            if (p.equals(".") || p.isEmpty() || (p.equals("..") && stack.isEmpty()))
                continue;
            if (p.equals(".."))
                stack.pop();
            else
                stack.push(p);
        }
        if (stack.isEmpty())
            return "/";

        StringBuilder sb = new StringBuilder();
        for (String p : stack) sb.append('/').append(p);
        return sb.toString();
    }
}