import java.util.*;
public class DictionarayTest {
	public static void main(String[] args) {
		Map<String, Integer> address = new HashMap<>();
		if(address.isEmpty()) System.out.println("No number in my emergency phone address book");
		else System.out.println("I have "+address.size()+" numbers");				
		address.put("Korea", 119);
		address.put("SC", 116);
		address.put("EU", 112);
		address.put("USA", 911);
		address.put("Australia", 000);		
		address.put("London", 999);
		address.put("France", 17);
		if(address.isEmpty()) System.out.println("No number in my emergency phone address book");
		else System.out.println("I have "+address.size()+" numbers");		
		if(address.containsKey("USA")) System.out.println("The emergency phone number in USA is "+ address.get("USA"));
		else System.out.println("We cannot find emergency phone number in U.S.");
		if(address.containsKey("Japan")) System.out.println(address.get("Japan"));
		else System.out.println("We cannot find emergency phone number in Japan");	
		System.out.println("Emergency phone number book: "+ address);		 
		System.out.println("Removing USA: "+ address.remove("USA"));
		System.out.println("Removing SC: "+ address.remove("SC"));
		System.out.println("Removing Korea: "+ address.remove("Korea"));
		System.out.println("Emergency phone number book: "+ address);
		System.out.println("Using iterator");
		Iterator<String> keys = address.keySet().iterator();		
		while(keys.hasNext()) {
			String key = keys.next();
			System.out.println(key+": "+address.get(key));
		}
		System.out.println("Using lambda expression");
		address.forEach((key, value)->{System.out.println(key+": "+value);});
 	}
}
