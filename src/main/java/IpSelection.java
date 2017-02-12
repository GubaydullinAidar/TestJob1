import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IpSelection {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Начальное значение IP :");
        String startIp = reader.readLine();
        System.out.println("Конечное значение IP :");
        String finishIp = reader.readLine();
        int[] startIpArr = arrToInt(startIp);
        int[] finishIpArr = arrToInt(finishIp);
        for (int i = 0; i < startIpArr.length; i++) {
            while (startIpArr[i] < finishIpArr[i]) {
                iterIp(startIpArr, i, finishIpArr);
                startIpArr[i]++;

            }
        }
    }

    public static void iterIp(int[] firstIp, int index, int[] secondIp) {
        for (int i = 3; i > index; i--) {
            while(firstIp[i] < 255) {
                firstIp[i]++;
                System.out.println(resultIp(firstIp));
            }

            firstIp[i] = -1;
        }
        if (index == 3) {
            while (firstIp[3] < secondIp[3] - 1) {
                firstIp[3]++;
                System.out.println(resultIp(firstIp));
            }
        }
    }

    public static int[] arrToInt(String ip) {
        String[] ipToStr = ip.split("\\D+");
        int[] ipToInt = new int[ipToStr.length];
        for (int i = 0; i < ipToStr.length; i++) {
            ipToInt[i] = Integer.parseInt(ipToStr[i]);
        }
        return ipToInt;
    }

    public static String resultIp(int[] first)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(first[0]).append('.');
        sb.append(first[1]).append('.');
        sb.append(first[2]).append('.');
        sb.append(first[3]);
        return sb.toString();
    }
}