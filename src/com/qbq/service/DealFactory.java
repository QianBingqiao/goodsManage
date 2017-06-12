package com.qbq.service;

public class DealFactory {
	public AllInterface createDeal(String str) {
		AllInterface deal = null;
		if (str.equals("1")) {
			deal = new GoodsAddImpl();
		} else if (str.equals("2")) {
			deal = new GoodsModifyImpl();
		} else if (str.equals("3")) {
			deal = new GoodsQueryImpl();
		} else if (str.equals("4")) {
			deal = new PurAddImpl();
		} else if (str.equals("5")) {
			deal = new SaleAddImpl();
		} else if (str.equals("6")) {
			deal = new SaleAndPurImpl();
		}
		else if (str.equals("7")) {
			deal = new GoodsCountQuery();
		}else {
			System.out.println("输入指令无效");
		}
		return deal;
	}

}
