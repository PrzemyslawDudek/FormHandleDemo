package pl.dudecode.FormHandleDemo.modelAttributeWithValues;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("model_attribute_with_values/")
public class ModelAttributeWithValuesController {

    private final ModelAttributeWithValuesService modelAttributeWithValuesService;

    public ModelAttributeWithValuesController(ModelAttributeWithValuesService modelAttributeWithValuesService) {
        this.modelAttributeWithValuesService = modelAttributeWithValuesService;
    }

    @GetMapping("/")
    public String modelAttributeWithValues(Model model) {
        model.addAttribute("emails", modelAttributeWithValuesService.findAllEmails());
        model.addAttribute("email", new Email());
        return "form_with_values";
    }

    @PostMapping("/process")
    public String modelAttributeWithValuesProcess(@ModelAttribute("email") Email email) {
        System.out.println("LOG: Edit email: " + modelAttributeWithValuesService.editEmail(email));
        return "redirect:/model_attribute_with_values/";
    }
}
