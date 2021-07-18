package pl.dudecode.FormHandleDemo.checkbox;

import lombok.Data;

@Data
public class FormWithCheckbox {
    private boolean checkbox;

    public FormWithCheckbox() {
        checkbox = true;
    }
}
