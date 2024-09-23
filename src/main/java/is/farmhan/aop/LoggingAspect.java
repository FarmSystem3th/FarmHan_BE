package is.farmhan.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void allControllerMethods() {}

    @Before("allControllerMethods()")
    public void logBeforeControllerMethod() {
        String threadName = Thread.currentThread().getName();
        logger.info("Request: " + threadName);
    }

    // 모든 컨트롤러 메서드가 실행된 후에 스레드 정보 로깅
    @After("allControllerMethods()")
    public void logAfterControllerMethod() {
        String threadName = Thread.currentThread().getName();
        logger.info("End: " + threadName);
    }

}
