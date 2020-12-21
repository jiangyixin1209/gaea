package top.jiangyixin.gaea.core.annotation;

import java.lang.annotation.*;

/**
 * 实体字体抽取
 * @version 1.0
 * @author jiangyixin
 * @date 2020/12/21 下午5:50
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface EntityFieldExtract {
}
