package com.example.chatServerSpring;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;

public class Room {

    public static void joinRoom(WebSocketSession session, String message) throws IOException {
        RoomInfo.rooms.put(session, message);
        if (RoomInfo.webSockets.containsKey(message)){
            RoomInfo.webSockets.get(message).add(session);
            if (RoomInfo.messages.get(message) != null) {
                for (int i = 0; i < RoomInfo.messages.get(message).size(); i++) {
                    session.sendMessage(RoomInfo.messages.get(message).get(i));

                }
            }
        } else {
            ArrayList<WebSocketSession> temp = new ArrayList<>();
            temp.add(session);
            RoomInfo.webSockets.put(message, temp);
        }
        RoomInfo.rooms.put(session, message);
        ArrayList<TextMessage> messages = new ArrayList<>();
        RoomInfo.messages.put(message, messages);
    }

    public static Boolean isCreated(WebSocketSession session) {
        return RoomInfo.rooms.containsKey(session);
    }

    public static void postMessage(WebSocketSession session, TextMessage message) throws IOException {
        String room = RoomInfo.rooms.get(session);

        for (int i = 0; i < RoomInfo.webSockets.get(room).size(); i++) {
            System.out.println("sending messages to those in room");
            RoomInfo.webSockets.get(room).get(i).sendMessage(message);
        }

        RoomInfo.messages.get(room).add(message);
    }
    public static void sendAvailableRooms(WebSocketSession session) throws IOException {
        for (String key: RoomInfo.webSockets.keySet() ) {
            TextMessage test = new TextMessage(key);
            session.sendMessage(test);
        }
    }
}
