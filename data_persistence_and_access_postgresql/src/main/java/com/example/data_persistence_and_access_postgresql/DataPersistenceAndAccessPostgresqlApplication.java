package com.example.data_persistence_and_access_postgresql;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.sql.DataSource;

import com.example.data_persistence_and_access_postgresql.exception.FilePathException;
import com.example.data_persistence_and_access_postgresql.exception.ReadAllLinesException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
public class DataPersistenceAndAccessPostgresqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataPersistenceAndAccessPostgresqlApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(DataSource dataSource) {
		return args -> {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			executeScript(jdbcTemplate, "create-database.sql");
			executeScript(jdbcTemplate, "create-tables.sql");
			executeScript(jdbcTemplate, "add-relationships.sql");
			executeScript(jdbcTemplate, "populate-data.sql");
		};
	}
	// 1. The executeScript() method takes a JdbcTemplate instance and a scriptName as input.
	private void executeScript(JdbcTemplate jdbcTemplate, String scriptName) throws FilePathException, ReadAllLinesException {
		// 2. The resource variable is initialized with the SQL script file's path.
		Resource resource = new ClassPathResource("db_scripts/" + scriptName);
		// 3. The path variable is initialized by attempting to get the resource file's path.
		// 4. If this fails, a FilePathException is thrown with an error message.
		Path path;
		try {
			path = resource.getFile().toPath();
		} catch (IOException e) {
			throw new FilePathException("File does not found");
		}
		// 5. The lines variable is initialized by reading all lines from the path file.
		// 6. If this fails, a ReadAllLinesException is thrown with an error message.
		List<String> lines;
		try {
			lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new ReadAllLinesException("Lines can't be read");
		}
		// 7. The script variable is initialized by joining all lines together.
		String script = String.join("\n", lines);
		// 8. The jdbcTemplate.execute() method is called with the script variable as input.
		jdbcTemplate.execute(script);
	}

}
