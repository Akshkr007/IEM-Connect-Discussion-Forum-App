/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iemconnect.login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class UserManager {

    public ArrayList<UserData> c = new ArrayList<UserData>();
    public static UserManager instance;
    
    public UserManager() {
        readFile();
    }
    
    private boolean readFile() {
        try {
            this.c.clear();
           
            FileReader fa = new FileReader("C:\\Users\\User\\Documents\\NetBeansProjects\\iemconnect login\\src\\iemconnect\\Database\\userDb.txt");
            BufferedReader br = new BufferedReader(fa);
            String temp = "";
            temp = br.readLine();
            while (temp != null) {
                
                if (temp != null) {
                    String[] strarr = temp.split(",");
                    UserData cust = new UserData(strarr[2], strarr[3],strarr[4],strarr[5]);
                    
                    this.c.add(cust);
                }
                temp = br.readLine();

            }
            br.close();
            
            return true;

        } catch (IOException e) {
            // TODO: handle exception
            return false;
        }

    }
    
    public static boolean loginUser(String uname, String pass){
        FileReader fa = null;
        try {
            boolean userStatus = false;
            fa = new FileReader("C:\\Users\\User\\Documents\\NetBeansProjects\\iemconnect login\\src\\iemconnect\\Database\\userDb.txt");
            BufferedReader br = new BufferedReader(fa);
            String temp = "";

            temp = br.readLine();
            while (temp != null) {
                System.out.println(temp);
                if(!temp.isEmpty()){
                    String[] dbDataArr = temp.split(",");
                    temp = br.readLine();
                    if(dbDataArr[2].equals(uname) && dbDataArr[4].equals(pass)){
                        userStatus = true;
                        break;
                    }
                }
                
            }   
            br.close();
//            System.out.println(userStatus);
            return userStatus;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static UserData getLogUserData(String userEmail){
        FileReader fa = null;
        try {
            UserData uData = null;
            boolean userStatus = false;
            fa = new FileReader("C:\\Users\\User\\Documents\\NetBeansProjects\\iemconnect login\\src\\iemconnect\\Database\\userDb.txt");
            BufferedReader br = new BufferedReader(fa);
            String temp = "";

            temp = br.readLine();
            while (temp != null) {
                System.out.println(temp);
                if(!temp.isEmpty()){
                    String[] dbDataArr = temp.split(",");
                    userStatus = dbDataArr[2].equals(userEmail);
                    uData = new UserData(dbDataArr[1], dbDataArr[2], dbDataArr[3], dbDataArr[4]);
                    temp = br.readLine();
                    if(userStatus){
                        break;
                    } 
                }
//                else{
//                    userStatus = false;
//                }
                
            }   
            br.close();
//            System.out.println(userStatus);
            return uData;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static boolean chkUserExists(String userEmail){
        FileReader fa = null;
        try {
            boolean userStatus = false;
            fa = new FileReader("C:\\Users\\User\\Documents\\NetBeansProjects\\iemconnect login\\src\\iemconnect\\Database\\userDb.txt");
            BufferedReader br = new BufferedReader(fa);
            String temp = "";

            temp = br.readLine();
            while (temp != null) {
                System.out.println(temp);
                if(!temp.isEmpty()){
                    String[] dbDataArr = temp.split(",");
                    userStatus = dbDataArr[2].equals(userEmail);
                    temp = br.readLine();
                    if(userStatus){
                        break;
                    } 
                }
//                else{
//                    userStatus = false;
//                }
                
            }   
            br.close();
//            System.out.println(userStatus);
            return userStatus;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean writeInCustFile(UserData obj) {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\User\\Documents\\NetBeansProjects\\iemconnect login\\src\\iemconnect\\Database\\userDb.txt", true);
            BufferedWriter bf = new BufferedWriter(fw);
            bf.write(obj.getid() + "," + obj.getName() + "," + obj.getEmail() + ","
                    + obj.getdob() + "," + obj.getPassword()  + "\n");
            bf.close();
            return true;

        } catch (IOException e) {
            // TODO: handle exception
            return false;
        }

    }
    
    
}
