package com.Password.Generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class PasswordController {

	@Autowired
	private PasswordService passwordService;

	// Muestra la página index.html
	@GetMapping("/")
	public String showIndex() {
		return "index";
	}

	@GetMapping("/generate")
	public String generatePassword(@RequestParam(defaultValue = "12") int length,
			@RequestParam(defaultValue = "true") boolean includeUpper,
			@RequestParam(defaultValue = "true") boolean includeLower,
			@RequestParam(defaultValue = "true") boolean includeNumbers,
			@RequestParam(defaultValue = "false") boolean includeSymbols, Model model) {

		String password = passwordService.generatePassword(length, includeUpper, includeLower, includeNumbers,
				includeSymbols);
		model.addAttribute("password", password);
		return "index";
	}
}
