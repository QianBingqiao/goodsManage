package com.qbq.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qbq.dao.GoodsDao;
import com.qbq.domain.Goods;

public class GoodsQueryImpl extends DealAbs {
	String query_type;
	String goods_id;
	String goods_name;

	Goods goods;
	GoodsDao opa;

	public GoodsQueryImpl() {
		opa = new GoodsDao();
	}

	public GoodsQueryImpl(String query_type, String goods_id, String goods_name) {
		super();
		this.query_type = query_type;
		this.goods_id = goods_id;
		this.goods_name = goods_name;
	}

	@Override
	public void enterPrompt() {
		// TODO Auto-generated method stub
		System.out.println("查询商品信息");
		System.out.println("query_type: 0-全部查询        1-精确查询      2-模糊查询");
	}

	@Override
	public int getImport() {
		// TODO Auto-generated method stub
		query_type = scan.next();
		if (query_type == null) {
			// setDeal_result("获取查询方式错误");
			return -1;
		}
		return 0;
	}

	@Override
	public int doDeal() {
		if (query_type.equals("0")) { // 全部查询
			try {
				opa.selectAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (query_type.equals("1")) { // 精确查询
			System.out.println("@query_type  精确查询        @goods_id");
			goods_id = scan.next();
			try {
				opa.selectGoodsId(goods_id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (query_type.equals("2")) { // 模糊查询
			System.out.println("@query_type  模糊查询            @goods_name");
			goods_name = scan.next();
			try {
				opa.selectGoodsName(goods_name);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

}
