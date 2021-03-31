/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iemconnect.login;

/**
 *
 * @author User
 */
public class UserData {
    private  int id;
    private  String name;
    private  String email;
    private  String dob;
    private  String password;
    
    static int count = 0;

    public UserData(String name, String email, String dob, String password) 
    {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.password = password;
        this.id = ++count;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
    
    public String getPassword() {
        return this.password;
    }

    public String getdob() {
        return this.dob;
    }

    public int getid() {
        return this.id;
    } 
}
