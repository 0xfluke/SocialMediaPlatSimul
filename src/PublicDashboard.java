import java.util.ArrayList;

public class PublicDashboard {
    private ArrayList<Message> publicFeed = new ArrayList<>();
    private ArrayList<String> bannedWords = new ArrayList<>();



    private boolean inputChecker(String content){
        if(content.isEmpty()){
            System.out.println("Empty Content");
            return false;
        } else if (content.length()<8) {
            System.out.println("Content too short");
            return false;
        } else if (content.length() > 280) {
            System.out.println("Content too long");
            return false;
        } else {
            for(int i = 0; i < bannedWords.size(); i++){
                if(content.contains(bannedWords.get(i))){
                    System.out.println("Banned Word");
                    return false;
                }
            }
        }
        return true;
    }




}
