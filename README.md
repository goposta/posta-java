# Posta Java Client

A lightweight Java client for the [Posta](https://github.com/goposta/posta) email API.

## Requirements

- Java 11+
- Jackson Databind

## Installation

### Maven

Add the JitPack repository to your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Then add the dependency:

```xml
<dependency>
    <groupId>com.github.goposta</groupId>
    <artifactId>posta-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.goposta:posta-java:1.0.0'
}
```

## Usage

```java
import com.github.goposta.posta.*;

PostaClient client = new PostaClient("https://posta.example.com", "your-api-key");
```

### Send Email

```java
SendResponse response = client.sendEmail(new SendEmailRequest()
    .from("sender@example.com")
    .to(List.of("recipient@example.com"))
    .subject("Hello")
    .html("<h1>Hello World</h1>"));
// response.getId(), response.getStatus()
```

### Send Template Email

```java
SendResponse response = client.sendTemplateEmail(new SendTemplateEmailRequest()
    .template("welcome")
    .to(List.of("user@example.com"))
    .templateData(Map.of("name", "John")));
```

### Send Batch Emails

```java
BatchResponse response = client.sendBatch(new BatchRequest()
    .template("newsletter")
    .recipients(List.of(
        new BatchRecipient().email("alice@example.com").templateData(Map.of("name", "Alice")),
        new BatchRecipient().email("bob@example.com").templateData(Map.of("name", "Bob"))
    )));
// response.getTotal(), response.getSent(), response.getFailed()
```

### Get Email Status

```java
EmailStatusResponse status = client.getEmailStatus("email-uuid");
// status.getStatus(), status.getRetryCount()
```

### Error Handling

```java
try {
    client.sendEmail(request);
} catch (PostaException e) {
    System.out.println(e.getStatusCode()); // HTTP status code
    System.out.println(e.getMessage());    // Error message
}
```

## Contributing

Contributions are welcome! Please open an issue to discuss proposed changes before submitting a pull request.

## License

This project is licensed under the Apache License 2.0. See [LICENSE](LICENSE) for details.

---

## Copyright

Copyright © 2026 Jonas Kaninda

</div>