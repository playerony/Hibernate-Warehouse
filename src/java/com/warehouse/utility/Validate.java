/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.utility;

import com.warehouse.entity.PalleteInfo;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pawel_000
 */
public class Validate {
    public static boolean checkNumbersInString(String phrase) {
        boolean result = true;
        
        if (phrase.length() >= 1) {
            for (int i = 33; i < 65; i++)
                if (phrase.contains(String.valueOf(i))) {
                    result = false;
                    break;/*contains*/
                }
            
            for (int i = 91; i < 97; i++)
                if (phrase.contains(String.valueOf(i))) {
                    result = false;
                    break;/*contains*/
                }

            for (int i = 123; i < 256; i++)
                if (phrase.contains(String.valueOf(i))) {
                    result = false;
                    break;/*contains*/
                }
        }
        else
            result = false;

        return result;
    }
    
    public static ArrayList<PalleteInfo> getPalleteInformations(String phrase){
        ArrayList<PalleteInfo> result = new ArrayList<>();
		
        if(phrase != null){
            String id = null;
            String amount = null;

            Pattern p = Pattern.compile("-?\\d+");
            Matcher m = p.matcher(phrase);
            int i = 1;

            while (m.find()) {
                if(i%2 == 0)
                    amount = m.group();
                else
                    id = m.group();

                i++;

                if(id != null && amount != null){
                    result.add(new PalleteInfo(Integer.parseInt(id), Integer.parseInt(amount)));
                    amount = null;
                    id = null;
                }
            }
        }
		
        return result;
    }
}
