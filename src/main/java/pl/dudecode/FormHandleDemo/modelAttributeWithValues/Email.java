package pl.dudecode.FormHandleDemo.modelAttributeWithValues;

import lombok.Data;

@Data
public class Email {
    private long id;
    private String label;
    private String email;
    private boolean active;
}
