package Structs;

public class Message {
    public enum MessageType {
        INFO,
        WARNING,
        ERROR
    }

    private final String message;
    private final MessageType type;

    public Message(String message) {
        this.message = message;
        this.type = MessageType.INFO;
    }

    public Message(String message, MessageType type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public MessageType getType() {
        return type;
    }
}
