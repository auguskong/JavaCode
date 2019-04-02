interface IMessage {
    public void send();
}

public class TestProxy {
    public static void main(String[] args) throws Exception {
        IMessage msg = new MessageProxy(new MessageReal());
        msg.send();
    }
}
class MessageReal implements IMessage {
    @Override
    public void send() {
        System.out.println("发送消息 来自MessageReal");
    }
}


class MessageProxy implements IMessage {
    private IMessage message; //代理对象,一定是业务接口实例
    pulic MessageProxy(IMessage message) {
        this.message = message;
    }
    @Override
    public void send() {
        if (this.connect()) {
            this.message.send();
            this.close();
        }
    }

    public boolean connect() {
        System.out.println("进行消息发送通道的链接");
        return true;
    }

    public void close() {
        System.out.println("关闭消息通道");
    }
}