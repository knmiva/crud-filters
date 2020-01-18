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

@WebServlet(urlPatterns = "/sign_in")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null)
            request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = UserService.getInstance();
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userService.getUserByLogin(login);
        if (user != null && password.equals(user.getPassword())) {
            if (user.getRole().equals("user")) {
                session.setAttribute("user", user);
                response.sendRedirect("/user");
            } else {
                session.setAttribute("user", user);
                response.sendRedirect("/admin");
            }
        } else {
            response.sendRedirect("/sign_in");
        }
    }
}
