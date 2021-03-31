/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iemconnect.Database;

import iemconnect.login.UserData;

/**
 *
 * @author User
 */
public abstract class AbstractLoginData {
    public static UserData userData;
    
    public static UserData getUser(){
        return userData;
    }
    
    public static void setUser(UserData uData){
        userData = uData;
    }
}
