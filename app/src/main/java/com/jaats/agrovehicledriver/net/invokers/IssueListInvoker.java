package com.jaats.agrovehicledriver.net.invokers;

import org.json.JSONObject;

import java.util.HashMap;

import com.jaats.agrovehicledriver.model.IssueListBean;
import com.jaats.agrovehicledriver.net.ServiceNames;
import com.jaats.agrovehicledriver.net.WebConnector;
import com.jaats.agrovehicledriver.net.parsers.IssueListParser;
import com.jaats.agrovehicledriver.net.utils.WSConstants;

/**
 * Created by Jemsheer K D on 19 May, 2017.
 * Package com.jaats.agrovehicledriver.net.invokers
 * Project LaTaxiDriver
 */

public class IssueListInvoker extends BaseInvoker {

    public IssueListInvoker() {
        super();
    }

    public IssueListInvoker(HashMap<String, String> urlParams,
                            JSONObject postData) {
        super(urlParams, postData);
    }

    public IssueListBean invokeIssueListWS() {

        WebConnector webConnector;

        webConnector = new WebConnector(new StringBuilder(ServiceNames.ISSUE_LIST),
                WSConstants.PROTOCOL_HTTP, urlParams, null);

        //webConnector= new WebConnector(new StringBuilder(ServiceNames.MODELS), WSConstants.PROTOCOL_HTTP, null);
//    String wsResponseString=webConnector.connectToPOST_service();
        String wsResponseString = webConnector.connectToGET_service();
        System.out.println(">>>>>>>>>>> response: " + wsResponseString);
        IssueListBean issueListBean = null;
        if (wsResponseString.equals("")) {
            /*registerBean=new RegisterBean();
            registerBean.setWebError(true);*/
            return issueListBean = null;
        } else {
            issueListBean = new IssueListBean();
            IssueListParser issueListParser = new IssueListParser();
            issueListBean = issueListParser.parseIssueListResponse(wsResponseString);
            return issueListBean;
        }
    }
}
