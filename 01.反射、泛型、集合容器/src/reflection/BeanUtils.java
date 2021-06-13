package reflection;

import java.lang.reflect.Field;

public class BeanUtils {
    /**
     *
     * @param originObj 需要被取值的对象
     * @param targetObj 需要被赋值的对象
     * @throws IllegalAccessException   获取异常
     */
    public static void convertor(Object originObj,Object targetObj) throws IllegalAccessException {
//        获取二者的类对象
        Class originObjClass = originObj.getClass();
        Class targetObjClass = targetObj.getClass();
//        获取filed对象
        Field[] originFields = originObjClass.getDeclaredFields();
        Field[] targetFields = targetObjClass.getDeclaredFields();
//        遍历两个对象寻找相同的属性，并赋值
        for (Field originField : originFields) {
            for (Field targetField : targetFields) {
                if (originField.getName().equals(targetField.getName())){
                    originField.setAccessible(true);
                    targetField.setAccessible(true);
                    targetField.set(targetObj,originField.get(originObj));
                }
            }
        }
    }
}
