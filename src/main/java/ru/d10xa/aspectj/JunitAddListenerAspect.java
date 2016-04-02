package ru.d10xa.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.runner.notification.RunNotifier;

@Aspect
public class JunitAddListenerAspect {

    @Pointcut("execution(void org.junit.runners.ParentRunner.run(org.junit.runner.notification.RunNotifier))")
    public void run() {
    }

    @Around("run()")
    public void run(ProceedingJoinPoint pjp) {
        Object[] args = pjp.getArgs();
        RunNotifier notifier = (RunNotifier) args[0];
        notifier.addListener(new ExampleRunListener());
        System.out.println("BEFORE TESTS");
        try {
            pjp.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("AFTER TESTS");
    }

}
