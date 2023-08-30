package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.BaseUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class BaseUserController {

    private BaseUserService baseUserService;

    @GetMapping("/findbyemail")
    public ResponseEntity<?> findByEmail(String email, String password){
        return ResponseEntity.ok(this.baseUserService.findByEmail(email, password));
    }

}
