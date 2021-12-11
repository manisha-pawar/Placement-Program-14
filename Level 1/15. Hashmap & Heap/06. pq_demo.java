import java.util.*;

public class Main {
    public static class Student implements Comparable<Student>{
        String name;
        int marks;
        
        Student() {
            
        }
        
        Student(String name,int marks) {
            this.name = name;
            this.marks = marks;
        }
        
        //this < o -> -ve
        //this > o -> +ve
        //this == o -> 0
        
        public int compareTo(Student o) {
            if(this.marks != o.marks) {
                return this.marks - o.marks;
            }
            else {
                return this.name.compareTo(o.name);
            }
        }
    }
    
    public static void main(String[]args) {
        // PriorityQueue<String>pq = new PriorityQueue<>(); //smaller value has higher priority
        // //PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder()); //larger value has higher priority
        
        // pq.add("abc");
        // pq.add("mno");
        // pq.add("qrs");
        // pq.add("abd");
        // pq.add("mnk");
        
        // while(pq.size() > 0) {
        //     String ele = pq.peek();
        //     pq.remove();
        //     System.out.println(ele);
        // }
        
        
        PriorityQueue<Student>pq = new PriorityQueue<>(); //smaller value has higher priority
        
        pq.add(new Student("kfc",35));
        pq.add(new Student("bks",40));
        pq.add(new Student("amn",10));
        pq.add(new Student("afk",35));
        pq.add(new Student("sme",40));
       
        
        
        while(pq.size() > 0) {
            Student st = pq.peek();
            pq.remove();
            System.out.println(st.marks + " " + st.name);
        }
    }
}