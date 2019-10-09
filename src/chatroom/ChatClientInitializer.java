package chatroom;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


public class ChatClientInitializer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("frame",new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        pipeline.addLast("decode",new StringDecoder());//解码器
        pipeline.addLast("encode",new StringEncoder());
//        pipeline.addLast("decoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
//        pipeline.addLast("encoder", new LengthFieldPrepender(4, false));
        pipeline.addLast("handler",new ChatClientHandler());
    }
}
