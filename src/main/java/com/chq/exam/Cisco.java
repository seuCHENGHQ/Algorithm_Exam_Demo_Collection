package com.chq.exam;

public class Cisco {
    public static void main(String[] args) {
        String uri = "\"Cisco\"<sip:10000@172.16.130.42>";
        System.out.println(solution(uri));
        uri = "\"%22huntpilot%22name%22\"<sip:10000@172.16.130.42>";
        System.out.println(solution(uri));
        uri = "2%22huntpilot%22name%22<sip:10000@172.16.130.42>";
        System.out.println(solution(uri));
    }

    public static String solution(String uri) {
        String alertName = "";
//        if (uri.contains("%22") && uri.indexOf("%22") == 1) {
//            int start = uri.indexOf("%22");
//            int end = uri.lastIndexOf("%22");
//            alertName = uri.substring(start + 3, end);
//        } else {
//            int index = uri.indexOf("<");
//            String str = uri.substring(0, index);
//            alertName = str.replaceAll("\"", "");
//        }
        int len = uri.indexOf("<");
        uri = uri.substring(0, len);
        uri = uri.replaceAll("\"","");
//        if ()
        return alertName;
    }
}
