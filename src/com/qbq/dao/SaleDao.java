package com.qbq.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qbq.domain.Purchase;
import com.qbq.domain.Sale;
import com.qbq.domain.SaleAndPur;
import com.qbq.utils.DBUtity;

/**
 * 
 * @ClassName: SaleDao
 * @Description: TODO(Sale 对象操作类)
 * @author QianBingqiao
 * @date 2017年6月8日 下午7:30:33
 *
 */
public class SaleDao {
	Connection conn;
	PurchaseDao purOpa;
	SaleAndPurDao saleOpa;

	public SaleDao() {
		try {
			purOpa = new PurchaseDao();
			saleOpa = new SaleAndPurDao();
			conn = DBUtity.openConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 添加销售信息
	 * 
	 * @param sale
	 * @throws SQLException
	 */
	public void addSale(Sale sale) throws SQLException {
		String sql = "insert into sale(saleId,goodsId,saleQty,salePrice,saleDate)values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, sale.getSaleId());
		ps.setString(2, sale.getGoodsId());
		ps.setInt(3, sale.getSaleQty());
		ps.setDouble(4, sale.getSalePrice());
		ps.setDate(5, Date.valueOf(sale.getSaleDate()));
		int rs = ps.executeUpdate();
		if (rs > 0) {
			System.out.println("插入销售信息成功！");
		}
		if (ps != null) {
			ps.close();
		}
	}

	/**
	 * 修改销售信息(基本不用)
	 * 
	 * @param sale
	 * @throws SQLException
	 */
	public void modifySale(Sale sale) throws SQLException {
		String sql = "update sale set goodsId=?,saleQty=?,salePrice=?,saleDate=? where saleId=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, sale.getGoodsId());
		ps.setInt(2, sale.getSaleQty());
		ps.setDouble(3, sale.getSalePrice());
		ps.setDate(4, Date.valueOf(sale.getSaleDate()));
		ps.setString(5, sale.getSaleId());
		int rs = ps.executeUpdate();
		if (rs > 0) {
			System.out.println("修改销售信息成功！");
		}
		if (ps != null) {
			ps.close();
		}
	}

	/***
	 * 全部查询
	 * 
	 * @return List<Sale> sale的对象
	 * @throws SQLException
	 */
	public List<Sale> selectAllSale() throws SQLException {
		List<Sale> list = new ArrayList<Sale>();
		Sale sale = null;
		String sql = "select * from sale";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			sale = new Sale();
			sale.setSaleId(rs.getString("saleId"));
			sale.setGoodsId(rs.getString("goodsId"));
			sale.setSaleQty(rs.getInt("saleQty"));
			sale.setSalePrice(rs.getDouble("salePrice"));
			sale.setSaleDate(String.valueOf(rs.getDate("saleDate")));
			list.add(sale);
		}
		System.out.println(list);
		if (ps != null) {
			ps.close();
		}
		return list;
	}

	/***
	 * 精确查找
	 * 
	 * @return Sale对象
	 * @throws SQLException
	 */
	public Sale selectSaleId(String id) throws SQLException {
		Sale sale = null;
		String sql = "select * from sale where saleId=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			sale = new Sale();
			sale.setSaleId(rs.getString("saleId"));
			sale.setGoodsId(rs.getString("goodsId"));
			sale.setSaleQty(rs.getInt("saleQty"));
			sale.setSalePrice(rs.getDouble("salePrice"));
			sale.setSaleDate(String.valueOf(rs.getDate("saleDate")));

		}
		System.out.println(sale);
		if (ps != null) {
			ps.close();
		}
		return sale;
	}

	/**
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public void deleteSaleId(String id) throws SQLException {
		Sale sale = null;
		String sql = "delete from sale where saleId=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		int rs = ps.executeUpdate();
		if (rs > 0) {

			System.out.println("delete success!");
		}
		System.out.println("delete failed!");
		if (ps != null) {
			ps.close();
		}
	}
//	/**
//	 * 通过
//	 * @param goodsId
//	 * @throws SQLException
//	 */
//	public void saleAddUpdate(String goodsId) throws SQLException {
//		List<Purchase> purList = new ArrayList<Purchase>();
//		// List<Sale> saleAndpurList = new ArrayList<Sale>();
//		Purchase pur = purOpa.selectPurId(goodsId);
//		Sale sale = selectSaleId(goodsId);
//		int RemainQty = pur.getRemainQty();
//		int saleQty = sale.getSaleQty();
//		purList = purOpa.selectAllPur();
//		int num = RemainQty - saleQty;
//		for (Purchase purs : purList) {
//			
//			if (num >= 0) {
//				purs.setRemainQty(num);
//				purOpa.modifyPur(purs);
//				new SaleAndPurDao().addSaleAndPur(new SaleAndPur(sale.getSaleId(), purs.getPurId(), goodsId,
//						purs.getPurPrice(), sale.getSalePrice(), saleQty));
//				break;
//			} else {
//				purs.setRemainQty(0);
//				purOpa.modifyPur(purs);
//				sale.setSaleQty(Math.abs(num));
//				new SaleAndPurDao().addSaleAndPur(new SaleAndPur(sale.getSaleId(), purs.getPurId(), goodsId,
//						purs.getPurPrice(), sale.getSalePrice(), RemainQty));
//				continue;
//			}
//		}
//	}

}
