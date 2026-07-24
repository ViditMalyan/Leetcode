class Solution {
    public int titleToNumber(String columnTitle) {
        int answer = 0;

        for(char ch : columnTitle.toCharArray()){
            answer = answer * 26 + (ch - 'A' + 1); 
        }
        return answer;
    }
}