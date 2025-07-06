/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layerd.dao.custom.impl;

import edu.ijse.layerd.dao.CrudUtil;
import edu.ijse.layerd.dao.custom.OrderDao;
import edu.ijse.layerd.entity.OrderEntity;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class OrderDaoImpl implements OrderDao{

    @Override
    public boolean save(OrderDao t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Orders VALUES(?,?,?)",t.getOrderId,t.getDate(),t.getId());
    }

    @Override
    public boolean update(OrderDao t) throws Exception {
       return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
       return true;
    }

    @Override
    public OrderDao search(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<OrderDao> getAll() throws Exception {
       return null;
    }

    @Override
    public boolean save(OrderEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(OrderEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
