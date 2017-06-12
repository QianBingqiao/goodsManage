package com.qbq.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qbq.dao.GoodsDao;
import com.qbq.dao.PurchaseDao;
import com.qbq.domain.Goods;
import com.qbq.domain.Purchase;
import com.qbq.utils.ServiceUtils;

public class PurAddImpl extends DealAbs {
	String purId;
	String goodsId;
	double price;
	int purQty;
	String date;
	String supplier;
	int remainQty;

	PurchaseDao opa;
	GoodsDao goodsOpa;

	public PurAddImpl() {
		opa = new PurchaseDao();
		goodsOpa = new GoodsDao();
	}

	@Override
	public void enterPrompt() {
		// TODO Auto-generated method stub
		System.out.println("添加采购信息 | 请输入以下信息：");
		System.out.println("@purId @goodsId @price @purQty @supplier");

	}

	@Override
	public int getImport() {
		// TODO Auto-generated method stub

		purId = scan.next();
		if (purId == null) {
			// setTrans_result("获取商品编号错误");
			return -1;
		}
		goodsId = scan.next();

		if (goodsId == null) {
			System.out.println("获取商品编号错误");
			return -1;
		}

		price = Double.parseDouble(scan.next());
		if (price == 0 || price == 0.0) {
			// setTrans_result("获取商品编号错误");
			return -1;
		}
		purQty = Integer.parseInt(scan.next());
		if (purQty == 0) {
			// setTrans_result("获取商品编号错误");
			return -1;
		}

		supplier = scan.next();
		if (supplier == null) {
			// setTrans_result("获取商品编号错误");
			return -1;
		}
		return 0;
	}

	@Override
	public int doDeal() {
		// TODO Auto-generated method stub
		// int result = 0;

		Purchase pur = new Purchase();
		pur.setPurId(purId);
		pur.setGoodsId(goodsId);
		pur.setPurPrice(price);
		pur.setPurQty(purQty);
		pur.setPurDate(ServiceUtils.format());
		pur.setSupplier(supplier);
		pur.setRemainQty(purQty);
		try {
			if(updateGoodsQty(pur) ==0){
				System.out.println("add purchase success!");
			}else{
				System.out.println("add purchase success!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	// 添加采购表信息，每次添加一次就先通过goodsId查询到对应商品的库存goodsQty,每次添加一次，就就在当前的基础上加上数量
	/**
	 * 
	 * @param pur
	 * @return
	 * @throws SQLException
	 */
	public int updateGoodsQty(Purchase pur) throws SQLException {
//		if(existGoodsId()){
//			
//		}
		opa.addPur(pur);
		String g_id = pur.getGoodsId();
		Goods goods = new Goods();
		goods = goodsOpa.selectGoodsId(g_id);
		int num = goods.getGoodsQty();
		num = num + pur.getPurQty();
		goods.setGoodsQty(num);
		goodsOpa.updateGoods(goods);
		return 0;
//		return -1;
	}
	//添加采购信息前必须先存在goodsId
	public boolean existGoodsId() throws SQLException {

		List<String> listId = new ArrayList<String>();
		listId = goodsOpa.countGoodsId();
		if (listId.contains(goodsId)) {
			return true;
		}
		return false;
	}

}
