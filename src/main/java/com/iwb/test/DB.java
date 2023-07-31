package com.iwb.test;

import java.lang.annotation.*;

//该元注解的作用是用来定义自定义注解的声明周期
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DB {
    String driveClassName();
    String url();
    String username();
    String password();
}
