package pl.dudecode.FormHandleDemo.checkbox;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("form_with_checkbox/")
public class FormWithCheckboxController {

    private final FormWithCheckbox FORM_WITH_CHECKBOX = new FormWithCheckbox();

    private String RESPONSE;

    @ModelAttribute("formWithCheckbox")
    public FormWithCheckbox getFormWithCheckbox() {
        return FORM_WITH_CHECKBOX;
    }

    @ModelAttribute("response")
    public String response() {
        return RESPONSE;
    }

    @GetMapping("/")
    public String getSiteWithCheckboxForm() {
        return "form_with_checkbox";
    }

    @PostMapping("/process_model_form")
    public String processModelForm(@ModelAttribute("formWithCheckbox") FormWithCheckbox formWithCheckbox) {
        RESPONSE = "Checkbox value: " + FORM_WITH_CHECKBOX.isCheckbox();
        return "redirect:/form_with_checkbox/";
    }

    @PostMapping("/process_request_param_form")
    public String processRequestParamForm(@RequestParam(name = "checkbox", required = false, defaultValue = "false") boolean checkbox) {
        FORM_WITH_CHECKBOX.setCheckbox(checkbox);
        RESPONSE = "Checkbox value: " + FORM_WITH_CHECKBOX.isCheckbox();
        return "redirect:/form_with_checkbox/";
    }

    @PostMapping("/process_model_form_with_values")
    public String processRequestParamForm(@ModelAttribute("formWithCheckbox") FormWithCheckbox formWithCheckbox) {
        RESPONSE = "Checkbox value: " + FORM_WITH_CHECKBOX.isCheckbox();
        return "redirect:/form_with_checkbox/";
    }

}
