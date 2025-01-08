package mx.edu.utez.rismotorolos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RisMotorolosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RisMotorolosApplication.class, args);
	}

}
