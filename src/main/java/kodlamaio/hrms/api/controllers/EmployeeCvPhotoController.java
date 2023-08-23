package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployeeCvPhotoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.EmployeeCvPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/employeeCvPhoto")
@CrossOrigin
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

    @GetMapping("/findbyid")
    public DataResult<EmployeeCvPhoto> findEmployeeCvPhotoById(int id){
        return this.employeeCvPhotoService.findEmployeeCvPhotoById(id);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.employeeCvPhotoService.getAll());
    }
}
