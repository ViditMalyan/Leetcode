class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inBlock = false;

        for (String line : source) {
            int i = 0;

            while (i < line.length()) {
                if (inBlock) {
                    int end = line.indexOf("*/", i);

                    if (end == -1) {
                        // Block comment continues to the next line
                        break;
                    }
                    inBlock = false;
                    i = end + 2;
                } else {
                    int blockStart = line.indexOf("/*", i);
                    int lineStart = line.indexOf("//", i);

                    // No comment starts here or later
                    if (blockStart == -1 && lineStart == -1) {
                        current.append(line.substring(i));
                        break;
                    }

                    // Line comment comes first
                    if (lineStart != -1 && (blockStart == -1 || lineStart < blockStart)) {
                        current.append(line.substring(i, lineStart));
                        break;
                    }

                    // Block comment comes first
                    current.append(line.substring(i, blockStart));
                    inBlock = true;
                    i = blockStart + 2;
                }
            }

            if (!inBlock && current.length() > 0) {
                result.add(current.toString());
                current.setLength(0);
            }
        }
        return result;
    }
}