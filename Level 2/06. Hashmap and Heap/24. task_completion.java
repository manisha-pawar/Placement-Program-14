import java.util.*;

public class Main {
	
    public static void completeTask(int n, int m, int[] arr) {
		HashSet<Integer>hs = new HashSet<>();
		
		for(int val : arr) {
		    hs.add(val);
		}
		
		ArrayList<Integer>l1 = new ArrayList<>(); //for student1
		ArrayList<Integer>l2 = new ArrayList<>(); //for student2
		boolean flag = true; //flag == true (allocate to s1) else allocate to s2
		
		for(int i=1; i <= n;i++) {
		    if(hs.contains(i) == false) {
		        //ith task is not done
		        if(flag == true) {
		            l1.add(i);
		            flag = false;
		        }
		        else {
		            l2.add(i);
		            flag = true;
		        }
		    }
		}
		
		for(int val : l1) {
		    System.out.print(val + " ");
		}
		System.out.println();
		for(int val : l2) {
		    System.out.print(val + " ");
		}
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] num = new int[m];
		for (int i = 0; i < m; i++) {
			num[i] = scn.nextInt();
		}
		completeTask(n, m, num);
	}

}
