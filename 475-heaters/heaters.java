class Solution {
    public int findRadius(int[] houses, int[] heaters) {
      Arrays.sort(heaters);

        int radius = 0;

        for (int house : houses) {

            int index = Arrays.binarySearch(heaters, house);

            if (index < 0) {
                index = -(index + 1); // insertion position
            }

            int leftDistance = Integer.MAX_VALUE;
            int rightDistance = Integer.MAX_VALUE;

            if (index - 1 >= 0) {
                leftDistance = house - heaters[index - 1];
            }

            if (index < heaters.length) {
                rightDistance = heaters[index] - house;
            }

            int nearest = Math.min(leftDistance, rightDistance);

            radius = Math.max(radius, nearest);
        }

        return radius;  
    }
}