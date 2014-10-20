package co.com.mongo;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloFreemarkerSpark {

	public static void main(String[] args) {

		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(HelloFreemarkerSpark.class, "/");

		Spark.get(new Route("/HelloFreemarker") {

			@Override
			public Object handle(Request arg0, Response arg1) {

				StringWriter writer = new StringWriter();

				try {
					Template template = configuration.getTemplate("hello.ftl");

					Map<String, Object> map = new HashMap<String, Object>();
					map.put("message", "Hello from freemarker");

					template.process(map, writer);
				} catch (Exception e) {
					e.printStackTrace();
				}

				return writer.toString();
			}
		});
	}

}
