package yjmyzz.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 示例参数对象
 *
 * @since: 15/11/14.
 * @author: yangjunming
 */
public class PlainObject {

    @NotNull(message = "名称不能为空")
    @Length(min = 3, max = 50, message = "名称长度范围为3-50位字符")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Min(value = 1, message = "年龄必须>0")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PlainObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
