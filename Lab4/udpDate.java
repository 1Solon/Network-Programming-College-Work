import java.net.InetAddress;
import org.apache.commons.net.daytime.DaytimeUDPClient;
class udpDate {
    public static void main(String[] args) {
        try {
            DaytimeUDPClient client = new DaytimeUDPClient();
            InetAddress address = InetAddress.getByName("time.nist.gov");
            client.setDefaultTimeout(60000);
            client.open();
            System.out.println("Getting the Date from UDP Server");
            System.out.println(client.getTime(address,13).substring(0,2));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}