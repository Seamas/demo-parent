package wang.seamas.mapstruct;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateMapper {

    private static final ThreadLocal<DateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public String asString(Date date) {
        return date != null ? threadLocal.get().format(date) : null;
    }

    public Date asDate(String str) {
        if (str != null && str.length() > 0) {
            ParsePosition parsePosition = new ParsePosition(0);
            Date date = threadLocal.get().parse(str, parsePosition);
            if (parsePosition.getIndex() > 0) {
                return date;
            }
        }
        return null;
    }
}
