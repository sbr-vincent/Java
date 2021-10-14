import java.util.Date;
public class AlfredQuotes {
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        return String.format("Hi %s. Lovely to see you.", name);
    }

    public String guestGreeting(String name, String dayPeriod) {
        if(dayPeriod.indexOf("morning") != -1){
            return String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);    
        } else if(dayPeriod.indexOf("afternoon") != -1){
            return String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);    
        } else {
            return String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);    
        }
    }

    public String dateAnnouncement() {
        Date date = new Date();
        return ("It is currently " + date);
    }

    public String respondBeforeAlexis(String conversation) {
        if(conversation.indexOf("Alexis") != -1){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if (conversation.indexOf("Alfred") != -1){
            return "At your service. As you wish, naturally.";
        }else {
            return "Right. And with that I shall retire.";
        }
    }

}