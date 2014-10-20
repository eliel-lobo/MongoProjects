package co.com.mongo;

import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloAllTogether {

	public static void main(String[] args) throws UnknownHostException {
		
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(HelloFreemarkerSpark.class, "/");
		
		MongoClient client = new MongoClient();
		
		DB db = client.getDB("test");
		final DBCollection collection = db.getCollection("hello");

		Spark.get(new Route("/HelloFreemarker") {

			@Override
			public Object handle(Request arg0, Response arg1) {

				StringWriter writer = new StringWriter();

				try {
					Template template = configuration.getTemplate("hello.ftl");
					
					DBObject object = collection.findOne();

					template.process(object, writer);
				} catch (Exception e) {
					e.printStackTrace();
				}

				return writer.toString();
			}
		});
	}

}
