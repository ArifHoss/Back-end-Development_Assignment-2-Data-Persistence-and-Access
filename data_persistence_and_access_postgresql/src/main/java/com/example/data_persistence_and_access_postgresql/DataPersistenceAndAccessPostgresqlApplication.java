package com.example.data_persistence_and_access_postgresql;

import ch.qos.logback.core.joran.spi.NoAutoStartUtil;
import com.example.data_persistence_and_access_postgresql.exception.FilePathException;
import com.example.data_persistence_and_access_postgresql.exception.ReadAllLinesException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


@SpringBootApplication
public class DataPersistenceAndAccessPostgresqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataPersistenceAndAccessPostgresqlApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(DataSource dataSource) {
        return args -> {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//            if (!databaseExists(jdbcTemplate, "SuperheroesDb")) {
//                executeScript(jdbcTemplate, "create-database.sql");
                executeScript(jdbcTemplate, "01_tableCreate.sql");
//                executeScript(jdbcTemplate, "02_relationshipSuperheroAssistant.sql");
//                executeScript(jdbcTemplate, "03_relationshipSuperheroPower.sql");
//                executeScript(jdbcTemplate, "04_insertSuperheroes.sql");
//                executeScript(jdbcTemplate, "05_insertAssistants.sql");
//                executeScript(jdbcTemplate, "06_power.sql");
//                executeScript(jdbcTemplate, "07_updateSuperhero.sql");
//                executeScript(jdbcTemplate, "08_deleteAssistant.sql");
//            }
        };
    }

    private void executeScript(JdbcTemplate jdbcTemplate, String scriptName) throws FilePathException, ReadAllLinesException {
        Resource resource = new ClassPathResource("/db_scripts/" + scriptName);
        Path path;
        try {
            path = resource.getFile().toPath();
        } catch (IOException e) {
            throw new FilePathException("File does not found");
        }
        List<String> lines;
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ReadAllLinesException("Lines can't be read");
        }
        String script = String.join("\n", lines);
        try {
            jdbcTemplate.execute(script);
        } catch (Exception e) {
            System.out.println("Error executing script " + scriptName + ": " + e.getMessage());
        }
    }


    private boolean databaseExists(JdbcTemplate jdbcTemplate, String dbName) {
        String sql = "SELECT EXISTS (SELECT 1 FROM pg_database WHERE datname = ?)";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{dbName}, Boolean.class);
        } catch (DataAccessException e) {
            System.out.println("Error checking if database exists: " + e.getMessage());
            return false;
        }
    }


    private boolean tableExists(JdbcTemplate jdbcTemplate, String tableName) {
        String sql = "SELECT EXISTS (SELECT 1 FROM information_schema.tables WHERE table_name = ?)";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{tableName}, Boolean.class);
        } catch (DataAccessException e) {
            System.out.println("Error checking if table exists: " + e.getMessage());
            return false;
        }
    }


}
