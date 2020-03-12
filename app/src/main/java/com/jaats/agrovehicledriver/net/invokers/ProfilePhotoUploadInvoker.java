package com.jaats.agrovehicledriver.net.invokers;


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jaats.agrovehicledriver.model.BasicBean;
import com.jaats.agrovehicledriver.net.ServiceNames;
import com.jaats.agrovehicledriver.net.WebConnector;
import com.jaats.agrovehicledriver.net.parsers.BasicParser;
import com.jaats.agrovehicledriver.net.utils.WSConstants;

public class ProfilePhotoUploadInvoker extends BaseInvoker {

    public ProfilePhotoUploadInvoker() {
        super();
    }

    public ProfilePhotoUploadInvoker(HashMap<String, String> urlParams,
                                     JSONObject postData) {
        super(urlParams, postData);

    }

    public BasicBean invokeProfilePhotoUploadWS(ArrayList<String> fileList) {

        System.out.println("POSTDATA>>>>>>>" + postData);

        WebConnector webConnector;

        webConnector = new WebConnector(new StringBuilder(ServiceNames.UPLOAD_PROFILE_PHOTO),
                WSConstants.PROTOCOL_HTTP, null, postData, fileList);

        String wsResponseString = webConnector.connectToMULTIPART_POST_service("profile_photo");

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
