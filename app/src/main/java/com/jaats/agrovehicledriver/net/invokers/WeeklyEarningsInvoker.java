package com.jaats.agrovehicledriver.net.invokers;

import org.json.JSONObject;

import java.util.HashMap;

import com.jaats.agrovehicledriver.model.WeeklyEarningsBean;
import com.jaats.agrovehicledriver.net.ServiceNames;
import com.jaats.agrovehicledriver.net.WebConnector;
import com.jaats.agrovehicledriver.net.parsers.WeeklyEarningsParser;
import com.jaats.agrovehicledriver.net.utils.WSConstants;

/**
 * Created by Jemsheer K D on 16 May, 2017.
 * Package com.jaats.agrovehicledriver.net.invokers
 * Project LaTaxiDriver
 */

public class WeeklyEarningsInvoker extends BaseInvoker {

    public WeeklyEarningsInvoker() {
        super();
    }

    public WeeklyEarningsInvoker(HashMap<String, String> urlParams,
                                 JSONObject postData) {
        super(urlParams, postData);
    }

    public WeeklyEarningsBean invokeWeeklyEarningsWS() {

        WebConnector webConnector;

        webConnector = new WebConnector(new StringBuilder(ServiceNames.WEEKLY_EARNINGS), WSConstants.PROTOCOL_HTTP, urlParams, null);

        //webConnector= new WebConnector(new StringBuilder(ServiceNames.MODELS), WSConstants.PROTOCOL_HTTP, null);
//    String wsResponseString=webConnector.connectToPOST_service();
        String wsResponseString = webConnector.connectToGET_service();
        System.out.println(">>>>>>>>>>> response: " + wsResponseString);
        WeeklyEarningsBean weeklyEarningsBean = null;
        if (wsResponseString.equals("")) {
            /*registerBean=new RegisterBean();
            registerBean.setWebError(true);*/
            return weeklyEarningsBean = null;
        } else {
            weeklyEarningsBean = new WeeklyEarningsBean();
            WeeklyEarningsParser weeklyEarningsParser = new WeeklyEarningsParser();
            weeklyEarningsBean = weeklyEarningsParser.parseWeeklyEarningsResponse(wsResponseString);
            return weeklyEarningsBean;
        }
    }
}
