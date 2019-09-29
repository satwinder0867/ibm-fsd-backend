import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfiguration {
	
	@Bean
	public Employee employee() {
		return new Employee(address());
	}
	@Bean
	public Address address() {
		return new Address("1","banglore","India",56112);
	}
}
