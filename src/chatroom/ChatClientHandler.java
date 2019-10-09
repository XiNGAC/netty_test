package chatroom;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ChatClientHandler extends SimpleChannelInboundHandler<String> {
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        //输出消息
        System.out.println(s);
    }
}
