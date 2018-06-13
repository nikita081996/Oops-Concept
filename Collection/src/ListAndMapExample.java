import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class ListAndMapExample {
	public static void main(String[] args) {
		
		List<String> listOfDepartment = new ArrayList<String>();
		listOfDepartment.add("Android");
		listOfDepartment.add(".Net");
		listOfDepartment.add("Python");
		listOfDepartment.add("ROR");
		listOfDepartment.add("Angular");
		listOfDepartment.add("IOS");
		
		HashMap<Integer,String> muserInfo = new HashMap<Integer,String>();
		muserInfo.put(1, "Nikita");
		muserInfo.put(2, "Amit");
		muserInfo.put(3, "Adarsh");
		muserInfo.put(4, "Vaishali");

		System.out.println("List of Department are ");
		for(String list:listOfDepartment) {
			System.out.println(list);
		}
		
		System.out.println("\nMap with key and value are ");
		for(Entry<Integer, String> m:muserInfo.entrySet()){  
			   System.out.println("User Id is "+m.getKey()+" and Username is "+m.getValue());  
			  }  
	}
}
