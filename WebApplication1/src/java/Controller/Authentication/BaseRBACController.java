/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Authentication;

import dal.RoleDBContext;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public abstract class BaseRBACController extends BaseRequiredAuthenticationController {

    private ArrayList<entity.Role> getRoles(HttpServletRequest req, Account account) {
        String url = req.getServletPath();
        RoleDBContext db = new RoleDBContext();
        return db.getByUsernameAndUrl(account.getUsername(), url);
    }

    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<entity.Role> roles)
            throws ServletException, IOException;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        ArrayList<entity.Role> roles = getRoles(req, account);
        if (roles.size() < 1) {
            resp.getWriter().println("access denied!");
        } else {
            doPost(req, resp, account, roles);
        }
    }

    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp, Account account, ArrayList<entity.Role> roles)
            throws ServletException, IOException;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        ArrayList<entity.Role> roles = getRoles(req, account);
        if (roles.size() < 1) {
            resp.getWriter().println("access denied!");
        } else {
            doGet(req, resp, account, roles);
        }
    }
}
