package com.test.caizq.demo.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author caizh
 * 生成测试用的sql语句
 */
public class generateSql {

	public static void main(String[] args) throws IOException {
 
		Long startTime =System.currentTimeMillis(); 
		
		StringBuilder sql = new StringBuilder("INSERT into test_foshan.students VALUES");
		for (int i=900001;i<=1000000;i++) {
			String value = "('"+i+"','test"+i+"','test"+i+"'),"+"\n";
			if(i==1000000) {
				sql.append("('"+i+"','test"+i+"','test"+i+"');");
				continue;
			}
			sql.append(value);
		}
		generateSql.writeSqlToFile(sql);
		
        Long endTime =System.currentTimeMillis();
    	System.out.println("总耗时为ms："+(endTime-startTime));
	}
	
    public static void  writeSqlToFile(StringBuilder sb) throws IOException {
    	
    	
    	String path = "DML.sql";
    	File file = new File(path);
    	System.out.println(file.getAbsolutePath());
    	FileWriter fw = new FileWriter(file,false);
    	BufferedWriter bw = new BufferedWriter(fw);
    	bw.append(sb);
    	bw.flush();
    	
    	
    	
    }
	
	
}
