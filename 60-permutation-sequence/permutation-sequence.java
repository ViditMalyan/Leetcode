class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();

        int factorial = 1;

        // Storing numbers and computing(n - 1)!

        for(int i = 1; i < n; i++){
            factorial *= i;
            numbers.add(i);
        }

        numbers.add(n);
        k--; //Converting to 0 based index

        StringBuilder answer = new StringBuilder();

        while(true){
            
            int index = k/factorial;

            answer.append(numbers.get(index));

            numbers.remove(index);

            if(numbers.isEmpty())
            break;

            k %= factorial;

            factorial /= numbers.size();
        }

        return answer.toString();
    }
}