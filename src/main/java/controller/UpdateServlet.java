package controller;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/update")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserService.getInstance();
        HttpSession session = request.getSession();
        String button = request.getParameter("button");

        if (button.equals("update")) {
            long id = Long.parseLong(request.getParameter("id"));
            User user = userService.getUser(id);
            session.setAttribute("userById", user);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = UserService.getInstance();
        request.setCharacterEncoding("UTF-8");
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String password = request.getParameter("password");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String mobile = request.getParameter("mobile");
        User user = new User(id, name, role, password, login, email, country, mobile);
        userService.update(user);
        response.sendRedirect("/admin");
    }
}