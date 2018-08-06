package com.glb.sz.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;

public class UpdateUtil {

    public static  <T> T updateAObj(T entity,String str){
        HashMap<String,String> value = parseValue(str);
        if(value == null){
            return null;
        }
        try {
            Class<?> c = Class.forName(entity.getClass().getName());

            Field[] fields = c.getDeclaredFields();
            for(Field f : fields){
                String fieldName = f.getName();
                if(!value.keySet().contains(fieldName)){
                    continue;
                }

                String getMethodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
                Object filedValue = null;
                try {
                    Method method = c.getMethod(getMethodName);
                    if(method != null){
                        try {
                            filedValue = method.invoke(entity);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

                if(filedValue instanceof Integer){
                    filedValue = Integer.parseInt(value.get(f.getName()));
                }
                if(filedValue instanceof Float){
                    filedValue = Float.parseFloat(value.get(f.getName()));
                }

                if(filedValue instanceof Date){
                    filedValue = Date.parse(value.get(f.getName()));
                }

                if(filedValue != null){
                    String setMethodName = "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
                    try {
                        Method method = c.getMethod(setMethodName);
                        if(method != null){
                            try {
                                method.invoke(entity,filedValue);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return entity;
    }

    private static HashMap<String,String> parseValue(String s){
        HashMap<String,String> map = new HashMap<>();
        String [] column = s.split(",");
        for(String value:column){
            String[] columnAndValue = value.split("=");
            map.put(columnAndValue[0],columnAndValue[1]);
        }

        return map;
    }
}
