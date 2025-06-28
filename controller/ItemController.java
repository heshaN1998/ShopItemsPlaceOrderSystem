/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layerd.controller;
import java.util.ArrayList;
import edu.ijse.layerd.dto.itemDto;


/**
 *
 * @author ACER
 */
public class ItemController {
    public String saveItem(itemDto itemDto) throws Exception{
    return "Success";
    }
        public String updateItem(itemDto itemDto) throws Exception{
    return "Success";
}
            public String deleteItem(String code) throws Exception{
    return "Success";
            }
                public String searchItem(String code) throws Exception{
    return null;
                }
                public  ArrayList<itemDto> getAllItem() throws Exception{
                return null;
                }
                
}

