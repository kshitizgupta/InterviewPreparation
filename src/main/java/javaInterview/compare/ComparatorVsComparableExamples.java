package javaInterview.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorVsComparableExamples implements Comparable<ComparatorVsComparableExamples> {

    private int i;
    private String s;

    public ComparatorVsComparableExamples(final int i, final String s) {
        this.i = i;
        this.s = s;
    }

    @Override
    public int compareTo(final ComparatorVsComparableExamples o) {
        if (this.i < o.i) {
            return -1;
        } else if (this.i > o.i) return 1;
        else {
            return this.s.compareTo(o.s);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sample{");
        sb.append("i=").append(i);
        sb.append(", s='").append(s).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(10, "Kshitiz", 32, 200);
        Employee e2 = new Employee(2, "Rahul", 23, 100);
        Employee e3 = new Employee(31, "Rohit", 45, 2000);
        Employee e4 = new Employee(4, "Vikesh", 50, 50);

        List<Employee> arrList = new ArrayList<>();
        arrList.add(e1);
        arrList.add(e2);
        arrList.add(e3);
        arrList.add(e4);

        Collections.sort(arrList);
        System.out.println(arrList);

        Comparator<Employee> ageComparator = Comparator.comparingInt(Employee::getAge);
        Comparator<Employee> nameComparator = Comparator.comparing(Employee::getName);

        arrList.sort(ageComparator);
        System.out.println(arrList);

        arrList.sort(nameComparator);
        System.out.println(arrList);
    }
}
