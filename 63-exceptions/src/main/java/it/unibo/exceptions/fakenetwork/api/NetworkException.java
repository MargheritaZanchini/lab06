package it.unibo.exceptions.fakenetwork.api;

import java.io.IOException;

public class NetworkException extends IOException{
    
    private String message;

    public NetworkException(){
        message = "Network error: no response";
    }

    public NetworkException(String m){
        message = "Network error while sending message: "+m;
    }

    public String getMessage(){
        return message;
    }

}
