package kr.leejonghyup.ovo.main;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService service;

    @GetMapping("/main")
    public String main(HttpSession session, Model model) {

        model.addAttribute("name", session.getAttribute("user_name"));
        return "main";
    }
}
