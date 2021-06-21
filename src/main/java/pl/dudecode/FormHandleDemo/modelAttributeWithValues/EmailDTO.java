package pl.dudecode.FormHandleDemo.modelAttributeWithValues;

import lombok.Data;

@Data
public class EmailDTO {
    private long id;
    private String label;
    private String email;
    private boolean active;
}
