
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class calendar {

    static Calendar calendar1;
    static String today;
    static Date date;

    public calendar() {
        date = new Date();
    }

    public String getFecha() {
        String today, year, moth, day;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        today = dateFormat.format(date);

        return today;
    }
}
