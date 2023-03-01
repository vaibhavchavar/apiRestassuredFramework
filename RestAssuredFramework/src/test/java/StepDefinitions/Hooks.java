package StepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;



public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		//write a code that will give you a place id 
		//execute this code when this placeid is null
		
		stepDefinition m = new stepDefinition();
		if(m.place_id == null) {
		m.payload("vaibhav", "english", "pune");
		m.method("addPlaceAPI", "Post");
		m.verify_Place_Id("vaibhav", "getPlaceAPI");
		}
	}

	
}
