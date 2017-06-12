package com.qbq.service;



import java.sql.SQLException;
import java.util.List;

import com.qbq.dao.SaleAndPurDao;
import com.qbq.domain.SaleAllInfo;
/**
 * 
* @ClassName: SaleAndPurImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author QianBingqiao 
* @date 2017年6月11日 下午6:21:06 
*
 */
public class SaleAndPurImpl extends DealAbs{
	SaleAndPurDao saleAndpurOpa;

	public SaleAndPurImpl() {
		super();
		// TODO Auto-generated constructor stub
		saleAndpurOpa = new SaleAndPurDao();
	}

	@Override
	public void enterPrompt() {
		// TODO Auto-generated method stub
		System.out.println("销售信息表 ");
		//	商品编号，商品名称，商品销售总量，商品采购总量，商品剩余库存，商品盈利总额等
			System.out.println("@goodsId @goodsName @saleQty  @purQty  @goodsQty  @gain");
	}

	@Override
	public int getImport() {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int doDeal() {
		// TODO Auto-generated method stub
		
		surchSaleAllInfo();
		return 0;
	}

	public int surchSaleAllInfo(){
		List<SaleAllInfo> saleInfoAll;
		try {
			saleInfoAll = saleAndpurOpa.selectSaleAllInfo();
			for(SaleAllInfo sale:saleInfoAll){
//				商品编号，商品名称，商品销售总量，商品采购总量，商品剩余库存，商品盈利总额等
				System.out.println("商品编号" +sale.getGoodsId()+" "+ "商品名称"+sale.getGoodsName()+" "
	             + "商品销售总量" +sale.getSaleCount()+" "+"商品采购总量"+sale.getPurCount()+" "+"商品剩余库存"+
						sale.getGoodsCount()+""+"商品盈利总额等"+sale.getGain());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return 0;
	}
	
}
