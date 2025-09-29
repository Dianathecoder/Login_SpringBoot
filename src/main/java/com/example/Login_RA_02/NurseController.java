package com.example.Login_RA_02;

public class NurseController {
	
	
    public boolean login(String usuario, String pwd) {
        return ValidateNurse(usuario, pwd);
    }
    
    public boolean ValidateNurse(String usuario, String pwd) {
    	
		return false;
    	
    }
    
    
    
    
    
    
    
    
    
    
	
    /* public boolean validateNurse(String usuario, String pwd) {
        boolean userExist = false;

        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("users.json");

            if (inputStream != null) {
                // Mapear el JSON a un mapa de User
                Map<String, User> users = mapper.readValue(inputStream,
                        mapper.getTypeFactory().constructMapType(Map.class, String.class, User.class));

                for (User user : users.values()) {
                    if (user.getUserName().equals(usuario) && user.getPswword().equals(pwd)) {
                        userExist = true;
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userExist;
    }*/
}
