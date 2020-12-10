package reactive_data.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	
	UUID id;

	String name;

	Address address;

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Address {
		
		String street;

		String zipCode;

		String city;
	}

}
