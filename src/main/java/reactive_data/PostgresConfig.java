package reactive_data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;

@Configuration
@EnableR2dbcRepositories(basePackages = {
		"reactive_data.repositories"
})
public class PostgresConfig extends AbstractR2dbcConfiguration {

	@Override
	@Bean
	public ConnectionFactory connectionFactory() {
		return new PostgresqlConnectionFactory(
				PostgresqlConnectionConfiguration.builder()
				.host("localhost")
				.port(5433)
				.username("postgres")
				.password("admin")
				.database("mydb")
				.build());
	}


	@Bean
	public DatabaseClient databaseClientTest(ConnectionFactory connectionFactory) {
		return DatabaseClient.builder()
				.connectionFactory(connectionFactory)
				.namedParameters(true)
				.build();
	}
}