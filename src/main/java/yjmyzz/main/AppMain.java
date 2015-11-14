package yjmyzz.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yjmyzz.model.PlainObject;
import yjmyzz.service.DemoService;

/**
 * {type your description }
 *
 * @since: 15/11/14.
 * @author: yangjunming
 */
public class AppMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DemoService demoService = ctx.getBean(DemoService.class);
        System.out.println(demoService.sayHello(getPlainObject()));
    }

    public static PlainObject getPlainObject() {
        PlainObject plainObject = new PlainObject();
        plainObject.setName("杨俊明");
        plainObject.setAge(0);
        return plainObject;
    }
}
