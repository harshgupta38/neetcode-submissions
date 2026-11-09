class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='[' || ch=='{'){
                switch(ch){
                    case '(': stack.push(')'); break;
                    case '[': stack.push(']'); break;
                    case '{': stack.push('}'); break;
                }
            } else if(stack.isEmpty() || ch!=stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
}
