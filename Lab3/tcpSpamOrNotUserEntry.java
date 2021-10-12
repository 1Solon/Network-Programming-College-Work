import java.net.*;
import java.io.Console;

class tcpSpamOrNotUserEntry{
    public static void main(String[] args) {

        //Creates a console session and grabs user entry
        Console console = System.console();
        char[] userInput = console.readLine("Enter an IP address: ").toCharArray();

        //Shifts around the characters a little bit
        char[] tmp = new char[9];
        tmp[0] = userInput[8];
        tmp[1] = userInput[7];
        tmp[2] = userInput[6];
        tmp[3] = userInput[5];
        tmp[4] = userInput[4];
        tmp[5] = userInput[3];
        tmp[6] = userInput[0];
        tmp[7] = userInput[1];
        tmp[8] = userInput[2];
        String IP = String.valueOf(tmp);

        //Determines if spam or not
        String website = ".sbl.spamhaus.org";
        try {
            String query = IP + website;
            InetAddress.getByName(query);
            System.out.println(IP + " is a known spammer.");

        } catch (Exception e) {
            System.out.println(IP + " appears legitimate");
            
        }
    }
}