package tw.brad.tutor;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class MyFilter extends HttpFilter{

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
        // 獲取所有 cookies
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    String username = cookie.getValue();
                    // 檢查 cookie 中的用戶名是否有效
                    if (isValidUsername(username)) {
                        // 自動登入用戶
                    	req.getSession().setAttribute("user", username);
                    }
                }
            }
        }

        chain.doFilter(req, res);		
		
	}
    private boolean isValidUsername(String username) {
        // 這裡應該有您驗證用戶的邏輯，例如查詢資料庫
        return "admin".equals(username);
    }

}
