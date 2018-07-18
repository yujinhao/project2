package cn.edu.lingnan.util;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidator {
	public static boolean validator(String xmlPath,String xsdPath){
		boolean flag = false;
		try{
			SchemaFactory  sf = SchemaFactory.newInstance
				("http://www.w3.org/2001/XMLSchema");
		File f = new File(xsdPath);
		Schema s = sf.newSchema(f);
		Validator v = s.newValidator();
		Source so = new StreamSource(xmlPath);
		v.validate(so);
		flag = true;
		}catch (SAXException e){
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			//�رոùرյ���
		}
		
		return flag;
	}
	
	
//	//ֻ��Ϊ���Է�������
//	public static void main(String[] args) {
//		String xmlPath =  "bin//database.conf.xml";
//		String xsdPath =  "bin//database.conf.xsd";
//		if(XMLValidator.validator(xmlPath, xsdPath)){
//			System.out.println("��֤�ɹ�");
//		}else 
//			System.out.println("��֤���ɹ�");
//	}

}
