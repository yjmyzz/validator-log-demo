package yjmyzz.validator;

import javax.validation.*;
import java.util.*;

/**
 * 参数验证工具类
 */
public class ValidationUtil {

    public static <T> Map<String, ArrayList<String>> validator(T t, HashSet<String> skipFields) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
        if (constraintViolations != null && constraintViolations.size() > 0) {
            Map<String, ArrayList<String>> mapErr = new HashMap<String, ArrayList<String>>();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                for (Path.Node node : constraintViolation.getPropertyPath()) {
                    String fieldName = node.getName();
                    if (skipFields == null || !skipFields.contains(fieldName)) {
                        ArrayList<String> lst = mapErr.get(fieldName);
                        if (lst == null) {
                            lst = new ArrayList<String>();
                        }
                        lst.add(constraintViolation.getMessage());
                        mapErr.put(node.getName(), lst);
                    }
                }
            }
            return mapErr;
        }
        return null;
    }

    public static <T> Map<String, ArrayList<String>> validator(T t) {
        return validator(t, null);
    }

}
