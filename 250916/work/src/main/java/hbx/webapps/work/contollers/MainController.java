package hbx.webapps.work.contollers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
public final class MainController {

    @GetMapping("/")
    public String root() {
        return "진흑탕입니다.";
    }


}
