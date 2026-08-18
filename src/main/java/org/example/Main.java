package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //hellohi

//        Map<Thread, StackTraceElement[]> threads = Thread.getAllStackTraces();
//
//        for (Thread thread : threads.keySet()) {
//
//            System.out.println("-----------------------------");
//            System.out.println("Thread Name : " + thread.getName());
//            System.out.println("Thread ID   : " + thread.getId());
//            System.out.println("State       : " + thread.getState());
//            System.out.println("Priority    : " + thread.getPriority());
//            System.out.println("Daemon      : " + thread.isDaemon());
//
//            System.out.println("Stack Trace:");
//
//            for (StackTraceElement element : threads.get(thread)) {
//                System.out.println("\t" + element);
//            }
//        }
        int arr[]={1,1,2,3,3,4,5,5};
//
//        for(int i=1;i<arr.length;i++){
//            if(arr[i]==arr[i-1]){
////                System.out.print(arr[i]+" ");
//            }
////        }
        Arrays.stream(arr)
                ;
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Alice", "IT", 75000));
        employees.add(new Employee(102, "Bob", "HR", 55000));
        employees.add(new Employee(103, "Charlie", "Finance", 68000));
        employees.add(new Employee(104, "David", "IT", 82000));
        employees.add(new Employee(105, "Eva", "Sales", 60000));
        employees.add(new Employee(106, "Frank", "HR", 58000));
        employees.add(new Employee(107, "Grace", "Finance", 91000));
        employees.add(new Employee(108, "Henry", "Sales", 64000));
        employees.add(new Employee(109, "Isabella", "Marketing", 72000));
        employees.add(new Employee(110, "Jack", "IT", 88000));

       //Program to find second-highest salary Employee
        Employee employee = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)
                        .reversed()).
                skip(1)
                .findFirst()
                .get();
        System.out.println(employee);

        String name="helloindia";
        int ar[]={1,2,3,2,2,3,5,6};
        HashSet<Integer> hashSet=new HashSet<>();

        //program to Print all the duplicate elements in an array
        Arrays.stream(ar)
                .filter(value->!hashSet.add(value))
                .forEach(System.out::println);

        //Program to find frequency of each character using streams
        Map<Character, Long> collect = name.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
        System.out.println(collect);

     //Program to display department along with their average salary
        Map<String, Long> departmentWiseAverageSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        System.out.println(departmentWiseAverageSalary);

        //Program to find Maximum salaried employee
        Set<Double> collect1 = employees.stream()
                .map(Employee::getSalary)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toSet());

         //Department Wise Highest salaried employee
        Map<String, Optional<Employee>> departmentWiseHighestSalariedEmployees = employees.stream()
                .distinct()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.print(departmentWiseHighestSalariedEmployees
        +"  ");
    }
}

