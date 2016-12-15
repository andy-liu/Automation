package com.zerozero.AndroidAppAutoTestCases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;


public class TryFileIO {

	@Test
	public void readCSV() throws IOException {
		Reader in = null;
		CSVParser parser = null;
		try {
			in = new FileReader("D:\\workspace\\AndroidAppAuto\\data\\testCSV.csv");
			parser = new CSVParser(in, CSVFormat.EXCEL.withHeader());
			for (CSVRecord record : parser){
				System.out.println("username: "+record.get("username"));
				System.out.println("password: "+ record.get("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			parser.close();
			in.close();
		}
		
	}

	@Test
	public void writeCSV() throws IOException{

		List<String> user = new ArrayList<String>();
		user.add(0, "username");
		user.add(1, "pasword");
//		System.out.println(user);
		Writer out = new FileWriter("D:\\workspace\\AndroidAppAuto\\data\\testCSV.csv");
		CSVPrinter printer = new CSVPrinter(out, CSVFormat.EXCEL.withHeader());
		printer.printRecord(user);
		printer.close();
		out.close();
	}
	
	@Test
	public void createCSV(){        
		        // 表格头
		        Object[] head = { "客户姓名", "证件类型", "日期", };
		        List<Object> headList = Arrays.asList(head);

		        //数据
		        List<List<Object>> dataList = new ArrayList<List<Object>>();
		        List<Object> rowList = null;
		        for (int i = 0; i < 100; i++) {
		            rowList = new ArrayList<Object>();
		            rowList.add("张三" + i);
		            rowList.add("263834194" + i);
		            rowList.add(new Date());
		            dataList.add(rowList);
		        }
		        
		        String fileName = "testCSV.csv";//文件名称
		        String filePath = "D:/workspace/AndroidAppAuto/data/"; //文件路径
		        
		        File csvFile = null;
		        BufferedWriter csvWtriter = null;
		        try {
		            csvFile = new File(filePath + fileName);
		            File parent = csvFile.getParentFile();
		            if (parent != null && !parent.exists()) {
		                parent.mkdirs();
		            }
		            csvFile.createNewFile();

		            // GB2312使正确读取分隔符","
		            csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "GB2312"), 1024);
		            
//		            int num = headList.size() / 2;
//		            StringBuffer buffer = new StringBuffer();
//		            for (int i = 0; i < num; i++) {
//		                buffer.append(" ,");
//		            }
//		            csvWtriter.write(buffer.toString() + fileName + buffer.toString());
//		            csvWtriter.newLine();

		            // 写入文件头部
		            writeRow(headList, csvWtriter);

		            // 写入文件内容
		            for (List<Object> row : dataList) {
		                writeRow(row, csvWtriter);
		            }
		            csvWtriter.flush();
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            try {
		                csvWtriter.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		    
		    private void writeRow(List<Object> row, BufferedWriter csvWriter) throws IOException {
		        for (Object data : row) {
		            StringBuffer sb = new StringBuffer();
		            String rowStr = sb.append("\"").append(data).append("\",").toString();
		            csvWriter.write(rowStr);
		        }
		        csvWriter.newLine();
		    }
}
