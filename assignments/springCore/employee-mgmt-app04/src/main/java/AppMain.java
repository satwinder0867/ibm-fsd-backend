import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class AppMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
		
		Employee obj = (Employee) ((BeanFactory) context).getBean("employee");
		//System.out.println("Customer: " + obj);
		//System.out.println("Dependent Person: " + obj.getAddress());
		obj.skills = new ArrayList<String>();
		obj.skills.add("java");
		obj.setId(100);
		obj.setName("John");
		obj.setJoiningDate(new Date());
		obj.setActive(true);
		obj.getAddress().setStreet("Raj Path");
		obj.getAddress().setCity("Chandigarh");
		obj.getAddress().setCountry("India");
		obj.getAddress().setPincode(56112);
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
		String dateString = format.format( new Date());
		System.out.println("id:"+obj.getId()+"\n"+"Ename:"+obj.getName()+"\n"+"joining Date:"+dateString+"\n"+"skills:"+obj.getSkills()+"\n"+"Status:"+obj.isActive());
		System.out.println("Address:"+
				obj.getAddress().getStreet() + " " + obj.getAddress().getCity() + " " + obj.getAddress().getCountry()+" "+obj.getAddress().getPincode());
		
		context.registerShutdownHook();
	}

}
