package reactive_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages={
				"reactive_data",
		}
		)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
