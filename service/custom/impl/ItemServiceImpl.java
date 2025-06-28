/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layerd.service.custom.impl;
import edu.ijse.layerd.dao.DaoFactory;
import edu.ijse.layerd.dao.custom.ItemDao;
import edu.ijse.layerd.dto.itemDto;
import edu.ijse.layerd.service.custom.ItemService;
import java.util.ArrayList;
import edu.ijse.layerd.entity.ItemEntity;
import edu.ijse.layerd.dto;

/**
 *
 * @author ACER
 */
public class ItemServiceImpl implements ItemService{
    
   private ItemDao itemDao = (ItemDao)DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);

    @Override
    public String saveItem(itemDto itemDto) throws Exception {

    ItemEntity itemEntity = new ItemEntity(itemDto.getCode(),
    itemDto.getDesc(),itemDto.getPack(),itemDto.getUnitPrize(),itemDto.getQoh());
   
    boolean isSaved = itemDao.save(itemEntity);
    return isSaved ? "Success" : "Fail";
    }

    @Override
    public String updatetem(itemDto itemDto) throws Exception {

         ItemEntity itemEntity = new ItemEntity(itemDto.getCode(),
    itemDto.getDesc(),itemDto.getPack(),itemDto.getUnitPrize(),itemDto.getQoh());
   
    boolean isUpdate = itemDao.update(itemEntity);
    return isUpdate ? "Success" : "Fail";
        
    }

    @Override
    public String deleteItem(String itemCode) throws Exception {
     
        boolean isDeleted = itemDao.delete(itemCode);
        return isDeleted ? "Success" : "Fail";

    }

    @Override
    public String searchItem(String itemCode) throws Exception {
      ItemEntity itemEntity = itemDao.search(itemCode);
      if(itemEntity != null){
      return new ItemDto(itemEntity.getCode(), itemEntity.getDesc(), itemEntity.getPack(), itemEntity.getUnitPrize(), itemEntity.getQoh());
      }
      return null;
    }

    @Override
    public ArrayList<itemDto> getAllItems() throws Exception {
    ArrayList<ItemEntity> itemEntitys = itemDao.getAll();
    ArrayList<itemDto> itemDtos =new ArrayList<>();
    if(itemEntity != null){
        
       for( ItemEntity itemEntity :itemEntitys ){
       iDtos.add(new itemDto(
       itemEntity.getCode(),itemEntity.getDesc(),itemEntity.getPack(),itemEntity.getUnitPrize(),itemEntity.getQoh()
       ));
               
       }
       return iDtos;
    }
        
    }

    
    
}
