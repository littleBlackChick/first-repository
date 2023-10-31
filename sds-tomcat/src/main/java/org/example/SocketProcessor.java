package org.example;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketProcessor implements Runnable{

    private Socket socket;

    public SocketProcessor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        processSocket(socket);
    }

    private void processSocket(Socket socket) {
        //处理socket连接 读数据 写数据

        try {
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            inputStream.read(bytes);
            System.out.println(bytes);
            //解析字节流 遇到一个空格就退出
            int pos =0;
            int begin =0,end =0;
            for (;pos<bytes.length;pos++,end++){
                if(bytes[pos]==' ')break;
            }

            //组合空格之前的字节流 转换成字符串就是请求方法
            StringBuffer method = new StringBuffer();
            for(;begin<end;begin++){
                method.append((char)bytes[begin]);
            }
            //解析url
            pos++;
            begin++;
            end++;
            for(;pos<bytes.length;pos++,end++){
                if(bytes[pos]=='\r')break;
            }
            StringBuilder url = new StringBuilder();
            if(;begin < end;begin++){
                url.append((char)bytes[begin]);
            }
            System.out.println(url.toString());
           //解析协议版本
            pos++;
            begin++;
            end++;
            for(;pos<bytes.length;pos++,end++){
                if(bytes[pos]=='\r')break;
            }
            StringBuilder protocl = new StringBuilder();
            if(;begin < end;begin++){
                protocl.append((char)bytes[begin]);
            }
            System.out.println(protocl.toString());


            Request request = new Request(method.toString(), url.toString(), protocl.toString());
            Response response = new Response();

            Servlet servlet = new Servlet();
            servlet.service(request,response);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }
}
