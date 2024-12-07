package top.lihaoyu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect //将当前类标记为切面类，并生成代理对象，底层使用的是动态代理
@Component //将当前类对象的创建和管理交由spring容器维护
public class TimerAspect {



    @Around("execution(* top.lihaoyu.store.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //先记录业务执行前的时间
        long startedTime  = System.currentTimeMillis();

        Object result = pjp.proceed(); //调用目标方法，例如login方法
        //还可以在这个位置记录一下每个方法的执行名字和时间，并建议一张数据表记录
        //插入数据库

        //先记录业务执行前的时间
        long endTime  = System.currentTimeMillis();
        //计算耗时
        System.out.println("业务方法总共耗时：" + (endTime - startedTime));

        return result;
    }
}