package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
public class ExampleAspect {
    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();

        final Object proceed = joinPoint.proceed();

        if(List.class.isAssignableFrom(List.class)) {
            List<Employee> employee = List.class.cast(joinPoint.getArgs()[0]);

            employee.stream().map(employee1 -> {
                employee1.setFirstName(employee1.getLastName() + "mia"); return employee1; }).collect(Collectors.toList());

            System.out.println(employee.toString());

        }

        final long executionTime = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");

        return proceed;
    }

}
