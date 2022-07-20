package day13workshop.day13wrkshop;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import day13workshop.day13wrkshop.services.DatabaseService;

/* 
 * maven command: ./mvnw clean spring-boot:run -Dspring-boot.run.arguments="--dataDir=/Users/kaikeinwoo/Desktop/VTTP/projects/day13/dump"  
*/

@SpringBootApplication
public class Day13wrkshopApplication implements ApplicationRunner {

	@Autowired
	DatabaseService dbSvc;

	public static void main(String[] args) {
		SpringApplication.run(Day13wrkshopApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) {
		if (args.containsOption("dataDir")) {
			final String dataDir = args.getOptionValues("dataDir").get(0);
			dbSvc.setDataDir(new File(dataDir));
		} else {
			System.out.printf("Insufficient arguments provided");
			System.exit(-1);
		}
	}
}
