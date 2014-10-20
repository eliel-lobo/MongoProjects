package co.com.mongo;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloSpark {
	

	public static void main(String[] args) {
		
		Spark.get(new Route("/HelloSpark") {
			
			@Override
			public Object handle(Request arg0, Response arg1) {
				return "Hello Dude";
			}
		});
		
		
	}
	
}
