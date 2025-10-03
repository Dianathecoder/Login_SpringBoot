package com.example.Login_RA_02;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/nurse")
@RestController
public class NurseController {
		 
	 @PostMapping
	 @RequestMapping("/login")
	 public ResponseEntity<Boolean>login(@RequestBody Nurse nurse) {
    	
    		JSONParser jsonparser= new JSONParser();
    		
    		try {
    			
    		    FileReader reader = new FileReader("/home/diana/Escritorio/dam/dam/Dam_2curso/proyecto/Login/Login_SpringBoot/src/main/resources/nurses.json");
    		
    		    Object obj=jsonparser.parse(reader);//Lee el contenido JSON desde el json y lo convierte en objeto
    		
    		    JSONObject empjsonobj=(JSONObject)obj;//Se hace un cast del Object a JSONObject
    		
    		    JSONArray arraynurse=(JSONArray)empjsonobj.get("nurse");
    		
    		    
    		    if(arraynurse !=null) {
    			   for(int i=0;i<arraynurse.size();i++) {
    				   
    				   JSONObject seachjson=(JSONObject) arraynurse.get(i);//Accede a la posicion i del JSON
    				
    				   String name = (String) seachjson.get("name");
    				   String password = (String) seachjson.get("password");
    				
    				   if(name.equals(nurse.getName()) && password.equals(nurse.getPassword())){
    			        	return ResponseEntity.ok(true);
    				}			 					
    			}
    			   return ResponseEntity.ok(false);
    		    }
    		    
            }catch (IOException | ParseException e) {
                e.printStackTrace();             
            }	
    		 return ResponseEntity.notFound().build();
    }
}
    
    
    
    
    
    
    
    
    
    
	
    
    
    
    
    
    
    
    
    
    
    
    
  