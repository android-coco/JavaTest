package com.yh.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
@SuppressWarnings("all")
public class Demo01
{
	public static void main(String[] args)
	{
		String path = "com.yh.demo.User";
		try
		{
			Class<?> classzz = Class.forName(path);
			System.out.println(classzz.getName());
			System.out.println(classzz.getSimpleName());
			//属性
			Field[] fields = classzz.getDeclaredFields();
			//field.setAccessible(true);//私有变量访问
			for (Field field : fields)
			{
				System.out.println("属性：" + field);
			}
			//方法
			Method[] methods = classzz.getDeclaredMethods();
			for (Method method : methods)
			{
				System.out.println("方法：" + method);
			}
			//构造方法
			Constructor<?>[] construcors = classzz.getDeclaredConstructors();
			for (Constructor<?> constructor : construcors)
			{
				System.out.println("构造方法：" + constructor);
			}
			//属性使用
			User user1 = (User) classzz.newInstance();
			Field name = classzz.getDeclaredField("name");
			//私有变量必须加上
			name.setAccessible(true);
			name.set(user1,"youhaocc");
			System.out.println("属性使用：" + name.get(user1));
			
			
			//方法使用
			User user2 = (User) classzz.newInstance();
			Method setName = classzz.getDeclaredMethod("setName", String.class);
			//如果是私有方法必须加上
			setName.setAccessible(true);
			Method getName = classzz.getDeclaredMethod("getName", null);
			//如果是私有方法必须加上
			getName.setAccessible(true);
			setName.invoke(user2, "youhao");
			Object getNameRes = getName.invoke(user2, null);
			System.out.println("方法使用:" + getNameRes);
			//静态方法使用
			String path1 = "com.yh.demo.Demo02";
			Class<?> demo02_class = Class.forName(path1);
			//注意参数的类型
			Method main = demo02_class.getDeclaredMethod("main",  String[].class);
			//参数传递方式
			Object invokeRes = main.invoke(null, (Object)new String[]{"age"});
			System.out.println("方法执行返回值：" + invokeRes);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
