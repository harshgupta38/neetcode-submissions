class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String token:tokens){
            char ch=token.charAt(0);
            if(token.length()==1 && (ch=='+' || ch=='-' || ch=='*' || ch=='/')){
                int num2=stack.pop();
                int num1=stack.pop();
                switch(ch){
                    case '+': stack.push(num1+num2); break;
                    case '-': stack.push(num1-num2); break;
                    case '*': stack.push(num1*num2); break;
                    case '/': stack.push(num1/num2); break;
                }
            } else stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
}
