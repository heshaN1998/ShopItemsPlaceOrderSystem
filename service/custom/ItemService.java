/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.layerd.service.custom;
import edu.ijse.layerd.dto.itemDto;
import java.util.ArrayList;
import edu.ijse.layerd.service.SuperService;

/**
 *
 * @author ACER
 */
public interface ItemService extends SuperService{
   public String saveItem(itemDto itemDto) throws Exception; 
      public String updatetem(itemDto itemDto) throws Exception; 
            public String deleteItem(String itemCode) throws Exception; 
               public String searchItem(String itemCode) throws Exception;
               public ArrayList<itemDto> getAllItems() throws Exception;
               
               
}
