package reactive_data.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.r2dbc.core.Parameter;

import reactive_data.model.Person;


@WritingConverter
public class PersonWriteConverter implements Converter<Person, OutboundRow> {

	@Override
	public OutboundRow convert(Person person) {
		OutboundRow row = new OutboundRow();
		if(person.getId() != null) {
			row.put("id", Parameter.from(person.getId()));
		}
		row.put("city", Parameter.from(person.getAddress().getCity()));
		row.put("zip_code", Parameter.from(person.getAddress().getZipCode()));
		row.put("street", Parameter.from(person.getAddress().getStreet()));
		row.put("name", Parameter.from(person.getName()));
		return row;
	}

}
