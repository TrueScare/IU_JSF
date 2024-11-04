package Structs;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class Messages {
    private List<Message> messages = new ArrayList<>();

    public List<Message> getMessages() {
        return messages;
    }

    public List<Message> addMessage(String message) {
        messages.add(new Message(message));

        return messages;
    }

    public List<Message> addMessage(String message, Message.MessageType type) {
        messages.add(new Message(message, type));

        return messages;
    }

    public List<Message> getMessagesByType(Message.MessageType type) {
        List<Message> filteredMessages = new ArrayList<>();
        for (Message messsage : messages) {
            if (messsage.getType().equals(type)) {
                filteredMessages.add(messsage);
            }
        }
        return filteredMessages;
    }
}
