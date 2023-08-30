package kodlamaio.hrms.entities.dtos;

import lombok.Data;

@Data
public class EmployerDto extends BaseUserDto{

    private String companyName;

    private String website;

    private String phoneNumber;
}
