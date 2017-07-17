package archlab;


import archlab.entity.Group;
import archlab.repository.GroupsDao;
import archlab.repository.TeachersDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@SpringBootApplication
public class Main {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	public CommandLineRunner init(ApplicationContext context) {
		return (args) -> {
			Connection con = context.getBean(DataSource.class).getConnection();
			ScriptUtils.executeSqlScript(con, new EncodedResource(new ClassPathResource("db/structure.sql"), "UTF-8"));
			ScriptUtils.executeSqlScript(con, new EncodedResource(new ClassPathResource("db/data.sql"), "UTF-8"));
		};
	}
}
