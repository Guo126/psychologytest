package com.glb.sz.convert;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Configuration
public class DateConvertConfig implements Converter<String,Date> {


    @Override
    public Date convert(String s) {
        try {
            return new SimpleDateFormat("yyyyMMdd").parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
