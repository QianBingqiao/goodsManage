package com.qbq.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceUtils {
	public static SimpleDateFormat sdf = null;
	
	public static String format(){
		Date date = new Date();
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);	
	}
	public static Date parse(String str) throws ParseException{
		
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(str);
	}
}
