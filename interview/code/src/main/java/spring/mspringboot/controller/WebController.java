package spring.mspringboot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.mspringboot.facade.WebFacade;

@RestController
public class WebController {

    @Autowired
    private WebFacade webFacade;

    @GetMapping("/")
    public ResponseEntity<String> isAvailable() {
        return new ResponseEntity<>("hi", HttpStatus.OK);
    }

    @GetMapping("/testthread")
    public ResponseEntity<String> testThread() {
        this.webFacade.testSync();
        return new ResponseEntity<>("response "+ new Date(), HttpStatus.OK);
    }

    @GetMapping("/testauthorization")
    public ResponseEntity<String> testAuthorization() {
        this.webFacade.testAuthorization();
        return new ResponseEntity<>("response "+ new Date(), HttpStatus.OK);
    }

}
