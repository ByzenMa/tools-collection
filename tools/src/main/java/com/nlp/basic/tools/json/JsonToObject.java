package com.nlp.basic.tools.json;

import com.google.gson.Gson;
import com.nlp.basic.tools.auxiliary.Student;

/**
 * To convert JSON string to object use Gson.fromJson() method. This method
 * takes the JSON string and the object type of the JSON string to be converted.
 * 
 * @author mabaizhang
 * @date 2017年6月27日
 */
public class JsonToObject {
	public static void main(String[] args) {
		String json = "{" + "'name' : 'Duke'," + "'address' : 'Menlo Park',"
				+ "'dateOfBirth' : 'Feb 1, 2000 12:00:00 AM'" + "}";

		Gson gson = new Gson();
		Student student = gson.fromJson(json, Student.class);

		System.out.println("s.getName()        = " + student.getName());
		System.out.println("s.getAddress()     = " + student.getAddress());
		System.out.println("s.getDateOfBirth() = " + student.getDateOfBirth());
	}
}
