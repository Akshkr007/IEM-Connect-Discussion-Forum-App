/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dashboard;

import iemconnect.Database.AbstractLoginData;
import iemconnect.login.UserData;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class QuestionManager {

    private static ArrayList<QuestionData> allQData;
    
    public QuestionManager(){
        
    }
    
    public static ArrayList<QuestionData> getAllQuestions(){
        ArrayList<QuestionData> allqData;
        allqData = new ArrayList<>();
        try {
            FileReader fa = null;
            fa = new FileReader("C:\\Users\\User\\Documents\\NetBeansProjects\\iemconnect login\\src\\iemconnect\\Database\\questionDb.txt");
            try (BufferedReader br = new BufferedReader(fa)) {
                String temp = " ";
                
                temp = br.readLine();
                while (temp != null) {
                    System.out.println(temp);
                    if(!temp.isEmpty()){
                        String[] dbDataArr = temp.split(",");
                        QuestionData qData = new QuestionData(dbDataArr[0], dbDataArr[1], dbDataArr[2]);
                        allQData.add(qData);
                        temp = br.readLine();
                    }
                    
                }
            }
//            System.out.println(userStatus);
            return allQData;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QuestionManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(QuestionManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void setQuestion(String ques){
        FileWriter fw = null;
        try {
            fw = new FileWriter("C:\\Users\\User\\Documents\\NetBeansProjects\\iemconnect login\\src\\iemconnect\\Database\\questionDb.txt", true);
            try (BufferedWriter bf = new BufferedWriter(fw)) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                String hours = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
                String min = String.valueOf(cal.get(Calendar.MINUTE));
                String sec = String.valueOf(cal.get(Calendar.SECOND));
                
                String year = String.valueOf(cal.get(Calendar.YEAR));
                String month = String.valueOf(cal.get(Calendar.MONTH));
                String day = String.valueOf(cal.get(Calendar.DATE));
                String id = year+month+day+hours+min+sec;
                
                UserData uData = AbstractLoginData.getUser();
                bf.write(id + "," + ques + "," + uData.getEmail() +"\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(QuestionManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(QuestionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
