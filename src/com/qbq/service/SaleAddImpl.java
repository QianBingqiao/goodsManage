package com.qbq.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qbq.dao.GoodsDao;
import com.qbq.dao.PurchaseDao;
import com.qbq.dao.SaleAndPurDao;
import com.qbq.dao.SaleDao;
import com.qbq.domain.Goods;
import com.qbq.domain.Purchase;
import com.qbq.domain.Sale;
import com.qbq.domain.SaleAndPur;
import com.qbq.utils.ServiceUtils;

public class SaleAddImpl extends DealAbs {
	String saleId;
	String goodsId;
	double price;
	int saleQty;
	String date;

	PurchaseDao purOpa;
	GoodsDao goodsOpa;
	SaleDao saleOpa;
	SaleAndPurDao sale_purOpa;

	public SaleAddImpl() {
		purOpa = new PurchaseDao();
		goodsOpa = new GoodsDao();
		saleOpa = new SaleDao();
		sale_purOpa = new SaleAndPurDao();
	}

	@Override
	public void enterPrompt() {
		// TODO Auto-generated method stub
		System.out.println("添加销售信息 | 请输入以下信息：");
		System.out.println("@saleId @goodsId @price @saleQty");
	}

	@Override
	public int getImport() {
		// TODO Auto-generated method stub
		saleId = scan.next();
		if (saleId == null) {
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
		saleQty = Integer.parseInt(scan.next());
		
		if (saleQty == 0) {
			// setTrans_result("获取商品编号错误");
			return -1;
		}

		// supplier = scan.next();
		// if (supplier == null) {
		// // setTrans_result("获取商品编号错误");
		// return -1;
		// }

		return 0;
	}

	@Override
	public int doDeal() {
		// TODO Auto-generated method stub
		Sale sale = new Sale();
		sale.setSaleId(saleId);
		sale.setGoodsId(goodsId);
		sale.setSalePrice(price);
		sale.setSaleQty(saleQty);
		sale.setSaleDate(ServiceUtils.format());
//		try {
//			saleOpa.addSale(sale);
//			saleOpa.saleAddUpdate(goodsId);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			updateSale(sale);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int updateSale(Sale sale) throws SQLException {
		SaleAndPur sale_pur = new SaleAndPur();
		int saleQty = sale.getSaleQty();
		Goods goods = goodsOpa.selectGoodsId(sale.getGoodsId());
		if(goods !=null){
			int goodsQty = goods.getGoodsQty();
			//先判断库存是否大于销售量
			if(goodsQty<saleQty){
				return -1;
			}else{
				goods.setGoodsQty(goodsQty-saleQty);
				goodsOpa.updateGoods(goods);
			}
		}else{
			return -1;
		}
		//add
		saleOpa.addSale(sale);
		List<Purchase> list = purOpa.selectGoodsId(sale.getGoodsId());
		for(Purchase pur:list){
			int remainQty = pur.getRemainQty();
			if(remainQty>saleQty){
//				pur.setRemainQty(remainQty);
				purOpa.modifyPur(pur.getPurId(), pur.getGoodsId(), remainQty-saleQty);
				sale_pur.setCurrentQty(saleQty);
				sale_pur.setGoodsId(pur.getGoodsId());
				sale_pur.setPurId(pur.getPurId());
				sale_pur.setPurPrice(pur.getPurPrice());
				sale_pur.setSalePrice(sale.getSalePrice());
				sale_pur.setSaleId(sale.getSaleId());
				saleQty =0;
				sale_purOpa.addSaleAndPur(sale_pur);
				break;
			}else{
				saleQty = saleQty - remainQty;
				pur.setRemainQty(0);
				purOpa.modifyPur(pur.getPurId(), pur.getGoodsId(), pur.getRemainQty());
				sale_pur.setCurrentQty(remainQty);
				sale_pur.setGoodsId(pur.getGoodsId());
				sale_pur.setPurId(pur.getPurId());
				sale_pur.setPurPrice(pur.getPurPrice());
				sale_pur.setSalePrice(sale.getSalePrice());
				sale_pur.setSaleId(sale.getSaleId());
				sale_purOpa.addSaleAndPur(sale_pur);
				continue;
			}
		}
		return 0;
	}

}
