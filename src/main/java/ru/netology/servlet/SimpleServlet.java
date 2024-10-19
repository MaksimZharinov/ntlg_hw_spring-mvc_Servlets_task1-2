package ru.netology.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws IOException {
        var path = req.getRequestURI();
        resp.setContentType("plain/text");
        if (path.matches("/simple/api/posts/\\d+")) {
            resp.getWriter().println("I handled GET request with ID");
        } else if (path.matches("/simple/api/posts")) {
            resp.getWriter().println("I handled GET request");
        }
    }
}
