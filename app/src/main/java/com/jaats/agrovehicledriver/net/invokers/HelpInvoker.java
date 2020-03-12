package com.jaats.agrovehicledriver.net.invokers;

import org.json.JSONObject;

import java.util.HashMap;

import com.jaats.agrovehicledriver.model.HelpBean;
import com.jaats.agrovehicledriver.net.ServiceNames;
import com.jaats.agrovehicledriver.net.WebConnector;
import com.jaats.agrovehicledriver.net.parsers.HelpParser;
import com.jaats.agrovehicledriver.net.utils.WSConstants;

/**
 * Created by Jemsheer K D on 20 May, 2017.
 * Package com.jaats.agrovehicledriver.net.invokers
 * Project LaTaxiDriver
 */

public class HelpInvoker extends BaseInvoker {

    public HelpInvoker() {
        super();
    }

    public HelpInvoker(HashMap<String, String> urlParams,
                       JSONObject postData) {
        super(urlParams, postData);
    }

    public HelpBean invokeHelpWS() {

        WebConnector webConnector;

        webConnector = new WebConnector(new StringBuilder(ServiceNames.HELP_PAGE), WSConstants.PROTOCOL_HTTP, urlParams, null);

        //webConnector= new WebConnector(new StringBuilder(ServiceNames.MODELS), WSConstants.PROTOCOL_HTTP, null);
//    String wsResponseString=webConnector.connectToPOST_service();
        String wsResponseString = webConnector.connectToGET_service();
        System.out.println(">>>>>>>>>>> response: " + wsResponseString);
        HelpBean helpBean = null;
        if (wsResponseString.equals("")) {
            /*registerBean=new RegisterBean();
            registerBean.setWebError(true);*/
            return helpBean = null;
        } else {
            helpBean = new HelpBean();
            HelpParser helpParser = new HelpParser();
            helpBean = helpParser.parseHelpResponse(wsResponseString);
            return helpBean;
        }
    }
}
