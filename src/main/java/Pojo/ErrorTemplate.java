package Pojo;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorTemplate {

    private LocalDateTime timestamp;

    public Map<String, String> getMessage() {
        return Message;
    }

    public void setMessage(Map<String, String> message) {
        Message = message;
    }

    private int status;
    private String  error;
    private Map<String,String> Message;
    private String path;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Map<String,String> getMessages() {
        return Message;
    }

    public void setMessages(Map<String,String> Message) {
        this.Message = Message;
    }

    public String getPath() {
        return path;
    }

    public void setPath() {
        this.path = path;
    }

    public ErrorTemplate(LocalDateTime timestamp, int status, String error, Map<String,String> Message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.Message = Message;
        this.path = path;
    }

    public ErrorTemplate(){


}

}
