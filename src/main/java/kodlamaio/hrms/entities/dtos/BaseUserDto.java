package kodlamaio.hrms.entities.dtos;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class BaseUserDto {

    @Email
    private String email;

    private String password;

    private String cPassword;

}
