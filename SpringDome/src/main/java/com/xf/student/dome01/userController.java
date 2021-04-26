package com.xf.student.dome01;

import com.xf.student.dome01.annotation.AutoWired;

import javax.swing.*;
import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.stream.Stream;

public class userController{
	@AutoWired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public static void main(String[] args) {
	}

}

class Test01{
	public static void main(String[] args) throws Exception {
		userController controller = new userController();
		Class<? extends userController> clazz = controller.getClass();
		for (Field declaredField : clazz.getDeclaredFields()) {
			String fildName = declaredField.getName();
			AutoWired autoWired =  declaredField.getAnnotation(AutoWired.class);
			if (autoWired!=null){
				declaredField.setAccessible(true);
				//获取当前属性的类型
				Class<?> type = declaredField.getType();
				//通过反射将当前属性对象进行创建
				Object o = type.newInstance();
				System.out.println(o);
				//将当期对象设置到当期属性中
				declaredField.set(controller,o);
			}
		}

		System.out.println(controller.getUserService());
	}
}
