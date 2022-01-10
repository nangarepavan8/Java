package com.example.demo.Controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



import com.example.demo.entity.LoginData;

@Controller
public class MyController {
	
	
	@GetMapping("/form")
//	@PostMapping("/form")
	public String openForm(Model  model)
	{
		System.out.println("Opening Form");
		
		model.addAttribute("logindata", new LoginData() );
		return "form";
	}
	
	
	// handeler for processsing form
	
	//@RequestMapping("/process")
	@PostMapping("/process")
	public String processForm (@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result)
	{
		if(result.hasErrors() )
		{
			System.out.println(result);
			
			return "form";
			
		}
		
		System.out.println(loginData);
		
		//data process
	
		
		return "success";
	}
	

}
