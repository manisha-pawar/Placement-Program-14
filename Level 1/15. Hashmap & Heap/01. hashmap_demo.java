import java.util.*;

public class Main {
    public static void main(String[]args) {
        HashMap<String,Integer>map = new HashMap<>();
        
        map.put("India",300);
        map.put("Pak",250);
        map.put("Eng",480);
        
        
        //put
        map.put("Nigeria",290); //key absent - addition
        map.put("Pak",200); //key present - updation
        System.out.println(map);
        
        
        //get
        System.out.println(map.get("India")); //key present - value
        System.out.println(map.get("Africa")); //key absent - null
        
        //containsKey
        System.out.println(map.containsKey("India")); //key present - true
        System.out.println(map.containsKey("Africa")); //key absent - false
        
        
        //remove
        //map.remove("India"); //key present - deletion of pair
        map.remove("Africa"); //key absent - do nothing
        System.out.println(map);
        
        
        //keyset
        for(String key : map.keySet()) {
            System.out.println(key + " ---> " + map.get(key));
        }
    }
}