package com.example.busreservation;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Random;

public class SmsAPI extends Thread{

    private String toPhoneNum;
    private String authNum;

    public SmsAPI(String toPhoneNum){
        this.toPhoneNum = toPhoneNum;
        authNum="";
    }

    public String getAuthNum(){
        return authNum;
    }

    @Override
    public void run() {
        sendSMS();
    }

    public void sendSMS() {
        String api_key = "NCSODUO17V0I4D16";
        String api_secret = "2KYWBLH5VAQARKKEZEUNMVEVR1LSD84A";

        Message coolsms = new Message(api_key, api_secret);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", toPhoneNum);
        params.put("from", "01054151675");
        params.put("type", "SMS");
        authNum = randomGen();
        params.put("text", authNum);
        params.put("app_version", "test app 1.2"); // application name and version

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println("성공");
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println("실패");
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }
    }

    private String randomGen(){
        String numStr = "";
        Random rand = new Random();

        for(int i=0;i<6;i++){
            numStr += Integer.toString(rand.nextInt(10));
        }

        return numStr;
    }

}
