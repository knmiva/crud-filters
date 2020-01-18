package controller;

import model.User;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/create")
public class CreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = UserService.getInstance();
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String password = request.getParameter("password");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String mobile = request.getParameter("mobile");
        User user = new User(name, role, password, login, email, country, mobile);
        userService.addUser(user);
        response.sendRedirect("/admin");
    }
}