package com.tddk.chatbotapp.util;

public class TextJustification {
    //Remove white space and make text lowercase
    //ex: " Hello  hi " -> "hello hi"
    public static String justify(String text) {
        return text.trim().replaceAll("\\s+", " ").toLowerCase();
    }
}
