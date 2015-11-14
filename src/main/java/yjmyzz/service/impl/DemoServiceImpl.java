package yjmyzz.service.impl;

import org.springframework.stereotype.Service;
import yjmyzz.model.PlainObject;
import yjmyzz.service.DemoService;

/**
 * 示例服务实现
 *
 * @since: 15/11/14.
 * @author: yangjunming
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(PlainObject obj) {
        return "Hello," + obj.getName() + ". Your age is " + obj.getAge() + " years old.";
    }
}
