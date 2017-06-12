package com.qbq.service;

import java.sql.SQLException;

import com.qbq.dao.GoodsDao;
import com.qbq.domain.Goods;

public class GoodsAddImpl extends DealAbs{
	private String goods_id;//商品编号
	private String goods_name;//商品名称
	private String goods_unit;//商品单位
	
	GoodsDao opa;
	Goods goods;
	
	public GoodsAddImpl(){
		opa = new GoodsDao();
		
		
	}
	@Override
	public void enterPrompt() {
		System.out.println("添加商品，请输入以下信息");
		System.out.println("@goods_id @goods_name @goods_unit");

		
	}

	@Override
	public int getImport() {
		// 获取商品编号
		goods_id = scan.next();
		if (goods_id == null) {
			System.out.println("获取商品编号错误");
			return -1;
		}

		// 获取商品名称
		goods_name = scan.next();
		if (goods_name == null) {
			System.out.println("获取商品名称错误");
			return -1;
		}

		// 获取商品单位
		goods_unit = scan.next();
		if (goods_unit == null) {
			System.out.println("获取商品单位错误");
			return -1;
		}
		System.out.print("goods_id[" + goods_id + "], ");
		System.out.print("goods_name[" + goods_name + "], ");
		System.out.println("goods_unit[" + goods_unit + "] ");
		
		return 0;
	}

	@Override
	public int doDeal() {
		// TODO Auto-generated method stub
		int result =0;
		goods = new Goods();
		goods.setGoodsId(goods_id);
		goods.setGoddsName(goods_name);
		goods.setGoodsUnit(goods_unit);
		try {
			 result = opa.addGoods(goods);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>0){
			System.out.println("add goods success! ");
			return 0;
		}else{
			System.out.println("add goods failed! ");
			return -1;
		}
		
	}

}
