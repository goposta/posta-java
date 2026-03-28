import com.github.goposta.posta.*;

import java.util.List;
import java.util.Map;

public class SendEmailExample {

    public static void main(String[] args) throws Exception {
        PostaClient client = new PostaClient("https://posta.example.com", "your-api-key");

        // Send a single email
        SendResponse response = client.sendEmail(new SendEmailRequest()
                .from("sender@example.com")
                .to(List.of("recipient@example.com"))
                .subject("Hello from Posta")
                .html("<h1>Hello!</h1><p>This is a test email.</p>"));
        System.out.println("Email sent! " + response);

        // Send a template email
        SendResponse templateResponse = client.sendTemplateEmail(new SendTemplateEmailRequest()
                .template("welcome")
                .to(List.of("user@example.com"))
                .templateData(Map.of("name", "John")));
        System.out.println("Template email sent! " + templateResponse);

        // Send batch emails
        BatchResponse batchResponse = client.sendBatch(new BatchRequest()
                .template("newsletter")
                .recipients(List.of(
                        new BatchRecipient().email("user1@example.com").templateData(Map.of("name", "Alice")),
                        new BatchRecipient().email("user2@example.com").templateData(Map.of("name", "Bob"))
                )));
        System.out.println("Batch sent! " + batchResponse);

        // Check email status
        EmailStatusResponse status = client.getEmailStatus(response.getId());
        System.out.println("Email status: " + status);
    }
}
