package reactive_data.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactive_data.model.Person;
import reactive_data.projections.PersonSummary;
import reactive_data.repositories.PersonRepository;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {

	private final PersonRepository personRepository;

	@GetMapping
	public Flux<Person> findAll() {
		return personRepository.findAll();
	}
	
	@GetMapping("/summary")
	public Flux<PersonSummary> findAllSummary() {
		return personRepository.findAllSummary();
	}
}
