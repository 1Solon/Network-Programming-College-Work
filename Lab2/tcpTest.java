import java.net.*;

class testTCPIP{
    public static void main(String[] args) {
        
        testService("http://www.dit.ie");
        testService("https://www.dit.ie");
        testService("ftp://dit.ie");
        testService("mailto:aneel.rahim@dit.ie");

    }

    public static void testService(String url) {
        try {

            URL u = new URL(url);
            System.out.println(u.getProtocol() + " is supported");

        } catch (Exception e) {

            System.out.println(url + " is not supported");

        }
    }
}