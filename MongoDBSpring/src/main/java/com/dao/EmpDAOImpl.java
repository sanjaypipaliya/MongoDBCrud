package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.entity.Emp;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class EmpDAOImpl implements EmpDAO {

	MongoClientURI clientURI = new MongoClientURI("mongodb+srv://sanjaypipaliya:sanjay@mongo-qsrz8.mongodb.net/admin");
	MongoClient mongoClient = new MongoClient(clientURI);
	MongoDatabase mongoDatabase = mongoClient.getDatabase("MyDB");
	@SuppressWarnings("rawtypes")
	MongoCollection collection = mongoDatabase.getCollection("emp");

	@SuppressWarnings("unchecked")
	public void insert(Emp emp) {

		Document document = new Document("empname", emp.getEmpName());
		document.append("username", emp.getUsername());
		document.append("password", emp.getPassword());
		collection.insertOne(document);
		

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Emp> getEmps() {

		List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());

		List<Emp> emp = new ArrayList();

		for (Document document : documents) {
			Emp empOne = new Emp();
			empOne.setEmpId(document.getObjectId("_id"));
			empOne.setEmpName(document.getString("empname"));
			empOne.setUsername(document.getString("username"));
			empOne.setPassword(document.getString("password"));
			emp.add(empOne);
		}
		return emp;
	}

	public Emp getEmpById(ObjectId objId) {

		Document found = (Document) collection.find(new Document("_id", objId)).first();
		Emp emp = new Emp();
		if (found != null) {
			emp.setEmpId(found.getObjectId("_id"));
			emp.setEmpName(found.getString("empname"));
			emp.setUsername(found.getString("username"));
			emp.setPassword(found.getString("password"));
		} else {
			emp = null;
		}
		return emp;
	}

	public void update(Emp emp) {

		Document document = new Document("empname", emp.getEmpName());
		document.append("username", emp.getUsername());
		document.append("password", emp.getPassword());
		collection.updateOne(new BasicDBObject().append("_id", emp.getEmpId()), new Document("$set", document));

	}

	public void delete(ObjectId id) {
		collection.deleteOne(new BasicDBObject().append("_id", id));
	}
	
	

}
