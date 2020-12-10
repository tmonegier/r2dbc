package reactive_data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import reactive_data.converters.PersonReadConverter;

@Configuration
@EnableR2dbcRepositories
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


	@Override
	protected List<Object> getCustomConverters() {
		List<Object> converterList = new ArrayList<>();
		converterList.add(new PersonReadConverter());
		return converterList;
	}
}