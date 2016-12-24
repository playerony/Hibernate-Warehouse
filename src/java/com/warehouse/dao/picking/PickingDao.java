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
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author pawel_000
 */
public class PickingDao implements SessionAware {
    private Map<String, Object> session;
    private OrderDao orderDao;
    
    public PickingDao(){
        orderDao = new OrderDao();
    }
    
    public boolean nextItemButtonAction(PalleteInfo palleteInfo, PalletsInMagazine palletsInMagazine){
        String result = palleteInfo.getId() + "(" + palleteInfo.getAmount() + ")";
        
        String phrase = (String) session.get("items");
			
        ArrayList<PalleteInfo> pallete = getPalleteInformations(phrase);
        
        return true;
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
    
    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
