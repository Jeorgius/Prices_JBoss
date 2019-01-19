package com.jeorgius.services.tools;

import javax.ejb.Singleton;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Singleton
public class DateValidator {

    //Chrome removes last zeros, when time is hh:mm:00, so add ":00" and change date to parseable ones
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

    //Dates should start and end correctly
    public void ValidateBeginEnd(List<Date> dates_begin, List<Date> dates_end) throws Exception {
        for(int i=0; i<dates_begin.size();i++){
            if((dates_end.get(i).getTime()-dates_begin.get(i).getTime())<0)
                throw new Exception("Some dates are set wrong - Begin: " + dates_begin.get(i)
                        + " End: " + dates_end.get(i)
                );
        }
    }
}
