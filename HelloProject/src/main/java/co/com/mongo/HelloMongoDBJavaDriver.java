package co.com.mongo;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class HelloMongoDBJavaDriver {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient client = new MongoClient();
		
		DB db = client.getDB("test");
		DBCollection collection = db.getCollection("hello");
		DBObject document = collection.findOne();
		System.out.println(document);
		
	}

}
