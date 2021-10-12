import java.net.*;

class tcpSpamOrNot{
    public static void main(String[] args) {
        String IP = "2.0.0.127";
        String website = ".sbl.spamhaus.org";
        String query;

        try {
            query = IP + website;
            InetAddress.getByName(query);
            System.out.println(IP + " is a known spammer.");

        } catch (Exception e) {
            System.out.println(IP + " appears legitimate");
            
        }
    }
}