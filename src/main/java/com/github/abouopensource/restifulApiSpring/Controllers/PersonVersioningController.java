package com.github.abouopensource.restifulApiSpring.Controllers;


import com.github.abouopensource.restifulApiSpring.Models.Name;
import com.github.abouopensource.restifulApiSpring.Models.PersonV1;
import com.github.abouopensource.restifulApiSpring.Models.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

@GetMapping("v1/person")
    public PersonV1 personV1(){
    return new PersonV1(new Name("SANOU","Abou  "));
}


    @GetMapping("v2/param")
    public PersonV2 personV2(){
        return new PersonV2("SANOU V2");
    }


@GetMapping(value = "person/param",params = "version=2")
    public PersonV2 paramnV2(){
    return new PersonV2("SANOU V2");
}


    @GetMapping(value = "person/param", params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1(new Name("SANOU","Abou  "));
    }



    @GetMapping(value = "person/header",headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2("SANOU V2");
    }


    @GetMapping(value = "person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1(new Name("SANOU","Abou "));
    }



    @GetMapping(value = "person/produces",produces = "application/vnd.company.app-v2+json")
    public PersonV2 producerV2(){
        return new PersonV2("SANOU V2");
    }


    @GetMapping(value = "person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producerV1(){
        return new PersonV1(new Name("SANOU","Abou "));
    }
}
