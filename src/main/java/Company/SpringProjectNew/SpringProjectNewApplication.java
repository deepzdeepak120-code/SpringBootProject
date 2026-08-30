package Company.SpringProjectNew;



import Service.testComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"Company.SpringProjectNew", "Controller","Service","Exception","Security"})
@EntityScan(basePackages = {"Entity"})
@EnableJpaRepositories(basePackages = {"Repository"})

public class SpringProjectNewApplication {

	public static void main(String[] args) {

		ApplicationContext Container = SpringApplication.run(SpringProjectNewApplication.class, args);
		testComponent bean = Container.getBean(testComponent.class);
		bean.deepak();
		
	}
}




