/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aboutus;

/**
 *
 * @author User
 */

public class user {
    
    
    private  int id;
    private  String role;
    private  String name;
    private  String email;
    private  String dob;
    private  String address;
    
    static int count = 0;

    public user(String role,String name, String email, String dob, String address) 
    {
        this.name = name;
        this.email = email;
        this.role = role;
        this.dob = dob;
        this.address = address;
        this.id = ++count;
    }

    user(int parseInt, String string, String string0, String string1, String string2, String string3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getaddress() {
        return this.address;
    }

    public String getdob() {
        return this.dob;
    }

    public String getrole() {
        return this.role;
    }

    

    public int getid() {
        return this.id;
    } 
}
    


