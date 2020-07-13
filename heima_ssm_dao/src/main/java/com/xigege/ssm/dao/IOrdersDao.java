package com.xigege.ssm.dao;

import com.xigege.ssm.domain.Member;
import com.xigege.ssm.domain.Orders;
import com.xigege.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  IOrdersDao {
@Select("select * from orders ")
@Results({
        @Result(id=true,property = "id",column = "id"),
        @Result(property = "orderNum" ,column = "orderNum"),
        @Result(property = "orderTime" ,column = "orderTime"),
        @Result(property = "orderStatus" ,column = "orderStatus"),
        @Result(property = "peopleCount" ,column = "peopleCount"),
        @Result(property = "payType" ,column = "payType"),
        @Result(property = "orderDesc" ,column = "orderDesc"),
        @Result(property = "product" ,column = "productId",javaType = Product.class,one =@One( select ="com.xigege.ssm.dao.IProductDao.findById")),
})
    public List<Orders> findAll() throws Exception;


    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum" ,column = "orderNum"),
            @Result(property = "orderTime" ,column = "orderTime"),
            @Result(property = "orderStatus" ,column = "orderStatus"),
            @Result(property = "peopleCount" ,column = "peopleCount"),
            @Result(property = "payType" ,column = "payType"),
            @Result(property = "orderDesc" ,column = "orderDesc"),
            @Result(property = "product" ,column = "productId",javaType = Product.class,one =@One(select ="com.xigege.ssm.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberId" ,javaType= Member.class,one = @One(select = "com.xigege.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers", column = "id" ,javaType = java.util.List.class,many=@Many(select = "com.xigege.ssm.dao.ITravellerDao.findByOrdersId"))
    })
   public Orders findById(String ordersId) throws Exception;
}
