package com.java.ApiApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@CrossOrigin(origins = "http://localhost:4300")


public class filesReader {
	
	
	@Value("${dirPath}")
	public  String dirPath;
	
	@Value("${Extension}")
	public  String extension;
	
	
//	@RequestMapping("/ApiApplicattion")
	@GetMapping("/ApiApplication/ListFiles")
	public  List<ListOfFiles> ListFiles() {
	
		int i=1;
//		List<String> list = new ArrayList<>();
		List<ListOfFiles> l = new ArrayList<>();
	
		 File file = new File(dirPath);
	        String[] files = file.list(new FilenameFilter() {
	             
	            @Override
	            public boolean accept(File dir, String name) {
	                if(name.toLowerCase().endsWith(extension)){
	                	
	                    return true;
	                } else {
	                    return false;
	                }
	            }
	        });
	        for(String f:files) {
//	        ResponseEntity.ok(Map.of("FileContent", f));
//	        	System.out.println(f);
//	        	list.add(f);
	        	l.add(new ListOfFiles(i,f,extension));
	        	i++;
	        
	        }
	        return l;
//	        return ResponseEntity.ok(Map.of("files of extension "+extension+" in directory",list));
	}
	        
	        
	        
	
	
	public ResponseEntity<Map<String,String>> textFileReader(String name) throws FileNotFoundException , IOException
	{
		File file= ResourceUtils.getFile(dirPath+ name);
		String FileContent = new String(Files.readAllBytes(file.toPath()));
//		System.out.println(name);
//		System.out.println(FileContent);
		
		return ResponseEntity.ok(Map.of(name,FileContent));
	}
	
	
	
//	@RequestMapping("/ApiApplicattion")
	@GetMapping("/ApiApplication/Read-Files")
	public  List<GetterSetterMethods> filepath() {
	
		List<GetterSetterMethods> list = new ArrayList<>();
		
		
		 File file = new File(dirPath);
	        String[] files = file.list(new FilenameFilter() {
	             
	            @Override
	            public boolean accept(File dir, String name) {
	                if(name.toLowerCase().endsWith(extension)){
	                	
//						
	                    return true;
	                } else {
	                    return false;
	                }
	            }
	        });
	        for(String f:files){
	        	if(f.endsWith(extension)) {
	        		switch(extension) {
	        		
//	        		case 1 :
	        		
					case ".txt": 
							try {
								
//								System.out.println(name);
//								System.out.println(FileContent);
								System.out.println(f);
//								return textFileReader(f);
							}
							catch(Exception e) {
								e.printStackTrace();
							}
						break;
						
						
//						case 2 : 
						
					case ".csv":
						
						try{
							File file1= ResourceUtils.getFile(dirPath+f);
							BufferedReader br = new BufferedReader(new FileReader(file1));
							String line="";
							
							while((line=br.readLine())!=null) {
								
								String[] data =line.split(",");
								
								list.add(new GetterSetterMethods(Integer.valueOf(data[0]), data[1], data[2], Double.valueOf(data[3])));
								
							}
							br.close();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
						return list;
//						break;
//						case 3: 
						
					case ".xlsx":
						try {
							File file1 = new File(dirPath+f);  
							FileInputStream fis = new FileInputStream(file1);   
							XSSFWorkbook workbook = new XSSFWorkbook(fis);
							XSSFSheet sheet = workbook.getSheetAt(0);
							
							
							 int rowNumber = 0;
					            
					            Iterator<Row> iterator = sheet.iterator();

					            while (iterator.hasNext()) {
					                Row row = iterator.next();

					                if (rowNumber == 0) {
					                    rowNumber++;
					                    //continue;
					                }
					                else {
					                Iterator<Cell> cells = row.iterator();

					                int cid = 0;

					                GetterSetterMethods p = new GetterSetterMethods();

					                while (cells.hasNext()) {
					                    Cell cell = cells.next();

					                    switch (cid) {
					                        case 0:
					                            p.setId((int) cell.getNumericCellValue());
					                            break;
					                        case 1:
					                            p.setTitle(cell.getStringCellValue());
					                            break;
					                        case 2:
					                            p.setDiscription(cell.getStringCellValue());
					                            break;
					                        case 3:
					            	            p.setProductPrice(cell.getNumericCellValue());
					            	            break;
					                        default:
					                            break;
					                    }
					                    cid++;

					                }

					                list.add(p);

					                }
					            }
					           
							workbook.close();
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return list;
//					break;
//					case 4 : 
					
					case ".json":
						ObjectMapper mapper = new ObjectMapper();				//this ObjectMapper converts the json string into java object. It is a class under Jackson library.

						
						List<GetterSetterMethods> gtsList;
						try {
							gtsList = mapper.readValue(new File(dirPath+f), 
									new TypeReference<List<GetterSetterMethods>>() {});
							// TypeReference converts the data of the file into a List of objects.
							
							return gtsList;
							
						} catch (StreamReadException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (DatabindException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
									
						break;
							
						
                	}
//	            System.out.println(f);
	        }}
	        return null;
  }
	
	
}

