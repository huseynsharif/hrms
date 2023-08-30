package kodlamaio.hrms.entities.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EmployeeDto extends BaseUserDto{

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String surname;

    @NotBlank
    @NotNull
    private String identityNumber;

    @NotBlank
    @NotNull
    private int birthyear;

}
