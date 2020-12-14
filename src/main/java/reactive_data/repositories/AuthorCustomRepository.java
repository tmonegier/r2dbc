package reactive_data.repositories;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import reactive_data.model.Author;
import reactive_data.model.Author.AuthorBuilder;
import reactive_data.model.Book;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class AuthorCustomRepository {

	private final DatabaseClient databaseClient;

	public Flux<Author> findAll() {
		return databaseClient.sql(
				"SELECT  "
						+ "	book.id as bookId, book.title as bookName, book.date_of_parution as dateOfParution, "
						+ " author.id as authorId, author.name as authorName "
						+ "FROM author "
						+ "JOIN book on author.id = book.author "
						+ "ORDER BY authorId")
				.fetch()
				.all()
				.bufferUntilChanged( result -> result.get("authorId"))
				.map(list -> {
					AuthorBuilder author = Author.builder();
					author.name(String.valueOf(list.get(0).get("authorName")));
					author.id((UUID) list.get(0).get("authorId"));
					
					author.books(
							list.stream()
							.map(map -> {
								return Book.builder()
										.title((String) map.get("bookName"))
										.id((UUID) map.get( "bookId"))
										.dateOfParution((LocalDate) map.get("dateOfParution"))
										.build();
							}).collect(Collectors.toList())
							);
					return author.build();
				});
	}

}
