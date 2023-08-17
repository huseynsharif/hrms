package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployeeCvPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/employeeCvPhoto")
public class EmployeeCvPhotoController {

    private EmployeeCvPhotoService employeeCvPhotoService;

    @Autowired
    public EmployeeCvPhotoController(EmployeeCvPhotoService employeeCvPhotoService) {
        this.employeeCvPhotoService = employeeCvPhotoService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestParam("photo") MultipartFile photo) throws IOException {

        return ResponseEntity.ok(this.employeeCvPhotoService.add(photo));

    }


}
