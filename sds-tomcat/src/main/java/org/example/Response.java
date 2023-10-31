package org.example;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.Map;

public class Response extends AbstractHttpServletResponse{

    private int status =200;
    private String message ="OK";
    private Map<String,String> headers;

    @Override
    public void addHeader(String s, String s1) {
        headers.put(s,s1);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return super.getOutputStream();
    }

    @Override
    public void setStatus(int i, String s) {
        status =i;
        message =s;
    }

    @Override
    public int getStatus() {
        return status;
    }
}
