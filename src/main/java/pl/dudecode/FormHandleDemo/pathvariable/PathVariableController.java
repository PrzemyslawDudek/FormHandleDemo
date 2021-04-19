package pl.dudecode.FormHandleDemo.pathvariable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("path_variable/")
public class PathVariableController {

    @GetMapping("example/{path_variable}")
    public String pathVariableExample(@PathVariable(name="path_variable") String pathVariable, Model model) {
        model.addAttribute("path_variable_response", pathVariable);
        return "index";
    }
}
