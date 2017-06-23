package com.yh.demo;

public class Demo02
{
	public static void main(String[] args)
	{
		if (null != args && args.length > 0)
		{
			for (String string : args)
			{
				System.out.println("Demo02:" + string);
			}
		} else
		{
			System.out.println("Demo02");
		}
		
	}
}
