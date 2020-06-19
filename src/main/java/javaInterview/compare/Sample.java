package javaInterview.compare;

import com.trees.BinarySearchTree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sample implements Comparable<Sample>{

    private int i;
    private String s;

    public Sample(final int i, final String s) {
        this.i = i;
        this.s = s;
    }

    @Override
    public int compareTo(final Sample o) {
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
        Sample s1 = new Sample(1, "a");
        Sample s2 = new Sample(2, "b");
        Sample s3 = new Sample(1, "b");

        List<Sample> arrList = new ArrayList<>();
        arrList.add(s1);
        arrList.add(s2);
        arrList.add(s3);

        Collections.sort(arrList);
        System.out.println(arrList);
    }
}
