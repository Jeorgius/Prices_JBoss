package com.jeorgius.rest;




import com.jeorgius.services.IPrices;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Path("/importprices")
public class ImportPrices {
    private Logger log = Logger.getLogger(ImportPrices.class.getName());

    @Inject
    private IPrices priceService;

    @POST
    public void importPrice(@Context HttpServletRequest req,
                            @Context HttpServletResponse resp,
                            @FormParam("value") List<String> values,
                            @FormParam("date_begin") List<String> date_begin,
                            @FormParam("date_end") List<String> date_end) throws Exception {
        priceService.importPrices(new ArrayList<String>(),date_begin,date_end,new ArrayList<String>());
    }
}
