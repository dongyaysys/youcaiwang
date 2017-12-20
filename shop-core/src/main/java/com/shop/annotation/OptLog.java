package com.shop.annotation;
import java.lang.annotation.*;

/**
 * Created by TW on 2017/11/2.
 */
@Target(ElementType.METHOD) // 作用域
@Retention(RetentionPolicy.RUNTIME) // 声明周期
@Inherited
@Documented
public @interface OptLog {
    // 基本类型 String Class 注解 枚举
    String module();

    String desc();

}
