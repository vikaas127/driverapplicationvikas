package com.jaats.agrovehicledriver.net.invokers;


import org.json.JSONObject;

import java.util.HashMap;

import com.jaats.agrovehicledriver.model.AuthBean;
import com.jaats.agrovehicledriver.net.ServiceNames;
import com.jaats.agrovehicledriver.net.WebConnector;
import com.jaats.agrovehicledriver.net.parsers.PhoneRegisrationParser;
import com.jaats.agrovehicledriver.net.utils.WSConstants;

public class PhoneRegistrationInvoker extends BaseInvoker {

    public PhoneRegistrationInvoker() {
        super();
    }

    public PhoneRegistrationInvoker(HashMap<String, String> urlParams,
                                    JSONObject postData) {
        super(urlParams, postData);
    }

    public AuthBean invokePhoneRegistrationWS() {

        System.out.println("POSTDATA>>>>>>>" + postData);

        WebConnector webConnector;

        webConnector = new WebConnector(new StringBuilder(ServiceNames.PHONE_REGISTRATION), WSConstants.PROTOCOL_HTTP, null, postData);

        String wsResponseString = webConnector.connectToPOST_service();

        System.out.println(">>>>>>>>>>> response: " + wsResponseString);
        AuthBean authBean = null;
        if (wsResponseString.equals("")) {

            return authBean = null;
        } else {
            authBean = new AuthBean();
            PhoneRegisrationParser phoneRegisrationParser = new PhoneRegisrationParser();
            authBean = phoneRegisrationParser.parsePhoneRegistrationResponse(wsResponseString);
            return authBean;
        }
    }
}
