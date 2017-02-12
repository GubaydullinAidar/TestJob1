import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        public class ipTransfer {
     public static void main(String[] args) throws IOException
     {

                       BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Введите начальный IP: ");
                String ipAdrStart=reader.readLine();
                long i=ipToInt(ipAdrStart);
                System.out.println("Введите конечный IP: ");
                String ipAdrEnd= reader.readLine();
                long j=ipToInt(ipAdrEnd);
                System.out.println("Допустимые адреса: ");
                while (i<j-1)
                    {
                                i++;
                    System.out.println(intToIp(i));
                }

                    }

            public static long ipToInt(String ip)
     {
                String[] ipStr = ip.split("\\D+");
                return (Long.valueOf(ipStr[0]) << 24) +
                                (Long.valueOf(ipStr[1]) << 16) +
                                (Long.valueOf(ipStr[2]) << 8) +
                                (Long.valueOf(ipStr[3]));

                    }

            public static String intToIp(long value)
     {
                StringBuffer sb = new StringBuffer();
                sb.append((value & 0xFF000000) >> 24).append('.');
                sb.append((value & 0x00FF0000) >> 16).append('.');
                sb.append((value & 0x0000FF00) >> 8).append('.');
                sb.append(value & 0x000000FF);
                return sb.toString();
            }
 }