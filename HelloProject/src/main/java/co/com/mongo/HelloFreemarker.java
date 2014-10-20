package co.com.mongo;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloFreemarker {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(HelloFreemarkerSpark.class, "/");
		
		StringWriter writer = new StringWriter();

		try {
			Template template = configuration.getTemplate("hello.ftl");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Hello from freemarker");

			template.process(map, writer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(writer);
	}
}
