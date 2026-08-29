class Solution {
    public int countAsterisks(String s) {
         boolean inside = false;
        int count = 0;

        for (char ch : s.toCharArray()){
            if (ch == '|') {
                inside = !inside;
            } 
            else if (ch == '*' && !inside){
                count++;
            }
        }
        return count;
    }
}