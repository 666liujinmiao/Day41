package com.dfbz.day41;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println("得到请求的方式：" + req.getMethod() + "<br>");
        pw.println("得到请求的URI：" + req.getRequestURI() + "<br>");
        pw.println("得到请求的URL：" + req.getRequestURL() + "<br>");
        pw.println("得到请求的协议和版本：" + req.getProtocol() + "<br>");
        pw.println("得到当前项目的访问地址：" + req.getContextPath() + "<br>");
        pw.println("得到客户端的IP地址：" + req.getRemoteAddr() + "<br>");
        pw.println("得到当前servlet的访问地址：" + req.getServletPath() + "<br>");
        pw.println("=========================<br>");
        pw.println("得到host的值：" + req.getHeader("host") + "<br>");

        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            pw.println(header + "====" + req.getHeader(header)+"<br>");
        }
    }

}
