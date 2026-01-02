public class Message {
    private String sender;
    private String receiver; // Can be a single person or can be a public text visible to everyone
    private String content;
    private String timestamp;

    public Message(String sender, String content, String timestamp) {
        this.sender = sender;
        this.receiver = "All";
        this.content = content;
        this.timestamp = timestamp;
    }
    public void privateMessage(String sender, String receiver, String content, String timestamp){
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = timestamp;
    }




    public String getSender(){return this.sender;}
    public String getReceiver(){return this.receiver;}
    public String getContent(){return this.content;}
    public String getTimestamp(){return this.timestamp;}
}
