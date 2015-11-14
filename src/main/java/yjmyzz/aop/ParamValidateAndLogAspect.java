package yjmyzz.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import yjmyzz.validator.ValidationUtil;

import java.util.ArrayList;
import java.util.Map;

/**
 * 参数校验,并将参数及方法执行耗时记录到日志
 *
 * @since: 15/11/14.
 * @author: yangjunming
 */
@Component("paramValidateAndLogAspect")
public class ParamValidateAndLogAspect {

    protected static Logger logger = LogManager.getLogger();

    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

        long start = System.currentTimeMillis();

        logger.info(pjp.getTarget().getClass().getName() + "."
                + pjp.getSignature().getName() + " 方法将被调用,下面是参数:");

        for (Object obj : pjp.getArgs()) {
            logger.info(obj);
            Map<String, ArrayList<String>> validateResult = ValidationUtil.validator(obj);
            if (validateResult != null) {
                for (Map.Entry<String, ArrayList<String>> entry : validateResult.entrySet()) {
                    logger.error(pjp.getTarget().getClass().getName() + "."
                            + pjp.getSignature().getName() + " 方法参数:" + obj);
                    logger.error(entry.getKey() + " 校验不通过,原因:" + entry.getValue());
                    return null;
                }
            }
        }

        Object retVal = pjp.proceed();
        long end = System.currentTimeMillis();
        logger.info("共耗时:" + (end - start) + " 毫秒");
        return retVal;
    }


}
