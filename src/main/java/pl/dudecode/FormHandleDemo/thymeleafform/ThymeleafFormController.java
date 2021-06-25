package pl.dudecode.FormHandleDemo.thymeleafform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thymeleaf_form/")
public class ThymeleafFormController {

    private final static ThymeleafForm thymeleafForm = new ThymeleafForm();

    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("thymeleafForm", thymeleafForm);
        return "thymeleaf_form";
    }

    @PostMapping("process_form")
    public String processForm(@ModelAttribute("thymeleafForm") ThymeleafForm thymeleafForm) {
        ThymeleafFormController.thymeleafForm.setName(thymeleafForm.getName());
        ThymeleafFormController.thymeleafForm.setActive(thymeleafForm.isActive());
        return "redirect:/thymeleaf_form/";
    }
}
