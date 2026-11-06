class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        backtrack( num, target, 0, 0, 0, new StringBuilder(), result );

        return result;
    }

    public void backtrack( String num, int target, int pos, long eval, long prev, StringBuilder path, List<String> result ) {

        // All digits have been used
        if (pos == num.length()) {

            if (eval == target) {
                result.add(path.toString());
            }

            return;
        }

        // Save the original expression length
        int originalLength = path.length();

        // Try different operand lengths
        for (int i = pos; i < num.length(); i++) {

            // Avoid leading zeros
            if (i > pos && num.charAt(pos) == '0') {
                break;
            }

            // Extract the current number
            long current = Long.parseLong(
                num.substring(pos, i + 1)
            );

            String operand = num.substring(pos, i + 1);

            // First operand: no operator needed
            if (pos == 0) {

                path.append(operand);

                backtrack( num, target, i + 1, current, current, path, result );

                path.setLength(originalLength);

            } else {

                // Try addition
                path.append("+").append(operand);

                backtrack( num, target, i + 1, eval + current, current, path, result );

                path.setLength(originalLength);

                // Try subtraction
                path.append("-").append(operand);

                backtrack( num, target, i + 1, eval - current, -current, path, result );

                path.setLength(originalLength);

                // Try multiplication
                path.append("*").append(operand);

                backtrack( num, target, i + 1, eval - prev + (prev * current), prev * current, path, result );

                path.setLength(originalLength);
            }
        }
    }
}