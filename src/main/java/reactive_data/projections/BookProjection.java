package reactive_data.projections;

import java.util.UUID;

public interface BookProjection {
	
	UUID getId();
	
	String getName();
	
	String getAuthorId();
	
	String getAuthorName();

}
