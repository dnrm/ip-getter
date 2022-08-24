import java.net.InetAddress;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner numberScanner = new Scanner(System.in);

        System.out.println("""
                                                                              \s
                ,--.                              ,--.    ,--.                \s
                `--' ,---. ,-----. ,---.  ,---. ,-'  '-.,-'  '-. ,---. ,--.--.\s
                ,--.| .-. |'-----'| .-. || .-. :'-.  .-''-.  .-'| .-. :|  .--'\s
                |  || '-' '       ' '-' '\\   --.  |  |    |  |  \\   --.|  |   \s
                `--'|  |-'        .`-  /  `----'  `--'    `--'   `----'`--'   \s
                    `--'          `---'                                       \s
                """);
        System.out.println("Give me a website URL and I'll give you back the hostname :)");

        System.out.print("URL: ");
        String link = numberScanner.nextLine();

        // * Split string into array to then get hostname
        String[] linkParts = link.split("/");

        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        if (!link.matches(regex)) {
            System.out.println("Invalid URL");
            System.exit(0);
        }

        System.out.println("Hostname: " + linkParts[2]);

        System.out.println("Getting IP address...");

        try {
            // * Get IP address from hostname
            InetAddress address = InetAddress.getByName(linkParts[2]);
            System.out.println("IP address: " + address.toString().split("/")[1]);
        } catch (Exception e) {
            System.out.println("Error: " + e.hashCode());
            System.out.println("Unable to find IP address :c");
        }

        numberScanner.close();
    }
}