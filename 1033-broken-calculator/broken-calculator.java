class Solution {
    public int brokenCalc(int startValue, int target) {
        int operations = 0;

        while (target > startValue) {
            if (target % 2 == 1) {
                //Reverse of subtracting 1
                target++;
            } else {
                //Reverse of multiplying by 2
                target /= 2;
            }
            operations++;
        }
        //Remaining operations are all -1
        operations += startValue - target;

        return operations;
    }
}