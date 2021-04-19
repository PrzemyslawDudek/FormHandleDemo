package pl.dudecode.FormHandleDemo.requestparam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("request_param/")
public class RequestParamController {


    @GetMapping("form_get_method")
    public String formGetMethod(@RequestParam(name="user_name") String userName,
                                @RequestParam(name="user_surname") String userSurname,
                                Model model) {
        model.addAttribute("request_param_get_method_response", userName + " " + userSurname);
        return "index";
    }

    @PostMapping("form_post_method")
    public String formPostMethod(@RequestParam(name="car_brand") String carBrand,
                                 @RequestParam(name="car_model") String carModel,
                                 Model model) {
        model.addAttribute("request_param_post_method_response", carBrand + " " + carModel);
        return "index";
    }

}
