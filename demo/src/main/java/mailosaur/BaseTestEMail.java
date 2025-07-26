package mailosaur;
import com.mailosaur.MailosaurClient;
import com.mailosaur.models.MessageSearchParams;
public class BaseTestEMail {
	
    // Available in the API tab of a server
    String apiKey = "3EagY3fZAAEGqWUub2XYzBv3QFeFTsHF";
    String serverId = "kq4onley";
    String serverDomain = "kq4onley.mailosaur.net";
    
    MailosaurClient mailosaur = new MailosaurClient(apiKey);
    MessageSearchParams params = new MessageSearchParams();
    
}
