package reactive_data.repositories;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import reactive_data.model.Book;

@Repository
public interface BookRepository extends R2dbcRepository<Book, UUID> {

}
