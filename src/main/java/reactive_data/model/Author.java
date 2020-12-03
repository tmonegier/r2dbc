package reactive_data.model;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {
	
	@Id
	private UUID id;
	private String name;
	
	List<Book> books;

}
