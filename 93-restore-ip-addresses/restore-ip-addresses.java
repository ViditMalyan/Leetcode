class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        backtrack(s, 0, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(String s,
            int index,
            int parts,
            List<String> path,
            List<String> result) {

        if (parts == 4) {
            if (index == s.length()) {
                result.add(String.join(".", path));
            }

            return;
        }

        int remainingDigits = s.length() - index;
        int remainingParts = 4 - parts;

        if (remainingDigits < remainingParts || remainingDigits > remainingParts * 3) {
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length())
                break;

            String part = s.substring(index, index + len);

            if (isValid(part)) {
                path.add(part);

                backtrack(s, index + len, parts + 1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isValid(String part) {

        if (part.length() > 1 && part.charAt(0) == '0')
            return false;

        int value = Integer.parseInt(part);
        return value <= 255;
    }
}