package group2.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author: KongKongBaby
 * @create: 2020-06-18 10:07
 * @description:
 **/

@Aspect
@Component
@Slf4j
public class LogAOP {

    Long startTime = null;
    Long endTime = null;

    @Pointcut("execution(* *.controller..*.*(..)))")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        startTime = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        log.info("---------------" + methodName + " before---------------");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + methodName);
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            log.info(paraName + ": " + request.getParameter(paraName));
        }
    }

    @AfterReturning("logPointCut()")
    public void doAfterReturning(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        endTime = System.currentTimeMillis();
        log.info(methodName + "花费时间 : " + (endTime - startTime) + "ms");
        log.info("---------------" + methodName + " end---------------");
    }
}
