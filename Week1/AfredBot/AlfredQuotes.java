import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "Hello, " + name + ". Lovely to see you.";
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        return "It is currently Wed Aug 11 16:34:59 PDT 2022.";
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        // System.out.println(conversation.indexOf("Alexis"));

        if (conversation.indexOf("Alexis") >= 0) {
            return ("Right away, sir. She certainly isn't sophisticated enough for that.");
        } 
        else if (conversation.indexOf("Alfred") >= 0 ) {
            return ("At your service. As you wish, naturally.");
        } else { 
            return ("Right. And with that I shall retire.");
        }

        // String finconversation = System.out.println(newconversation.matches("Alexis!"));
        // return "End of Conversation";
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

