package com.xec.java.anotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjectToJsonConverter {

    public String convertToString(Object object){
        try {
            checkIfSerializable(object);
            initObject(object);
            return jsonSxtring(object);

        }catch (Exception e){
            throw new JsonSerializationException(e.getMessage());
        }
    }

    private String jsonSxtring(Object object) throws IllegalAccessException {
        Class<?> clazz=object.getClass();
        Map<String,String> jsonElementMap=new HashMap<>();

        for(Field field:clazz.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(JsonElement.class)){
                jsonElementMap.put(getKey(field),(String) field.get(object));
            }
        }

        String jsonString =jsonElementMap.entrySet().stream().map(entry->"\""+entry.getKey()+"\":\""+entry.getValue()+"\"")
                .collect(Collectors.joining(","));
        return "{" + jsonString + "}";
    }

    private String getKey(Field field){
        String value=field.getAnnotation(JsonElement.class).key();
        return  value.isEmpty()?field.getName():value;
    }

    private void initObject(Object object) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz=object.getClass();
        for(Method m:clazz.getDeclaredMethods()){
            if(m.isAnnotationPresent(Init.class)){
                //The call of method.setAccessible(true) allows us to execute the private initNames() method.
                m.setAccessible(true);
                m.invoke(object);
            }
        }
    }

    private void checkIfSerializable(Object object) {
        if(Objects.isNull(object)){
            throw new JsonSerializationException("Can't serialize a null object");
        }

        Class<?> clazz=object.getClass();
        if(!clazz.isAnnotationPresent(JsonSerializable.class)){
            throw new JsonSerializationException("The class " + clazz.getSimpleName() + " is not annotated with JsonSerializable");
        }

    }
}
