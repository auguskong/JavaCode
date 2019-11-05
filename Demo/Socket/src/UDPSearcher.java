import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSearcher {

    public static void main(String[] args) throws IOException {
        System.out.println("UDPSearcher Started");

        // 搜索方 无需指定端口 系统自动分配
        DatagramSocket ds = new DatagramSocket();

        // 构建请求实体
        String requestData = "Hello from UDPSearch";
        byte[] requestDataBytes = requestData.getBytes();

        DatagramPacket requestPacket = new DatagramPacket(requestDataBytes,
                requestDataBytes.length);

        // 本机20000 端口
        requestPacket.setAddress(InetAddress.getLocalHost());
        requestPacket.setPort(20000);

        // 发送
        ds.send(requestPacket);

        // 构建接收实体
        final byte[] buf = new byte[512];
        DatagramPacket receivePack = new DatagramPacket(buf, buf.length);

        // 接收
        ds.receive(receivePack);
        String ip = receivePack.getAddress().getHostAddress();
        int port = receivePack.getPort();
        int dataLen = receivePack.getLength();
        String data = new String(receivePack.getData(), 0, dataLen);
        System.out.println("UDPSearcher receive from ip:" + ip + "\tports: " + port + "\tdata:" + data);

        // 完成
        System.out.println("UDPSearcher Finished");
        ds.close();
    }


}
