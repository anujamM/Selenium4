package mailosaur;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.testng.annotations.Test;
import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Link;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
public class TestMail {
	@Test public void testExample() throws IOException, MailosaurException {
	    // Available in the API tab of a server
	    String apiKey = "3EagY3fZAAEGqWUub2XYzBv3QFeFTsHF";
	    String serverId = "kq4onley";
	    String serverDomain = "kq4onley.mailosaur.net";
	    
	    MailosaurClient mailosaur = new MailosaurClient(apiKey);
	    MessageSearchParams params = new MessageSearchParams();
	    
//	    Date testStartDate = new Date();
//	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); // ISO 8601 style
//	    Date testStartDate = sdf.parse("2025-07-17T13:00:00");
	    
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.HOUR_OF_DAY, -5); // Subtract 5 hours
	    long testStartDate = cal.getTimeInMillis();
	    
	    params.withServer(serverId).withReceivedAfter(testStartDate);
	    
	    SearchCriteria criteria = new SearchCriteria();
//	    criteria.withSentTo("anything@" + serverDomain);
	    criteria.withSentFrom("mailanujam@gmail.com");
	   
	    Message message = mailosaur.messages().get(params, criteria);
	    
	    System.out.println("--------Subject--------");
	    System.out.println(message.subject());
	    assertNotNull(message);
	    assertEquals(message.subject().contains("View your Credit Report"), true);
	    
	    System.out.println("--------Body--------");
	    System.out.println(message.text().body());
	    
	    System.out.println("--------Links--------");
	    System.out.println(message.html().links());
	    List<Link> links = message.html().links();
	    
	    for(Link l : links) {
	    	System.out.println("Text:" + l.text());
	    	System.out.println("Links:" + l.href());
	    }
	    
	  }
}
