package Assignment8;

import java.util.HashMap;

public class EmployeeMap {
    
    private HashMap<String, Employee> employeeMap = new HashMap<>();

    public void addEmployee(String id, Employee employee){
        employeeMap.put(id, employee);
    }

    public Employee getEmployee(String id){
        return employeeMap.get(id);
    }


    //demo
    public static void main(String[] args){


        Employee employee1 = new Employee("2021", "John");
        Employee employee2 = new Employee("2022", "Tresor");
        Employee employee3 = new Employee("2023", "Josh");
        Employee employee4 = new Employee("2024", "Dav");
        Employee employee5 = new Employee("2025", "David");


        EmployeeMap map = new EmployeeMap();

        map.addEmployee(employee1.getIdNumber(), employee1);
        map.addEmployee(employee2.getIdNumber(), employee2);
        map.addEmployee(employee3.getIdNumber(), employee3);
        map.addEmployee(employee4.getIdNumber(), employee3);
        map.addEmployee(employee5.getIdNumber(), employee5);

        System.out.println(map.getEmployee("2021"));
        System.out.println(map.getEmployee("2022"));
        System.out.println(map.getEmployee("1234"));



    }
}
