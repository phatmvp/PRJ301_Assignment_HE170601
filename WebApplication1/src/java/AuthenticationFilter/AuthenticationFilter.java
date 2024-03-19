/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuthenticationFilter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Admin
 */

public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Không cần thực hiện gì trong phương thức này
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Lấy URL hiện tại
        String url = httpRequest.getRequestURI();

        // Kiểm tra nếu URL phù hợp với /auth/*
        if (url.startsWith("/auth/")) {
            // Kiểm tra xem người dùng đã xác thực chưa
            if (httpRequest.getSession().getAttribute("username") == null) { // Đây là một ví dụ, bạn có thể thay đổi cách kiểm tra xác thực tùy thuộc vào cách thức xác thực của bạn
                // Chuyển hướng người dùng đến trang đăng nhập
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/view/authentication/login.jsp");
                return;
            }
        }

        // Nếu không phải là URL /auth/* hoặc người dùng đã được xác thực, tiếp tục chuỗi filter
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Không cần thực hiện gì trong phương thức này
    }
}
