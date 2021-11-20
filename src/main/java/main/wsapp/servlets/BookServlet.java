package main.wsapp.servlets;



import main.wsapp.db.MyDBFake;
import main.wsapp.models.Library;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "bookServlet", value = "/bookservlet")
public class BookServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        Library dbFake = MyDBFake.getDbFake();
        String message =(String) request.getAttribute("message");
        request.setAttribute("library", dbFake.getContent());
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/view/BookView.jsp");
        dispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }
}
