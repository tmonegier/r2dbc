package reactive_data.converters;

import java.util.UUID;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import io.r2dbc.spi.Row;
import reactive_data.model.Person;
import reactive_data.model.Person.Address;

@ReadingConverter
public class PersonReadConverter implements Converter<Row, Person>{

	@Override
	public Person convert(Row source) {
		Address address = Address.builder()
				.city(source.get("city", String.class))
				.zipCode(source.get("zip_code", String.class))
				.street(source.get("street", String.class))
				.build();
		
		return Person.builder()
				.address(address)
				.name(source.get("name", String.class))
				.id(source.get("id", UUID.class))
				.build();
	}

}
