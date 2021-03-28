package com.example.chatServerSpring;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class WSHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println("new message received");
//        Boolean room = Room.isCreated(session);
        String messageCommand = message.getPayload().split(" ")[0];

//        Room room = Room.lookup(session);

        if(messageCommand.equals("join")) {
            System.out.println("about to join room");
            Room.joinRoom(session, message.getPayload().split(" ")[1]);

        } else if (messageCommand.equals("get")) {
            Room.sendAvailableRooms(session);

        } else {
            System.out.println(("About to  broadcast message"));
            Room.postMessage(session, message);
        }
//        super.handleTextMessage(session, message);
    }
}

//        if(room == null) {
//        Room.joinRoom(message.getPayload().split("")[1], session);
//        } else {
//        room.postMessage(message.getPayload());