package prog2.mails.xml;

import java.time.LocalDateTime;

/**
 * Stelt één enkel mailbericht voor.
 */
public class Mail {

    private String subject;

    private String sender;

    private String message;

    private LocalDateTime time;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Mail(String subject, String sender, String message, LocalDateTime time) {
        this.subject = subject;
        this.sender = sender;
        this.message = message;
        this.time = time;
    }
}
