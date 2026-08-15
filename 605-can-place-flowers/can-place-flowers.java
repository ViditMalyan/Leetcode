class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        for (int i = 0; i < flowerbed.length; i++) {

            // Already occupied
            if (flowerbed[i] == 1) {
                continue;
            }

            // Check left neighbor
            boolean leftEmpty =
                (i == 0 || flowerbed[i - 1] == 0);

            // Check right neighbor
            boolean rightEmpty =
                (i == flowerbed.length - 1
                 || flowerbed[i + 1] == 0);

            // Safe to plant
            if (leftEmpty && rightEmpty) {

                flowerbed[i] = 1;
                n--;

                if (n == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}