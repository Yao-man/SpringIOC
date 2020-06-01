package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cym.model.Phone;
import com.cym.model.Student;
import com.cym.model.TestLifecycle;
import com.cym.model.User;

/**
 * @description
 * 
 * @author Yaman
 * @createDate 2020/05/31
 */
public class Test {

	@org.junit.Test
	public void testInit0() {
		/*BeanFactory：Spring IOC容器 基本实现，是Spring内部使用接口，不提供开发者进行使用
		 * 加载配置文件的时候不创建对象，在获取对象时创建对象
		 * */
		BeanFactory context = new ClassPathXmlApplicationContext("bean.xml");
		User user = context.getBean("user", User.class);//创建对象
		user.display();
	}

	@org.junit.Test
	public void testInit1() {
		/*ApplicationContext：是BeanFactory接口的子接口，允许开发者使用，并向开发者提供强大的功能
		 * 加载配置文件时就创建对象
		 * */
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");//加载配置文件并创建对象（配置文件没有特殊配置，默认单例）
		User user = context.getBean("user", User.class);//无需创建对象
		user.display();
	}

	@org.junit.Test
	public void testSetUser() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		User user = context.getBean("setInitUser", User.class);
		user.display();
	}

	@org.junit.Test
	public void testConstructorUser() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		User user = context.getBean("constructorInitUser", User.class);
		user.display();
	}
	
	@org.junit.Test
	public void testConstructorPhone() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Phone p = context.getBean("constructorInitPhone", Phone.class);
		System.out.println(p);
	}
	
	@org.junit.Test
	public void testSetPhone() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Phone p = context.getBean("setInitPhone", Phone.class);
		System.out.println(p);
	}
	
	@org.junit.Test
	public void testConstructorPhone1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Phone p = context.getBean("constructorInitPhone1", Phone.class);
		System.out.println(p);
	}
	
	@org.junit.Test
	public void testSetStudentListInit1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Student stu = context.getBean("setInitStu1", Student.class);
		System.out.println(stu);
	}
	
	@org.junit.Test
	public void testSetStudentListInit2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Student stu = context.getBean("setInitStu2", Student.class);
		System.out.println(stu);
	}
	

	@org.junit.Test
	public void testFactoryBean() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Student stu = context.getBean("mybean", Student.class);
		System.out.println(stu);
	}
	


	@org.junit.Test
	public void testLifecycle() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		TestLifecycle lc = context.getBean("lifecycle", TestLifecycle.class);
		System.out.println("第四步:使用对象  -->" + lc.getName());
		//手动关闭容器,触发bean销毁方法
		context.close();
	}
	
	@org.junit.Test
	public void testAutowireInitPhone() {
		ApplicationContext context = new ClassPathXmlApplicationContext("selfInitBean.xml");
		Phone p = context.getBean("phone", Phone.class);
		System.out.println(p);
	}
}
