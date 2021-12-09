package wang.seamas.modelmapper;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDateConverter implements Converter<String, Date> {

    static final ThreadLocal<DateFormat[]> thread_local = ThreadLocal.withInitial(() -> new DateFormat[]{
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
            new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"),
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyy/MM/dd")
    });

    @Override
    public Date convert(MappingContext<String, Date> mappingContext) {
        String value = mappingContext.getSource();
        if (value == null) {
            return null;
        }
        DateFormat[] formats = thread_local.get();
        for(int index = 0; index < formats.length; index++ ) {
            ParsePosition parsePosition = new ParsePosition(0);
            Date date = formats[index].parse(value, parsePosition);
            if (parsePosition.getIndex() > 0) {
                return date;
            }
        }
        return null;
    }
}
