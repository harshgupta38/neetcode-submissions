class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set=new HashSet<>();
        int h=0, v=0;
        set.add("0 0");
        for(char ch:path.toCharArray()){
            switch(ch){
                case 'N': ++v; break;
                case 'E': ++h; break;
                case 'S': --v; break;
                case 'W': --h; break;
            }
            if(set.contains(h+" "+v))
                return true;
            set.add(h+" "+v);
        }
        return false;
    }
}