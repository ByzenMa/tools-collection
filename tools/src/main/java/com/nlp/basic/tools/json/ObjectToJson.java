package com.nlp.basic.tools.json;

import java.util.Calendar;

import com.google.gson.Gson;
import com.nlp.basic.tools.auxiliary.People;

/**
 * In this example you’ll see how the Gson library handles the object fields.
 * For object fields to be serialized into JSON string it doesn’t need to use
 * any annotations, it can even read private fields. If you have a null value
 * field it will not be serialized into JSON string. To exclude a field from
 * serialization you can mark the field with the transient keyword.
 * 
 * In the snippet below we create a People object. This object has a null value
 * field named age, this will not included in the serialization because we
 * didn’t assign any value to it. The secret field is also not serialized
 * because we mark it with transient keyword.
 * 
 * @author mabaizhang
 * @date 2017年6月27日
 */
public class ObjectToJson {
	public static void main(String[] args) {
		Calendar dob = Calendar.getInstance();
		dob.set(1980, Calendar.NOVEMBER, 11);
		People people = new People("John", "350 Banana St.", dob.getTime());
		people.setSecret("This is a secret!");

		Gson gson = new Gson();
		String json = gson.toJson(people);
		System.out.println("json = " + json);
	}
}
