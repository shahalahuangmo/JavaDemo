package com.example.demo.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 多次读写BODY用HTTP RESPONSE - 解决流只能读一次问题
 */
public class MultiReadHttpServletResponse  extends HttpServletResponseWrapper {
    // ByteArrayOutputStream 对byte类型数据进行写入的类 相当于一个中间缓冲层，
    // 将类写入到文件等其他outputStream。它是对字节进行操作，属于内存操作流
    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private HttpServletResponse response;

    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @param response The response to be wrapped
     * @throws IllegalArgumentException if the response is null
     */
    public MultiReadHttpServletResponse(HttpServletResponse response) {
        super(response);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        this.response = response;
    }

    public byte[] getBody()
    {
        return  byteArrayOutputStream.toByteArray();
    }

    @Override
    public ServletOutputStream getOutputStream()
    {
        return  new ServletOutputStreamWrapper(this.byteArrayOutputStream,this.response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(new OutputStreamWriter(getOutputStream(), this.response.getCharacterEncoding()));
    }

    @Data
    @AllArgsConstructor
    private  static  class ServletOutputStreamWrapper extends ServletOutputStream
    {
        private ByteArrayOutputStream outputStream;
        private HttpServletResponse response;

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setWriteListener(WriteListener listener) {

        }

        @Override
        public void write(int b) throws IOException {
            this.outputStream.write(b);
        }

        @Override
        public void flush() throws IOException {
            if (!this.response.isCommitted()) {
                byte[] body = this.outputStream.toByteArray();
                ServletOutputStream outputStream = this.response.getOutputStream();
                outputStream.write(body);
                outputStream.flush();
            }
        }
    }
}
