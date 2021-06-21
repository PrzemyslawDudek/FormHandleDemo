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
    String modelAttributeWithValues(Model model) {
        model.addAttribute("emails", modelAttributeWithValuesService.findAllEmails());
        model.addAttribute("emailDto", new EmailDTO());
        return "form_with_values";
    }


    @PostMapping("/process")
    String modelAttributeWithValuesProcess(@ModelAttribute("emailDto") EmailDTO emailDTO) {
        Email email = modelAttributeWithValuesService.editEmail(emailDTO);
        System.out.println("LOG: Edit email: " + email);
        return "redirect:/model_attribute_with_values/";
    }
}
