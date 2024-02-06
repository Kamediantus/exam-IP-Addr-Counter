package earth.rodichev;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(getUniqIp4vAddressesTest(System.getProperty("file.to.count")));
    }

    public static long getUniqIp4vAddressesTest(String filePath) {
        Set<Integer> uniqIps = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                uniqIps.add(ipToIntTest(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uniqIps.size();
    }

    private static int ipToIntTest(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        int ipNum = 0;
        for (int i = 0; i < 4; i++) {
            ipNum = ipNum << 8;
            ipNum |= Integer.parseInt(parts[i]);
        }
        return ipNum;
    }
}
