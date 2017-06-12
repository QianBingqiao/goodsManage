package com.qbq.service;

import java.sql.SQLException;

import com.qbq.dao.GoodsDao;
import com.qbq.domain.Goods;

public class GoodsModifyImpl extends DealAbs {
	private String goods_id;
	private String goods_name;
	private String goods_unit;
	private String goods_status;
	// private String goods_qty;

	GoodsDao opa;
	Goods goods;

	public GoodsModifyImpl() {
		opa = new GoodsDao();
	}

	@Override
	public void enterPrompt() {
		// TODO Auto-generated method stub
		System.out.println("修改商品信息 | 输入以下信息");
		System.out.println("@goods_id @goods_name @goods_unit @goods_status");

	}

	@Override
	public int getImport() {
		goods_id = scan.next();
		if (goods_id == null) {

			System.out.println("获取商品编号失败");
			return -1;
		}

		goods_name = scan.next();
		if (goods_name == null) {

			System.out.println("修改商品名称失败");
			return -1;
		}

		goods_unit = scan.next();
		if (goods_unit == null) {

			System.out.println("修改商品单位失败");
			return -1;
		}

		goods_status = scan.next();
		if (goods_status == null) {
			System.out.println("修改商品状态失败");

			return -1;
		}
		// goods_qty = scan.next();
		// if (goods_qty == null) {
		// System.out.println("修改商品库存失败");

		// return -1;
		// }
		return 0;
	}

	@Override
	public int doDeal() {
		// TODO Auto-generated method stub
		goods = new Goods();
		goods.setGoodsId(goods_id);
		goods.setGoddsName(goods_name);
		goods.setGoodsUnit(goods_unit);
		goods.setGoodsStatus(Integer.parseInt(goods_status));
		// goods.setGoodsQty(Integer.parseInt(goods.));
		try {
			opa.updateGoods(goods);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
