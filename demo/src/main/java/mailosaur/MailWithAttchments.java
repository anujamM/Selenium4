package mailosaur;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.testng.annotations.Test;

import com.mailosaur.MailosaurException;
import com.mailosaur.models.Attachment;
import com.mailosaur.models.Message;
import com.mailosaur.models.SearchCriteria;

public class MailWithAttchments extends BaseTestEMail{
	@Test public void testAttachmentExample() throws IOException, MailosaurException {
		
		Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.HOUR_OF_DAY, -5); // Subtract 5 hours
	    long testStartDate = cal.getTimeInMillis();
	    
	    params.withServer(serverId).withReceivedAfter(testStartDate);
	    
	    SearchCriteria criteria = new SearchCriteria();
//	    criteria.withSentTo("anything@" + serverDomain);
	    criteria.withSentFrom("mailanujam@gmail.com");
	   
	    Message message = mailosaur.messages().get(params, criteria);
	    
		//Mail with attachments:
	    System.out.println(message.attachments().size());
	    
	    List<Attachment> attachments = message.attachments();
	    
	    for(Attachment attach : attachments) {
	    	System.out.println(attach.fileName());
		    System.out.println(attach.content());
		    System.out.println(attach.contentId());
		    System.out.println(attach.contentType());
	    }
	}

}
