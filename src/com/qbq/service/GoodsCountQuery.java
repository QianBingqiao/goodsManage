package com.qbq.service;

import java.sql.SQLException;
import java.util.List;

import com.qbq.dao.GoodsDao;
import com.qbq.domain.Goods;

public class GoodsCountQuery extends DealAbs{
	GoodsDao goodsOpa;
	
	public GoodsCountQuery() {
		super();
		// TODO Auto-generated constructor stub
		goodsOpa = new GoodsDao();
	}

	@Override
	public void enterPrompt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getImport() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doDeal() {
		// TODO Auto-generated method stub
		queryGoodsQty();
		
		
		return 0;
	}
	
	//打印商品
	public int queryGoodsQty(){
		//查询数据
		List<Goods> goodsInfoList;
		try {
			goodsInfoList = goodsOpa.selectAll();
			for(Goods goodsInfo:goodsInfoList){
				System.out.println(goodsInfo.getGoodsId()+"    "+goodsInfo.getGoddsName()+"    "+goodsInfo.getGoodsQty());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
