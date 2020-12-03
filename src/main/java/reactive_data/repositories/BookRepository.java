package reactive_data.repositories;

import java.util.UUID;

import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import reactive_data.model.Author;
import reactive_data.model.Book;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class BookRepository {

	private final DatabaseClient databaseClient;


	public Flux<Book> findAll() {
		return databaseClient.sql(
				"SELECT  "
						+ "	book.id as bookId, book.name as bookName,"
						+ " author.id as authorId, author.name as authorName "
						+ "FROM book "
						+ "JOIN author on author.id = book.author")
				.map( (row, metadata) -> {
					Author author = Author.builder()
							.id(row.get("authorId", UUID.class))
							.name(row.get("authorName", String.class))
							.build();
					return Book.builder()
							.name(row.get("bookName", String.class))
							.id(row.get("bookId", UUID.class))
							.author(author)
							.build();
				} ).all();
	}

}
