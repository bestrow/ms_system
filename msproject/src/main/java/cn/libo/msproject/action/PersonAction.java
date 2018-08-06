package cn.libo.msproject.action;

import cn.libo.msproject.entity.Person;
import cn.libo.msproject.service.PersonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class PersonAction {

    @Autowired
    private PersonService personService;

    @Test
    public void testPerson(){
        ApplicationContext application = new ClassPathXmlApplicationContext("application-context.xml");
        PersonAction personAction = (PersonAction) application.getBean("personAction");
        Person person = personAction.personService.querypersonbyid(2);
        System.out.println(person.toString());
    }
    
    @Test
    public void testinsert() {
    	ApplicationContext application = new ClassPathXmlApplicationContext("application-context.xml");
        PersonAction personAction = (PersonAction) application.getBean("personAction");
        Person person = new Person();
        person.setName("小米");
        person.setAddress("上海");
        person.setAge(30);
        person.setBirthday("08-08");
        personAction.personService.insertperson(person);
        System.out.println(person);
    }
}
