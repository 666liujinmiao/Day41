package com.dfbz.day41;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    //依赖于业务类
    private UserImp userImp=new UserImp();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到用户名和密码
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        if (name == null || password == null) {
            return;
        }
        //调用业务层登录的方法实现登录
        User login=userImp.login(name,password);
        /*
        如果UserDao类的findUser方法不捕捉DataAccessException，
        当login为null时，将会抛出EmptyResultDataAccessException异常，
        下面代码将不执行
        * */
        if(login!=null){
            request.setAttribute("msg","恭喜登录成功！");
            request.getRequestDispatcher("/success.jsp").forward(request,response);
//            response.sendRedirect("success.jsp");
        }else{
            //登录失败，重定向到失败页面
            response.sendRedirect("fail.jsp");
        }

    }
}
