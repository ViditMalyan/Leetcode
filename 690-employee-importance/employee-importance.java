/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {

        // ID -> Employee
        Map<Integer, Employee> map = new HashMap<>();

        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(map, id);
    }

    public int dfs(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        int total = employee.importance;

        for (int subordinateId : employee.subordinates) {
            total += dfs(map, subordinateId);
        }
        return total;
    }
}