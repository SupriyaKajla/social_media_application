package com.springboot.rest.webservices.restwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Sup K");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Princ", "K"));
	}
	
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getVersionOfPersonRequestParameter() {
		return new PersonV1("Sup K");
	}

	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParameter() {
		return new PersonV2(new Name("Prin", "K"));
	}
	
	@GetMapping(path = "/header/person", headers = "X-version=1")
	public PersonV1 getVersionOfPersonRequestHeader() {
		return new PersonV1("Sup K");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/com.app-v1+json")
	public PersonV1 getVersionOfPersonAcceptHeader() {
		return new PersonV1("Sup K");
	}
}
