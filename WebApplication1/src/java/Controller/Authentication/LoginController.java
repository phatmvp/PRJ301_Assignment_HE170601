/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Authentication;

import dal.AccountDBContext;
import dal.LecturerDBContext;
import entity.Account;
import entity.Lecturer;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/authentication/login.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountDBContext db = new AccountDBContext();
        Account account = db.getByUsernamePassword(username, password);
        LecturerDBContext lect = new LecturerDBContext();
        ArrayList<Lecturer> lecturers = lect.list();

        if (account != null) {
            //login success

            String remember = request.getParameter("remember");
            if (remember != null) {
                Cookie c_user = new Cookie("username", username);
                Cookie c_pass = new Cookie("password", password);

                c_user.setMaxAge(3600 * 24 * 7);
                c_pass.setMaxAge(3600 * 24 * 7);

                response.addCookie(c_pass);
                response.addCookie(c_user);
            }
            int lidToUse = -1; // Giá trị mặc định
            for (Lecturer lecturer : lecturers) {
                if (lecturer.getName().equals(account.getUsername())) {
                    lidToUse = lecturer.getId();
                    break;
                }
            }

            if (lidToUse != -1) {
                HttpSession session = request.getSession();
                session.setAttribute("account", account);
                response.sendRedirect("lecturer/timetable?id=" + lidToUse);
            } else {
                response.getWriter().print("you do not have access");
            }

        } else {
            //login failed!
            response.getWriter().println("login failed!");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
