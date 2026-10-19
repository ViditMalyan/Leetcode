class Solution {
    public String formula;
    public int index;

    public String countOfAtoms(String formula) {
        this.formula = formula;
        this.index = 0;

        Map<String, Integer> atoms = parseGroup();
        TreeMap<String, Integer> sorted = new TreeMap<>(atoms);

        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            result.append(entry.getKey());

            if (entry.getValue() > 1) {
                result.append(entry.getValue());
            }
        }

        return result.toString();
    }

    public Map<String, Integer> parseGroup() {
        Map<String, Integer> counts = new HashMap<>();

        while (index < formula.length()
                && formula.charAt(index) != ')') {

            if (formula.charAt(index) == '(') {
                index++; // Skip '('

                Map<String, Integer> inner = parseGroup();

                index++; // Skip ')'

                int multiplier = readNumber();

                for (Map.Entry<String, Integer> entry : inner.entrySet()) {
                    String atom = entry.getKey();
                    int count = entry.getValue() * multiplier;

                    counts.put(atom, counts.getOrDefault(atom, 0) + count);
                }
            } else {
                String atom = readAtom();
                int count = readNumber();
                counts.put(atom, counts.getOrDefault(atom, 0) + count);
            }
        }

        return counts;
    }

    public String readAtom() {
        int start = index;
        index++; // Uppercase first letter

        while (index < formula.length() && Character.isLowerCase(formula.charAt(index))) {
            index++;
        }

        return formula.substring(start, index);
    }

    public int readNumber() {
        int number = 0;

        while (index < formula.length()
                && Character.isDigit(formula.charAt(index))) {
            number = number * 10 + (formula.charAt(index) - '0');
            index++;
        }

        return number == 0 ? 1 : number;
    }
}