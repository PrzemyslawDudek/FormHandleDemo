package pl.dudecode.FormHandleDemo.modelattribute;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("model_attribute/")
public class ModelAttributeController {


    @ModelAttribute("modelAttributeForm")
    public ModelAttributeFormBean getModelAttributeForm() {
        return new ModelAttributeFormBean();
    }

    @GetMapping("/")
    public String modelAttribute() {
        return "index";
    }

    @PostMapping("model_attribute_process")
    public String modelAttributeProcess(@ModelAttribute("modelAttributeForm") ModelAttributeFormBean modelAttributeFormBean,
                                        Model model) {
        String modelAttributeResponse = modelAttributeFormBean.getName() + " "
                + modelAttributeFormBean.getSurname() + " "
                + modelAttributeFormBean.getCity();
        model.addAttribute("model_attribute_response", modelAttributeResponse);
        return "index";
    }

}
