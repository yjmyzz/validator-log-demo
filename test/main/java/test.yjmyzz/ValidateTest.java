package test.yjmyzz;


import org.junit.Assert;
import org.junit.Test;
import yjmyzz.model.PlainObject;
import yjmyzz.validator.ValidationUtil;

import java.util.ArrayList;
import java.util.Map;

/**
 * {type your description }
 *
 * @since: 15/11/15.
 * @author: yangjunming
 */
public class ValidateTest {

    @Test
    public void testParamValidate() {
        PlainObject plainObject = new PlainObject();
        plainObject.setName("杨俊明");
        plainObject.setAge(25);
        Map<String, ArrayList<String>> result = ValidationUtil.validator(plainObject);
        Assert.assertTrue(result == null);

        plainObject.setName(null);
        result = ValidationUtil.validator(plainObject);
        Assert.assertTrue(result.containsKey("name"));
        Assert.assertTrue(result.get("name").toString().equals("[名称不能为空]"));

        plainObject.setName("a");
        result = ValidationUtil.validator(plainObject);
        Assert.assertTrue(result.get("name").toString().equals("[名称长度范围为3-50位字符]"));

        plainObject.setAge(0);
        result = ValidationUtil.validator(plainObject);
        Assert.assertTrue(result.containsKey("age"));
        Assert.assertTrue(result.get("age").toString().equals("[年龄必须>0]"));


    }

}
