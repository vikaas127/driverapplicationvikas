package com.jaats.agrovehicledriver.net.invokers;

import org.json.JSONObject;

import java.util.HashMap;

import com.jaats.agrovehicledriver.model.TripListBean;
import com.jaats.agrovehicledriver.net.ServiceNames;
import com.jaats.agrovehicledriver.net.WebConnector;
import com.jaats.agrovehicledriver.net.parsers.TripListParser;
import com.jaats.agrovehicledriver.net.utils.WSConstants;

/**
 * Created by Jemsheer K D on 11 May, 2017.
 * Package com.jaats.agrovehicledriver.net.invokers
 * Project LaTaxiDriver
 */

public class TripHistoryInvoker extends BaseInvoker {

    public TripHistoryInvoker() {
        super();
    }

    public TripHistoryInvoker(HashMap<String, String> urlParams,
                              JSONObject postData) {
        super(urlParams, postData);
    }

    public TripListBean invokeTripHistoryWS() {

        WebConnector webConnector;

        webConnector = new WebConnector(new StringBuilder(ServiceNames.TRIP_HISTORY), WSConstants.PROTOCOL_HTTP, urlParams, null);

        //webConnector= new WebConnector(new StringBuilder(ServiceNames.MODELS), WSConstants.PROTOCOL_HTTP, null);
//    String wsResponseString=webConnector.connectToPOST_service();
        String wsResponseString = webConnector.connectToGET_service();
        System.out.println(">>>>>>>>>>> response: " + wsResponseString);
        TripListBean tripListBean = null;
        if (wsResponseString.equals("")) {
            /*registerBean=new RegisterBean();
            registerBean.setWebError(true);*/
            return tripListBean = null;
        } else {
            tripListBean = new TripListBean();
            TripListParser tripListParser = new TripListParser();
            tripListBean = tripListParser.parseTripListResponse(wsResponseString);
            return tripListBean;
        }
    }
}
