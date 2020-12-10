package reactive_data.repositories;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactive_data.model.Person;
import reactive_data.projections.PersonSummary;
import reactor.core.publisher.Flux;

public interface PersonRepository extends R2dbcRepository<Person, UUID> {

	@Query("Select * from Person")
	Flux<PersonSummary> findAllSummary();

}