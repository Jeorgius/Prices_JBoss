package com.jeorgius.rest;




import com.jeorgius.services.PriceService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Path("/importprices")
public class ImportPrices {
    private Logger log = Logger.getLogger(ImportPrices.class.getName());

    @Inject
    private PriceService priceService;

    @POST
    public void importPrice(@Context HttpServletRequest req,
                            @Context HttpServletResponse resp,
                            @FormParam("value") List<String> values,
                            @FormParam("date_begin") List<String> date_begin,
                            @FormParam("date_end") List<String> date_end) throws ServletException, IOException, ParseException {
        log.info(values.toString());
        log.info(date_begin.toString());
        log.info(date_end.toString());
        Date now = new Date();
        log.info("Standard date: "+now);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String newNow = dateFormat.format(now);
        log.info(newNow);

        Date date1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                .parse(date_end.get(0)/*.replace("T"," ").replace("-","/")*/);
        log.info(date1.toString());
//        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
