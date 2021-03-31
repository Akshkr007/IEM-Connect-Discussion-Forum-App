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
 
    import java.io.*;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public final class UserManager {

    public ArrayList<user> c = new ArrayList<>();

    // public static int flag = 0;

    public static UserManager instance;

    private UserManager() {
        readFile();
    }

    public boolean readFile() {
        try {
            this.c.clear();
           
            FileReader fa = new FileReader("C:\\Users\\User\\Documents\\NetBeansProjects\\aboutus\\src\\aboutus\\database\\user.txt");
            try (BufferedReader br = new BufferedReader(fa)) {
                String temp = "";
                temp = br.readLine();
                while (temp != null) {
                    
                    if (temp != null) {
                        String[] strarr = temp.split(",");
                        user cust = new user(Integer.parseInt(strarr[0]), strarr[1], strarr[2], strarr[3],strarr[4],strarr[5]);
                        
                        
                        this.c.add(cust);
                    }
                    temp = br.readLine();
                    
                }
            }
            
            return true;

        } catch (IOException e) {
            // TODO: handle exception
            return false;
        }

    }

    public boolean writeInCustFile(user obj) {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\User\\Documents\\NetBeansProjects\\aboutus\\src\\aboutus\\database\\user.txt", true);
            try (BufferedWriter bf = new BufferedWriter(fw)) {
                bf.write(obj.getid() + "," + obj.getrole() + "," + obj.getName() + "," + obj.getEmail() + ","
                        + obj.getdob() + "," + obj.getaddress()  + "\n");
            }
            return true;

        } catch (IOException e) {
            // TODO: handle exception
            return false;
        }

    }

    

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public boolean createAccount(user obj) {
        c.add(obj);
        return (writeInCustFile(obj));
    }

    

    public user displayAccount(String emailID) {
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getEmail().equals(emailID)) {
                // System.out.println("Name=" + c.get(i).getName());
                // System.out.println("Email=" + c.get(i).getEmail());
                // System.out.println("age=" + c.get(i).getAge());
                // System.out.println("Phone Number=" + c.get(i).getPhoneNumber());
                // System.out.println("Location=" + c.get(i).getLocation());
                // System.out.println("user ID=" + c.get(i).getCustomID());
                return c.get(i);
            }
        }
        System.out.println("user does not exist in our database");
        return null;
    }

    

    

    

    

    public List<user> UnModifiedListOfusers() {
        List<user> ls = null;
        ls = Collections.unmodifiableList(c);

        return ls;
    }

    public static void main(String[] args) {
         UserManager obj = getInstance();
        // assert (obj.UnModifiedListOfusers().size() == 7);
        // assert (obj.UnModifiedListOfusers().get(3).getName().equals("Aman")) :
        // "Different";
        obj.createAccount(new user(66,"student", "vivekkumarsinha999@gmail.com", "11/11/2000",
         "gggg","aff"));
        // System.out.println(obj.reWriteAccountDetailsDriver(
        // new Driver("Aman", "adi@gmail.com", "13423", "65", "80273xxxxxx", "700092",
        // "Maruti", "Wb cz 501p")));
        // obj.displayAccount(2);

        // obj.displayAccount(3, 'd');
    }

}