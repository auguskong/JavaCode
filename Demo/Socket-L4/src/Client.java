import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class Client {
    private static final int PORT = 20000;
    private static final int LOCAL_PORT = 20001;

    public static void main(String[] args) throws IOException {
        Socket socket = createSocket();

        initSocket(socket);

        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), PORT), 3000);
        System.out.println("已发起服务器连接, 并进入后续流程");
        System.out.println("客户端信息: " + socket.getLocalAddress() + " P:" + socket.getLocalPort());
        System.out.println("服务端信息: " + socket.getInetAddress() + " P:" + socket.getPort());

        try {
            // 发送
            todo(socket);
        } catch (Exception e) {
            System.out.println("异常关闭");
        }

        socket.close();
        System.out.println("客户端已退出");
    }

    private static Socket createSocket() throws IOException {

        /*
        // 无代理模式
        Socket socket = new Socket(Proxy.NO_PROXY);

        // 新建一个具有HTTP代理的套接字, 传输数据通过www.baidu.com:8080 端口转发
        Proxy proxy = new Proxy(Proxy.Type.HTTP,
                new InetSocketAddress(Inet4Address.getByName("www.baidu.com"), 8800));
        socket = new Socket(proxy);

        // 新建一个套接字，并直接连接到本地20000服务器
        socket = new Socket("localhost", PORT);

        // 新建套接字, 直接连接到本地20000的服务器上, 并且绑定到本地20001端口
        socket = new Socket("localhost", PORT, Inet4Address.getLocalHost(), LOCAL_PORT);
        */

        Socket socket = new Socket();
        socket.bind(new InetSocketAddress(Inet4Address.getLocalHost(), LOCAL_PORT));

        return socket;
    }

    private static void initSocket(Socket socket) throws SocketException {
        // 设置读取超时时间为2秒
        socket.setSoTimeout(3000);

        // 是否复用未完全关闭的Socket地址, 对于指定bind操作后的套接字有效
        socket.setReuseAddress(true);

        // 是否需要在长时间无数据响应时发送确认数据，时间大约两小时
        socket.setKeepAlive(true);

        //
    }

    private static void todo(Socket client) throws IOException {

        // 得到键盘输入流
        InputStream in = System.in;
        BufferedReader input = new BufferedReader(new InputStreamReader(in));

        // 得到Socket输出流, 并转换为打印流
        OutputStream outputStream = client.getOutputStream();
        PrintStream socketPrintStream = new PrintStream(outputStream);

        // 得到Socket输入流, 并转换为BufferedReader
        InputStream inputStream = client.getInputStream();
        BufferedReader socketBufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        boolean flag = true;
        do {

            //从键盘读取一行
            String str = input.readLine();
            socketPrintStream.println(str);

            // 从服务器读取一行
            String echo = socketBufferedReader.readLine();
            if ("bye".equalsIgnoreCase(echo)) {
                flag = false;
            } else {
                System.out.println(echo);
            }
        } while (flag);
    }
}
