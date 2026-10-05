class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        for(String email:emails){
            sb.setLength(0);
            for(char ch:email.toCharArray()){
                if(ch=='+') break;
                if(ch=='.') continue;
                sb.append(ch);
            }
            sb.append(email.substring(email.indexOf('@')));
            set.add(sb.toString());
        }
        // System.out.println(set.toString());
        return set.size();
    }
}