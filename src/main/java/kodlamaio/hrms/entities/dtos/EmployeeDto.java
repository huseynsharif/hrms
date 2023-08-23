package kodlamaio.hrms.entities.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EmployeeDto {

    private String email;

    private String password;

    private String cPassword;

    @NotBlank
    @NotNull
    private String firstName;

    @NotBlank
    @NotNull
    private String lastName;

    @NotBlank
    @NotNull
    private String identityNumber;

    @NotBlank
    @NotNull
    private String birthOfYear;

}
