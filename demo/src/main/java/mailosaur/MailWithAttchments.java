package mailosaur;

import java.io.IOException;
import java.util.Calendar;

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
	    
	    Attachment firstAttachment = message.attachments().get(0);
	    System.out.println(firstAttachment.fileName());
	    System.out.println(firstAttachment.content());
		
	}
    

}
