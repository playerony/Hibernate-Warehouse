/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

import com.warehouse.entity.PalleteInfo;
import com.warehouse.entity.PalletsInMagazine;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pawel_000
 */
public class PickingDao {
    private OrderDao orderDao;
    
    public PickingDao(){
        orderDao = new OrderDao();
    }
    
    public boolean nextItemButtonAction(PalleteInfo palleteInfo, PalletsInMagazine palletsInMagazine, Map<String, Object> session){
        boolean res = false;
        String result = palleteInfo.getId() + "(" + palleteInfo.getAmount() + ")";
        String phrase = (String) session.get("items");
        String orderPhrase = (String) session.get("order");
        
        ArrayList<PalleteInfo> palleteItems = getPalleteInformations(phrase);
        
        PalleteInfo pal = null;
        for(PalleteInfo p : palleteItems)
            if(palleteInfo.getId() == p.getId()){
                pal = p;
                break;
            }
            
        if(pal != null){
            int value = pal.getAmount() - palleteInfo.getAmount();
            pal.setAmount(value);
		    	
            if(value <= 0)
                palleteItems.remove(pal);
            
            String phr = "";
            phr = palleteItems.stream().filter((p) -> (p != null)).map((p) -> (p.getId() + "(" + p.getAmount() + ")" + ",")).reduce(phr, String::concat);   
            session.put("items", phr);
		    	
            if(orderPhrase != null)
                session.put("order", orderPhrase + "," + result);
            else
                session.put("order", result);
		    	
            res = true;
        }
        
        return res;
    }
    
    public boolean finishButtonAction(){
        
        
        return true;
    }
    
    public ArrayList<PalleteInfo> getPalleteInformations(String phrase){
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
