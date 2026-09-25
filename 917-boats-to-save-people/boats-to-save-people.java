class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left < right) {
            // If the lightest and heaviest can share
            if (people[left] + people[right] <= limit) {
                left++;
            }
            // Heaviest person is now placed
            right--;
            boats++;
        }

        // One person left
        if (left == right) {
            boats++;
        }
        return boats;
    }
}