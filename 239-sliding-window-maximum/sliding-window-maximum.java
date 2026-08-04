class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque <Integer> deque = new LinkedList<>();
        int index = 0;

        for(int i = 0; i < n; i++){
            //Removing indices outside the window

            while(!deque.isEmpty() && deque.peekFirst() <= i - k){
                deque.pollFirst();
            }

            //Remove smaller elements
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }

            //Adding current index
            deque.offerLast(i);

            //Window
            if(i >= k - 1){
                ans[index++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}