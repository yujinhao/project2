package cn.edu.lingnan.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLParser {
 public static HashMap<String,String> parser(String xmlPath){
	 HashMap<String,String> hm = new HashMap<String,String>();
	try {
		 SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		File f = new File(xmlPath);
		XMLHandler xh = new XMLHandler();
		sp.parse(f, xh);
		hm = xh.getHashMap();
		 } catch (IOException e) {
			
			e.printStackTrace();
	} catch (ParserConfigurationException e) {
		
		e.printStackTrace();
	} catch (SAXException e) {
		e.printStackTrace();
	}finally{
		//关闭该关闭的流
	}
	 return hm;
 }
 //public static void main(String[] args) {
//	String xmlPath = "bin//database.conf.xml";
	
//	if(XMLParser.parser(xmlPath)){
//		System.out.println("解析成功");
//	}else 
//		System.out.println("解析不成功");
//}
 
}
