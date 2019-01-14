package com.jeorgius.services.tools;

import javax.ejb.Singleton;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Singleton
public class DateValidator {

    //Chrome deletes last zeros, when time is hh:mm:00, and change date to parseable ones
    public List<Date> reParseDates(List<String> wetDates) throws ParseException {
        List<Date> dryDates = new ArrayList<>();

        for (String d: wetDates) {
            if(d.length()-d.replace(":","").length()<2)
                d+=":00";
            dryDates.add(
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                            .parse(d.replace("T"," ").replace("-","/"))
            );
        }
        return dryDates;
    }
}
