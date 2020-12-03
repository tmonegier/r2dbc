package reactive_data.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactive_data.model.Author;
import reactive_data.repositories.AuthorRepository;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
	
	private final AuthorRepository authorRepository;
	
	@GetMapping
	public Flux<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

}
