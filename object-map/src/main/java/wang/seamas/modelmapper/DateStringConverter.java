package wang.seamas.modelmapper;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStringConverter implements Converter<Date, String> {

    // SimpleDateFormat是线程不安全的，采用thread_local来处理
    static final ThreadLocal<DateFormat> thread_local = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy/MM/dd"));

    @Override
    public String convert(MappingContext<Date, String> mappingContext) {
        Date value = mappingContext.getSource();
        if (value == null) {
            return null;
        }

        return thread_local.get().format(value);
    }
}