package Resources;

import java.util.ArrayList;
import java.util.List;

import POJO.addPlace;
import POJO.location;

public class testDataBuild {
	
	public addPlace payload(String name, String language, String address) {
		addPlace p = new addPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 435 546 3463");
		
		p.setWebsite("https://rahulshettyacademy.com");
		
		p.setName(name);
		List<String> mylist = new ArrayList<String>();
		mylist.add("Shoe Park");
		mylist.add("shop");
		
		p.setTypes(mylist);
		
		location l = new location();
		l.setLat(-38.6594);
		l.setLng(33.2587);
		p.setLocation(l);
		return p ;
	}
	
	public String deleteplacepayload(String placeId) {
		
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
		
		
	}

}
