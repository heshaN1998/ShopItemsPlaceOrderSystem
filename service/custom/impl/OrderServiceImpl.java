/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layerd.service.custom.impl;

import edu.ijse.layerd.dao.DaoFactory;
import static edu.ijse.layerd.dao.DaoFactory.DaoTypes.ITEM;
import static edu.ijse.layerd.dao.DaoFactory.DaoTypes.ORDER;
import static edu.ijse.layerd.dao.DaoFactory.DaoTypes.ORDER_DETAIL;
import edu.ijse.layerd.dao.custom.ItemDao;
import edu.ijse.layerd.dao.custom.OrderDao;
import edu.ijse.layerd.dao.custom.OrderDetailDao;
import edu.ijse.layerd.db.DBConnection;
import edu.ijse.layerd.dto.OrderDto;
import edu.ijse.layerd.entity.ItemEntity;
import edu.ijse.layerd.entity.OrderDetailEntity;
import edu.ijse.layerd.entity.OrderEntity;
import edu.ijse.layerd.service.custom.OrderService;
import java.sql.Connection;
/**
 *
 * @author ACER
 */
public class OrderServiceImpl implements OrderService{
private itemDao itemDao = (ItemDao) DaoFactory.getInstance().geDao(DaoFactory.DaoTypes,ITEM);
private OrderDao orderDao=(OrderDao)DaoFactory.getInstance().geDao(DaoFactory.DaoTypes,ORDER);
private OrderDetailDao orderDetailDto =(OrderDetailDao)DaoFactory.getInstance().geDao(DaoFactory,ORDER_DETAIL);
    @Override
    public String placeOrder(OrderDto orderDto) throws Exception {
     Connection connection=DBConnection.getInstance().getConnection();
        try {
         connection.setAutoCommit(false);
         OrderEntity orderEntity = new OrderEntity(orderDto.getOrderId(),orderDto.getDate(),orderDto.getCustomerId());
         if(orderDao.save(orderEntity)){
         boolean isOrderDetailSaved = true;
         for(OrderDertailDto orderDto : OrderDto.getOrderDetailDtos()){
         orderEntity orderDetailEntity = new OrderDetailEntity(orderDto.getOrderId(), orderDetailDto.getIemCode(), orderDetailDto.getQty(), orderDetailDto.getDiscount());
         if(!orderDetailDao.save(orderDetailEntity)){
         isOrderDetailSaved=false;
         }
         
         }
         if(OrderDetailSaved){
         boolean isItemUpdate=true;
         for(orderDetailDto orderDetailDto : orderDto.getOrderDetailDtos()){
             ItemEntity itemEntity = ItemDao.search(orderDetailDto.getItemCode());
             itemEntity.setQoh(itemEntity.getQoh() - orderDetailDto.getQty());
             if(!itemDao.update(itemEntity)){
             isItemUpdate=false;
             }
         }
             if (isItemUpdate) {
                 connection.commit();
                 return "succes";
                 
             }
             else{
             connection.rollback();
             return "Item Update Error";
             }
         }
         else{
         connection.rollback();
         return "Order Detail Save Error";
         }
         }
         else{
         connection.rollback();
         return "Order Save Error";
         }
         
        } catch (Exception e) {
            connection.rollback();
            return e.getMessage();
        } finally {
        connection.setAutoCommit(true);
        }
    }
    
}
