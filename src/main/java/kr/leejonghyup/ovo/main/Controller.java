package kr.leejonghyup.ovo.main;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {

    private final Service service;

    @GetMapping("/helloworld")
    public String helloworld(Model model) {

        List<Test> getList = service.getList();

        model.addAttribute("name", getList.get(0).getName());
        return "helloworld";
    }
}
