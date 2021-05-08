package spring.springbootweb.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        this.webFacade.testThread();
        return new ResponseEntity<>("response "+ new Date(), HttpStatus.OK);
    }
}
