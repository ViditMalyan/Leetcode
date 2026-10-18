class Solution {
    public Map<String, String> parent = new HashMap<>();
    public Map<String, Integer> rank = new HashMap<>();

    public String find(String email) {
        if (!parent.get(email).equals(email)) {
            parent.put(email, find(parent.get(email)));
        }

        return parent.get(email);
    }

    public void union(String email1, String email2) {
        String root1 = find(email1);
        String root2 = find(email2);

        if (root1.equals(root2)) {
            return;
        }

        int rank1 = rank.get(root1);
        int rank2 = rank.get(root2);

        if (rank1 < rank2) {
            parent.put(root1, root2);
        } else if (rank1 > rank2) {
            parent.put(root2, root1);
        } else {
            parent.put(root2, root1);
            rank.put(root1, rank1 + 1);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();

        // Initialize every unique email as its own group
        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);

                parent.putIfAbsent(email, email);
                rank.putIfAbsent(email, 0);
                emailToName.put(email, name);
            }
        }

        // Merge emails belonging to the same account
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);

            for (int i = 2; i < account.size(); i++) {
                union(firstEmail, account.get(i));
            }
        }

        // Collect emails by their final root
        Map<String, List<String>> groups = new HashMap<>();

        for (String email : parent.keySet()) {
            String root = find(email);
            groups.computeIfAbsent(root, key -> new ArrayList<>()).add(email);
        }

        // Sort emails and add the account name
        List<List<String>> result = new ArrayList<>();

        for (List<String> emails : groups.values()) {
            Collections.sort(emails);
            emails.add(0, emailToName.get(emails.get(0)));
            result.add(emails);
        }

        return result;
    }
}