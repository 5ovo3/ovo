package kr.leejonghyup.ovo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/loginCheck")
    @ResponseBody
    public void loginCheck(HttpServletResponse res, HttpSession session, @RequestParam String email, @RequestParam String password) throws IOException {

        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();

        List<User> user = userService.emailCheck(email);
        if (user.size() > 0) {
            if (password.equals(user.get(0).getPassword())) {
                session.setAttribute("login_YN", "Y");
                out.println("<script>location.href = './main' </script>");
            } else {
                out.println("<script>alert('아이디&비밀번호를 확인해주세요.'); location.href = './login' </script>");
            }
        } else {
            out.println("<script>alert('아이디&비밀번호를 확인해주세요.'); location.href = './login' </script>");
        }
        out.flush();
    }


    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/emailCheck")
    @ResponseBody
    public String emailCheck(HttpServletResponse res, @RequestParam String email, Model model) {

        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");

        List<User> user = userService.emailCheck(email);
        if (user.size() > 0) {
            return "N";
        } else {
            return "Y";
        }
    }

    @RequestMapping("/insertUserInfo")
    public String insertUserInfo(HttpServletRequest req) {

        Date date = new Date();

        Map<String, Object> map = new Hashtable<>();
        map.put("email", req.getParameter("email"));
        map.put("password", req.getParameter("password"));
        map.put("name", req.getParameter("name"));
        map.put("tel", "");
        map.put("delete_yn", "N");
        map.put("reg_date", date);

        userService.insertUserInfo(map);
        return "redirect:/login";
    }
}
