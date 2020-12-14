package reactive_data.model;

import java.time.LocalDate;
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
public class Book {
	
	@Id
	private UUID id;

	private String title;
	
	private Author author;
	
	private LocalDate dateOfParution;
}
