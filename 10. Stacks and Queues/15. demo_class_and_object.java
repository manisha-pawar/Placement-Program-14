import java.util.*;

public class Main {
    
    public static class Student {
        //data members
        int sn;
        String name;
        
        //member function
        void print_details() {
            System.out.println(sn + " " + name);
        }
        
        void update_name(String new_name) {
            name = new_name;
        }
        
        //constructor
        
        //1. default constructor
        Student() {
            
        }
        
        //2. paremetirised constructor
        Student(int sn,String name) {
            this.sn = sn;
            this.name = name;
        }
        
    }
    
    public static void main(String[]args) {
        Student s1 = new Student(1,"abc"); 
        
        Student s2 =  new Student();
        
        s2.sn = 2;
        s2.name = "xyz";
        
        s1.print_details();
        s2.print_details();
        
    }
}