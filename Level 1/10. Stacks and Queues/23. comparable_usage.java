import java.util.*;

public class Main {
    
    public static class Student implements Comparable <Student>{
        int marks;
        String name;
        
        Student() {
            
        }
        
        Student(int marks,String name) {
            this.marks = marks;
            this.name = name;
        }
        
        //+ve -> this > other
        //-ve -> this < other
        //0 -> this == other

        public int compareTo(Student o) {
            if(this.marks < o.marks) {
                return -1;
            }
            else if(this.marks > o.marks) {
                return 1;
            }
            else {
               return this.name.compareTo(o.name);
            }
        }
    }
    
    public static void main(String[]args) {
        Student[]arr = new Student[5];
        
        arr[0] = new Student(15,"dab");
        arr[1] = new Student(20,"bae");
        arr[2] = new Student(15,"abc");
        arr[3] = new Student(25,"efg");
        arr[4] = new Student(15,"xyz");
        
        Arrays.sort(arr);  //sort on the basis of marks(ascending order), if two students have same marks sort them on the basis of name(lexico order)
        
        for(int i=0; i < arr.length;i++) {
            System.out.println(arr[i].marks + " " + arr[i].name);
        }
        
    }
}