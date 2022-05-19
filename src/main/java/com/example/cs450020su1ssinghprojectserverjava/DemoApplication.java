package main.java.com.example.cs450020su1ssinghprojectserverjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class DemoApplication implements ErrorController{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public String error() {
		return "index.html";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}