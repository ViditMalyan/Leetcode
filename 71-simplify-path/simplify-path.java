class Solution {
    public String simplifyPath(String path) {
        
        Deque<String> stack = new ArrayDeque<>();

        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder answer = new StringBuilder();

        while (!stack.isEmpty()) {
            answer.insert(0, "/" + stack.pop());
        }

        return answer.toString();
    }
}