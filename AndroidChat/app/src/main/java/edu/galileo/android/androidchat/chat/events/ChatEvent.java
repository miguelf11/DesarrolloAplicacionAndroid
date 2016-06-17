package edu.galileo.android.androidchat.chat.events;

import edu.galileo.android.androidchat.entities.ChatMessage;

/**
 * Created by Alex on 14-06-2016.
 */
public class ChatEvent {
    ChatMessage Message;

    public ChatMessage getMessage() {
        return Message;
    }

    public void setMessage(ChatMessage message) {
        Message = message;
    }
}
