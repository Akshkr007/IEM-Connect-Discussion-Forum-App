/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dashboard;

/**
 *
 * @author User
 */
public class QuestionData {
    private String id;
    private String ques;
    private String uName;
    
    public QuestionData(String id, String ques, String uName){
        this.id = id;
        this.ques = ques;
        this.uName = uName;
    }
    
    public String getUName(){
        return this.uName;
    }
    
    public String getQues(){
        return this.ques;
    }
    
    public String getId() {
        return this.id;
    }
}
