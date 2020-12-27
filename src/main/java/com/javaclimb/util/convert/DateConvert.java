package com.javaclimb.util.convert;

import org.springframework.core.convert.converter.Converter;

import com.javaclimb.util.TextUtils;
import com.javaclimb.util.exception.CustomerException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 全局日期处理类
 * Convert<T,S>
 * 泛型T:代表客户端提交的参数 String
 * 泛型S:通过convert转换的类型
 */
public class DateConvert implements Converter<String, Date> {
    private static final List<String> formarts = new ArrayList<>(4);

    static {
        formarts.add("yyyy-MM");
        formarts.add("yyyy-MM-dd");
        formarts.add("yyyy-MM-dd hh:mm");
        formarts.add("yyyy-MM-dd hh:mm:ss");
        formarts.add("yyyy/MM");
        formarts.add("yyyy/MM/dd");
        formarts.add("yyyy/MM/dd hh:mm");
        formarts.add("yyyy/MM/dd hh:mm:ss");
    }

    @Override
    public Date convert(String source) {
        if (TextUtils.isEmpty(source)) {
            return null;
        }
        String value = source.trim();
        if (source.contains("-")) {
            if (source.matches("^\\d{4}-\\d{1,2}$")) {
                return parseDate(source, formarts.get(0));
            } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
                return parseDate(source, formarts.get(1));
            } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
                return parseDate(source, formarts.get(2));
            } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
                return parseDate(source, formarts.get(3));
            } else {
                throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
            }
        } else {
            if (source.matches("^\\d{4}/\\d{1,2}$")) {
                return parseDate(source, formarts.get(0));
            } else if (source.matches("^\\d{4}/\\d{1,2}/\\d{1,2}$")) {
                return parseDate(source, formarts.get(1));
            } else if (source.matches("^\\d{4}/\\d{1,2}/\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
                return parseDate(source, formarts.get(2));
            } else if (source.matches("^\\d{4}/\\d{1,2}/\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
                return parseDate(source, formarts.get(3));
            } else {
                throw new CustomerException("如期传参有误：'" + source + "'");
            }
        }
    }

    /**
     * 功能描述：格式化日期
     *
     * @param dateStr String 字符型日期
     * @param format  String 格式
     * @return Date 日期
     */
    public Date parseDate(String dateStr, String format) {
        Date date = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = (Date) dateFormat.parse(dateStr);
        } catch (Exception e) {
        }
        return date;
    }
}
