package tw.brad.tutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad11")
public class Brad11 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");

        // 假設您已經有驗證用戶名和密碼的邏輯
        if (isValidUser(username, password)) {
            // 用戶認證成功
            
            // 如果選中了 "Remember Me"
            if ("true".equals(rememberMe)) {
                // 創建一個 cookie，保存用戶名
                Cookie cookie = new Cookie("username", username);
                // 設置 cookie 的過期時間，例如 7 天（秒為單位）
                cookie.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(cookie);

                
            }else {
                Cookie cookie = new Cookie("username", username);
                // 設置 cookie 的過期時間，馬上
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                
                request.getSession().setAttribute("user", username);
            }
            // 重定向到主頁
            response.sendRedirect("brad12.jsp");

        } else {
            // 認證失敗，返回到登入頁面
            response.sendRedirect("brad11.html");
        }		
	}
    private boolean isValidUser(String username, String password) {
        // 這裡應該有您驗證用戶的邏輯，例如查詢資料庫
        return "admin".equals(username) && "password".equals(password);
    }
}
