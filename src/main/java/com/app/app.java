package com.app;
import static spark.Spark.*;

import com.service.UserService;





public class app {
	public static void main(String args[]) {
		port(6789);
		staticFiles.location("/public/Front-end");
		
		
		post("/insertUser", (request, response) -> UserService.insert(request, response));
        post("/AuthUser", (request, response) -> UserService.autenticate(request, response));
	}
}
