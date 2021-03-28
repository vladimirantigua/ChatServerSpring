package com.example.chatServerSpring;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.awt.font.TextMeasurer;
import java.util.ArrayList;
import java.util.HashMap;

public class RoomInfo {

    static HashMap<WebSocketSession, String> rooms;

    static HashMap<String, ArrayList<TextMessage>> messages;

    static HashMap<String, ArrayList<WebSocketSession>> webSockets;

    RoomInfo(){
        rooms = new HashMap<>();
        messages = new HashMap<>();
        webSockets = new HashMap<>();
    }
}
