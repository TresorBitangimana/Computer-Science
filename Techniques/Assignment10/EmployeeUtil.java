package Assignment10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeUtil {

    public static <T, K> Map<K, List<T>> groupListBy(List<T> items, Function<T, K> classifier) {
        return items.stream()
                .collect(Collectors.groupingBy(classifier));
    }

    // demo
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        Employee emp1 = new Employee("Alice Johnson", "IT", 60000);
        Employee emp2 = new Employee("Bob Smith", "IT", 75000);
        Employee emp3 = new Employee("Charlie Davis", "Finance", 70000);
        Employee emp4 = new Employee("Diana Lee", "Marketing", 65000);
        Employee emp5 = new Employee("Ethan Brown", "Finance", 62000);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);

        Function<Employee, String> grouping = s -> s.getDepartment();

        System.out.println(EmployeeUtil.groupListBy(employees, grouping));

    }

}
