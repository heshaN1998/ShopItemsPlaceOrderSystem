/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layerd.controller;
import java.util.ArrayList;
import edu.ijse.layerd.dto.itemDto;
import edu.ijse.layerd.service.custom.ItemService;
import edu.ijse.layerd.service.ServiceFactory;


/**
 *
 * @author ACER
 */
public class ItemController {
    
    private ItemService itemService= (ItemService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ITEM);
    
    
    public String saveItem(itemDto itemDto) throws Exception{
    return itemService.saveItem(itemDto);
    }
        public String updateItem(itemDto itemDto) throws Exception{
    return itemService.updatetem(itemDto);
}
            public String deleteItem(String code) throws Exception{
    
    return itemService.deleteItem(code);
            }
                public String searchItem(String code) throws Exception{
    return itemService.searchItem(code);
                }
                public  ArrayList<itemDto> getAllItem() throws Exception{
                return itemService.getAllItems();
                }
                
}

