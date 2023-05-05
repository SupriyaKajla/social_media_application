package com.springboot.rest.webservices.restwebservices.internationlized;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternationlizedController {
	
private MessageSource messageSource;
	
	public InternationlizedController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@GetMapping ("/internationalized")
	public String getInternationlizedResponse() {
		
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "default message", locale ) ;
	}

}
