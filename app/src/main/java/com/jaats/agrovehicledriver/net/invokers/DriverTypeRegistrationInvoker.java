package com.jaats.agrovehicledriver.net.invokers;


import org.json.JSONObject;

import java.util.HashMap;

import com.jaats.agrovehicledriver.model.BasicBean;
import com.jaats.agrovehicledriver.net.ServiceNames;
import com.jaats.agrovehicledriver.net.WebConnector;
import com.jaats.agrovehicledriver.net.parsers.BasicParser;
import com.jaats.agrovehicledriver.net.utils.WSConstants;

public class DriverTypeRegistrationInvoker extends BaseInvoker {

    public DriverTypeRegistrationInvoker() {
        super();
    }

    public DriverTypeRegistrationInvoker(HashMap<String, String> urlParams,
                                         JSONObject postData) {
        super(urlParams, postData);
    }

    public BasicBean invokeDriverTypeRegistrationWS() {

        System.out.println("POSTDATA>>>>>>>" + postData);

        WebConnector webConnector;

        webConnector = new WebConnector(new StringBuilder(ServiceNames.DRIVER_TYPE_REGISTRATION), WSConstants.PROTOCOL_HTTP, null, postData);

        String wsResponseString = webConnector.connectToPOST_service();

        System.out.println(">>>>>>>>>>> response: " + wsResponseString);
        BasicBean basicBean = null;
        if (wsResponseString.equals("")) {

            return basicBean = null;
        } else {
            basicBean = new BasicBean();
            BasicParser basicParser = new BasicParser();
            basicBean = basicParser.parseBasicResponse(wsResponseString);
            return basicBean;
        }
    }
}
