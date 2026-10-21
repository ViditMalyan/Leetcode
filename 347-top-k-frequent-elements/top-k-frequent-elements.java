class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of every number
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets for frequencies 0 through nums.length
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        // Step 3: Put each number into its frequency bucket
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }

            buckets[count].add(num);
        }

        // Step 4: Collect the k most frequent numbers
        int[] result = new int[k];
        int index = 0;

        for (int count = buckets.length - 1;
             count >= 1 && index < k;
             count--) {
            if (buckets[count] != null) {
                for (int num : buckets[count]) {
                    result[index] = num;
                    index++;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}