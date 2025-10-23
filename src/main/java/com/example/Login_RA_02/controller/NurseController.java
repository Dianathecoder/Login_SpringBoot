package com.example.Login_RA_02.controller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Login_RA_02.dao.NurseRepository;

import model.Nurse;


@RequestMapping("/nurse")
@RestController
public class NurseController {
	
	@Autowired
	 private NurseRepository nurseRepository;
	
	 @PostMapping("/login")
	 public ResponseEntity<Boolean>login(@RequestBody Nurse nurse) {
		   boolean exists = nurseRepository.existsByUserAndPass( nurse.getUser(), nurse.getPass());
		 	if(exists) {
		 		return ResponseEntity.ok(true);
		 	}else {
		 		return ResponseEntity.ok(false);
		 	}
	 }
	 
	 @GetMapping
		public @ResponseBody Iterable<Nurse> getAllUsers() {
			// This returns a JSON or XML with the users
			return nurseRepository.findAll();
		}
		
	 
	
	 @GetMapping("/name/{name}")
		public @ResponseBody Optional<Nurse> getUserByName(@PathVariable("name") String name) {
		 return nurseRepository.findByName(name);
	 }
	 
	 
	/* @PostMapping("/login")
	 public ResponseEntity<Boolean>login(@RequestBody Nurse nurse) {
    	
    		JSONParser jsonparser= new JSONParser();
    		String rutaProyecto= System.getProperty("user.dir");
    		String fs = File.separator;
    		
    		try {
    			
    			FileReader reader = new FileReader(rutaProyecto+fs+"src"+fs+"main"+fs+"resources"+fs+ "static"+fs+"nurses.json");
    		
    		    Object obj=jsonparser.parse(reader);//Lee el contenido JSON desde el js-----on y lo convierte en objeto
    		
    		    JSONObject empjsonobj=(JSONObject)obj;//Se hace un cast del Object a JSONObject
    		
    		    JSONArray arraynurse=(JSONArray)empjsonobj.get("nurses");
    		   
    		    
    		    if(arraynurse !=null) {

    			   for(int i=0;i<arraynurse.size();i++) {
    				   
    				   JSONObject seachjson=(JSONObject) arraynurse.get(i);//Accede a la posicion i del JSON
    				
    				   String pass= (String) seachjson.get("pass");
    				   String user= (String) seachjson.get("user");
    				
    				   if( user.equals(nurse.getUser()) && pass.equals(nurse.getPass())){
    			        	return ResponseEntity.ok(true);
    				}			 					
    			}
    			   return ResponseEntity.ok(false);
    		    }
    		    
            }catch (IOException | ParseException e) {
                e.printStackTrace();             
            }	
    		 return ResponseEntity.notFound().build();
    }*/
}
  

 