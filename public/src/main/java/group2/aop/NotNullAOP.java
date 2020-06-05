package group2.aop;

import group2.annotation.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author: KongKongBaby
 * @create: 2020-06-05 11:05
 * @description:
 **/

@Aspect
@Component
@Slf4j
public class NotNullAOP {

    @Pointcut("execution(* *.controller..*.*(..)))")
    public void valid() {
    }

    @Before("valid()")
    public void check(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        final Object[] values = joinPoint.getArgs();//参数值
        final String[] names = signature.getParameterNames();//参数名
        final Class[] paramTypes = method.getParameterTypes();//参数类型
        Annotation notNull = method.getAnnotation(NotNull.class);
        //如果该方法被 @NotNull 修饰，那就要检查参数是否为空
        if (null != notNull) {
            for (int i = 0; i < names.length; i++) {
                if (StringUtils.isEmpty(values[i])) {
                    throw new IllegalArgumentException("参数: " + names[i] + "\t为空!");
                }
                log.info("参数名: " + names[i] + ",参数值: " + values[i] + ",参数类型: " + paramTypes[i]);
            }
        }
    }
}
