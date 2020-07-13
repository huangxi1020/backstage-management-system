package com.xigege.ssm.dao;

import com.xigege.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

@Select("select * from traveller where id in(select travellerId from order_traveller where orderid =#{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId)throws Exception;
}
