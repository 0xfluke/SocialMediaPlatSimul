public class User {

    // User Fields
    // Primary: Accessibility Related
    private int userID;
    private String username;
    private String password;
    private String mailAddress;

    // Secondary: Statistical Purposes
    private String location;
    private String birthDate;
    private String accountCreationDate;
    private int totalLikes;
    private int totalComments;
    private int totalMessagesSent;
    private int totalMessagesReceived;

    // User Constructor
    public User(String username,String mailAddress, String password, String location, String birthDate){

        this.username = username;
        this.password = password;
        this.location = location;
        this.birthDate = birthDate;
        this.mailAddress = mailAddress;

    }

    // Setter Methods
    public void setUsername(){
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    // Getter Methods
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password; }
    public String getMailAddress(){return this.mailAddress;}
    public String getLocation(){return this.location;}
    public String getBirthDate(){return this.birthDate;}


    // Platform Related User Methods
    public void likePost(){}
    public void commentPost(){}
    public void sharePost(){}
    public void sendMessage(){}
    public void updatePersonalInfo(){}
}
