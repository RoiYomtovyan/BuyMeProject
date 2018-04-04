import java.util.UUID;

// this class (that was found in Stack overflow site is generate string with random characters.
// i am calling this method in the email address field in order to generate unique email address for each test run.
public class RandomStringGenerator {
    public static String generateString() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").replaceAll("=","");
        return  uuid;
    }

}



