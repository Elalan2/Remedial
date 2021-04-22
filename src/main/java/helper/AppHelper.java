/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.security.SecureRandom;

/**
 *
 * @author alann
 */
public class AppHelper {
    public static String baseUrl() {
        return "http://localhost:8080/Holidaysss/";
    }
    
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();
    
    public static String randomString(int len){
       StringBuilder sb = new StringBuilder(len);
       for(int i = 0; i < len; i++)
          sb.append(AB.charAt(rnd.nextInt(AB.length())));
       return sb.toString();
    }
}
