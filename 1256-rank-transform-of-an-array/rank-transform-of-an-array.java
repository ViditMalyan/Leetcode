class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int[] sorted = arr.clone();

        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;

        for (int num : sorted) {

            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            answer[i] = map.get(arr[i]);
        }

        return answer;
    }
}