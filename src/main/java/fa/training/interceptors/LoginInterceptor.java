package fa.training.interceptors;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object object = request.getSession().getAttribute("userLogged");
        if(object == null ){
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        return true;
    }
}
