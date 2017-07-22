package beans;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by twx on 2017/5/9.
 */
@Aspect
public class Audience {
    @Pointcut("execution(* concert.Performance.perform(..))")
    public void performance() {

    }

//    @Before("performance()")
//    public void silenceCellPhones() {
//        System.out.println("请关机...");
//    }
//
//    @Before("performance()")
//    public void takeSeats() {
//        System.out.println("入座中...");
//    }
//
//    @AfterReturning("performance()")
//    public void applause() {
//        System.out.println("表演结束，鼓掌....");
//    }
//
//    @AfterThrowing("performance()")
//    public void demandRefund() {
//        System.out.println("表演失败....");
//    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("入座中...");
            System.out.println("请关机...");
            jp.proceed();
            System.out.println("表演结束，鼓掌....");
        } catch (Throwable throwable) {
            System.out.println("表演失败....");
        }

    }
}
