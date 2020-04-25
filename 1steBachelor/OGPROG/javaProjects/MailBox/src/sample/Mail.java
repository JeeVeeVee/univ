package sample;

public class Mail {
    private String from;
    private String to;
    private String subject;
    private String message;

    public Mail(String from, String to, String subject, String message){
        this.from = from;
        this.message = message;
        this.to = to;
        this.subject = subject;
    }
}
