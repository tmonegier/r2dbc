package reactive_data.projections;

import java.util.List;
import java.util.UUID;

public interface AuthorProjection {
	
	UUID getId();
	
	String getName();
	
	List<BookProjection> getBooks();
}
