package com.glb.sz.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;

public class UpdateUtil {

    public static <Entity,DTO> Entity updateAObj(Entity entity,DTO dto){
        if(entity == null || dto == null){
            return null;
        }

        try {
            Class<?> entityClass = Class.forName(entity.getClass().getName());
            Class<?> dtoClass = Class.forName(dto.getClass().getName());

            Field[] dtoFields = dtoClass.getDeclaredFields();
            for(Field f : dtoFields){
                String dtoFieldName = f.getName();
                String getDTOValueMethodName = "get"+
                        dtoFieldName.substring(0,1).toUpperCase()+
                        dtoFieldName.substring(1);

                String setEntityValueMethodName = "set"+
                        dtoFieldName.substring(0,1).toUpperCase() +
                        dtoFieldName.substring(1);

                try {
                    Method setEntityValueMethod = entityClass.getMethod(setEntityValueMethodName,f.getType());
                    Method getDTOValueMethod = dtoClass.getMethod(getDTOValueMethodName);

                    try {
                        setValueByType(entity,setEntityValueMethod,getDTOValueMethod.invoke(dto));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return entity;
    }

    public static  <T> T updateAObj(T entity,String str) {
        HashMap<String, String> value = parseValue(str);
        if (value == null) {
            return null;
        }
        try {
            Class<?> c = Class.forName(entity.getClass().getName());

            Field[] fields = c.getDeclaredFields();
            for (Field f : fields) {
                String fieldName = f.getName();
                if (!value.keySet().contains(fieldName)) {
                    continue;
                }

                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Object filedValue = null;
                try {
                    Method method = c.getMethod(getMethodName);
                    if (method != null) {
                        try {
                            filedValue = method.invoke(entity);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                Object newValue = value.get(f.getName());
                if (filedValue instanceof Integer) {
                    newValue = Integer.parseInt(value.get(f.getName()));

                }
                if (filedValue instanceof Float) {
                    newValue = Float.parseFloat(value.get(f.getName()));
                }

                if (filedValue instanceof Date) {
                    newValue = Date.parse(value.get(f.getName()));
                }

                if(filedValue instanceof String){
                    newValue =String.valueOf(value.get(f.getName()));
                }

                String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                try {
                    Method method = c.getMethod(setMethodName, f.getType());
                    if (method != null) {
                        try {
                            if (f.getName().equals("password")) {
                                method.invoke(entity, MD5Util.getMD5String((String) newValue));
                            } else {
                                method.invoke(entity, newValue);
                            }
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }


            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return entity;
    }

    private static <Entity> void setValueByType(Entity entity,Method method,Object value)
            throws InvocationTargetException, IllegalAccessException {
        if(value instanceof String){
            method.invoke(entity,String.valueOf(value));
        }

        if(value instanceof Date){
            method.invoke(entity,(Date) value);
        }

        if(value instanceof Float){
            method.invoke(entity,(Float) value);
        }

        if(value instanceof Integer){
            method.invoke(entity,(Integer) value);
        }


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
