package reactive_data.repositories;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import reactive_data.model.Author;

@Repository
public interface AuthorRepository extends R2dbcRepository<Author, UUID> {
	

}
