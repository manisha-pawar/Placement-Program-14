import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        //write your code here

        HashMap < String, String > empMan = new HashMap < > (); //emp -> man

        while (n-- > 0) {
            String emp = scn.next();
            String man = scn.next();

            empMan.put(emp, man);
        }

        //convert into generic tree
        HashMap < String, ArrayList < String >> gt = new HashMap < > ();
        String ceo = "";

        for (String emp: empMan.keySet()) {
            String man = empMan.get(emp);

            if (emp.equals(man) == true) {
                ceo = emp;
                ArrayList < String > list = gt.getOrDefault(man, new ArrayList < > ());
                gt.put(emp, list);
                continue;
            }

            ArrayList < String > list = gt.getOrDefault(man, new ArrayList < > ());
            list.add(emp);
            gt.put(man, list);

            ArrayList < String > list1 = gt.getOrDefault(emp, new ArrayList < > ());
            gt.put(emp, list1);
        }



        HashMap < String, Integer > ans = new HashMap < > ();
        getSize(ceo, gt, ans);


        for (String emp: ans.keySet()) {
            System.out.println(emp + " " + ans.get(emp));
        }

    }


    public static int getSize(String node, HashMap < String, ArrayList < String >> gt, HashMap < String, Integer > ans) {
        int s = 0;

        for (String child: gt.get(node)) {
            s += getSize(child, gt, ans);
        }

        ans.put(node, s);
        return s + 1;

    }

}