package tw.brad.h3;

import java.lang.reflect.Field;

import tw.brad.model.Bike;

public class Brad03 {

	public static void main(String[] args) {
		
		Class bClass = Bike.class;
		Field[] fs =  bClass.getFields();
		for (Field ff : fs) {
			System.out.println(ff.getName());
		}
		
	}

}
