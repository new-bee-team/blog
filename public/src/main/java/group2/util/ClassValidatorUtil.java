package group2.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: KongKongBaby
 * @Date: 2020.03.03 19:26
 * @Description: 实体类校验 被校验的vo类不允许含有基本类型,请用包装类代替
 */
@Slf4j
public class ClassValidatorUtil {

    private static Set<String> classSet = new HashSet<>();

    //将需要校验的vo实体类加进set
    static {
        classSet.add("group2.entity.vo.UserAccountVO");
    }

    public static boolean checkClass(Object myClass) throws IllegalAccessException {
        String className = myClass.getClass().getName();
        if (classSet.contains(className)) {
            return checkObjAllFieldsIsNull(myClass);
        } else
            throw new RuntimeException("实体类校验失败,\t" + className + "\t未注册");

    }

    //检查某个类是否空 或 任意一个参数空
    private static boolean checkObjAllFieldsIsNull(Object object) throws IllegalAccessException {
        if (null == object)
            return false;
        try {
            Field[] declaredFields = object.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                String paramName = field.getName();
                Object paramValue = field.get(object);
                if (StringUtils.isEmpty(paramValue)) {
                    log.info("\"" + paramName + "\"参数位空!");
                    return false;
                }
            }
        } catch (IllegalAccessException e) {
            log.info("请求实体类参数异常: " + e);
            throw e;
        } catch (Exception e) {
            log.info("ClassValidatorUtil检查类参数异常: " + e);
            throw e;
        }
        return true;
    }
}
