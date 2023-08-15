package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/universities")
public class UniversityController {

    private UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){

        return ResponseEntity.ok(this.universityService.getAll());

    }

    @GetMapping("/getbyid")
    public ResponseEntity<?> getById(@RequestParam int id){

        return ResponseEntity.ok(this.universityService.getById(id));

    }


}
