package com.jaats.agrovehicledriver.net.invokers;

import org.json.JSONObject;

import java.util.HashMap;

import com.jaats.agrovehicledriver.model.DocumentStatusBean;
import com.jaats.agrovehicledriver.net.ServiceNames;
import com.jaats.agrovehicledriver.net.WebConnector;
import com.jaats.agrovehicledriver.net.parsers.DocumentStatusParser;
import com.jaats.agrovehicledriver.net.utils.WSConstants;

/**
 * Created by Jemsheer K D on 28 April, 2017.
 * Package com.jaats.agrovehicledriver.net.invokers
 * Project LaTaxiDriver
 */

public class DocumentStatusInvoker extends BaseInvoker {

    public DocumentStatusInvoker() {
        super();
    }

    public DocumentStatusInvoker(HashMap<String, String> urlParams,
                                 JSONObject postData) {
        super(urlParams, postData);
    }

    public DocumentStatusBean invokeDocumentStatusWS() {

        WebConnector webConnector;

        webConnector = new WebConnector(new StringBuilder(ServiceNames.DOCUMENT_STATUS), WSConstants.PROTOCOL_HTTP, urlParams, null);

        //webConnector= new WebConnector(new StringBuilder(ServiceNames.MODELS), WSConstants.PROTOCOL_HTTP, null);
//    String wsResponseString=webConnector.connectToPOST_service();
        String wsResponseString = webConnector.connectToGET_service();
        System.out.println(">>>>>>>>>>> response: " + wsResponseString);
        DocumentStatusBean documentStatusBean = null;
        if (wsResponseString.equals("")) {
            /*registerBean=new RegisterBean();
            registerBean.setWebError(true);*/
            return documentStatusBean = null;
        } else {
            documentStatusBean = new DocumentStatusBean();
            DocumentStatusParser documentStatusParser = new DocumentStatusParser();
            documentStatusBean = documentStatusParser.parseDocumentStatusResponse(wsResponseString);
            return documentStatusBean;
        }
    }
}
