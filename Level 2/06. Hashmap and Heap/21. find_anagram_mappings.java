import java.util.*;

public class Main {
	public static int[] anagramMappings(int[] A, int[] B) {
		HashMap<Integer,ArrayDeque<Integer>>map = new HashMap<>();
		
		//fill this map using B
		for(int i=0; i < B.length;i++) {
		    ArrayDeque<Integer>q = map.getOrDefault(B[i],new ArrayDeque<>());
		    q.add(i);
		    map.put(B[i],q);
		}
		
		int[]ans = new int[A.length];
		
		for(int i=0; i < A.length;i++) {
		    int pos = map.get(A[i]).remove();
		    ans[i] = pos;
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int j = 0; j < b.length; j++) {
			b[j] = s.nextInt();
		}
		int[] res = anagramMappings(a, b);
		for (int j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
	}

}
