package com.qbq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qbq.domain.SaleAllInfo;
import com.qbq.domain.SaleAndPur;
import com.qbq.utils.DBUtity;
/**
 * 
* @ClassName: SaleAndPurDao 
* @Description: TODO(SaleAndPur的表操作) 
* @author QianBingqiao 
* @date 2017年6月9日 上午9:39:55 
*
 */
public class SaleAndPurDao {

	Connection conn;

	public SaleAndPurDao() {
		try {
			conn = DBUtity.openConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 添加报表数据
	 * @param saleAndPur
	 * @throws SQLException
	 */
	public void addSaleAndPur(SaleAndPur saleAndPur) throws SQLException {
		String sql = "insert into saleAndpur(saleId,purId,goodsId,purPrice,salePrice,currentQty)"
				+ "values(?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, saleAndPur.getSaleId());
		ps.setString(2, saleAndPur.getPurId());
		ps.setString(3, saleAndPur.getGoodsId());
		ps.setDouble(4, saleAndPur.getPurPrice());
		ps.setDouble(5, saleAndPur.getSalePrice());
		ps.setInt(6, saleAndPur.getCurrentQty());
		int rs = ps.executeUpdate();
		if (rs > 0) {
			System.out.println("add success!");
		}
		System.out.println("add failed!");
		if (ps != null) {
			ps.close();
		}	
	}
	/**
	 * 全部查询报表数据
	 * @return
	 * @throws SQLException
	 */
	public List<SaleAndPur> selectSaleAndPur() throws SQLException {
		List<SaleAndPur> list =new ArrayList<SaleAndPur>();
		SaleAndPur saleAndp = null;
		String sql = "select * from saleAndpur";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			saleAndp = new SaleAndPur();
			saleAndp.setSaleId(rs.getString("saleId"));
			saleAndp.setPurId(rs.getString("purId"));
			saleAndp.setGoodsId(rs.getString("goodsId"));
			saleAndp.setPurPrice(rs.getDouble("purPrice"));
			saleAndp.setSalePrice(rs.getDouble("salePrice"));
			saleAndp.setCurrentQty(rs.getInt("currentQty"));
			list.add(saleAndp);	
		}
		if(list != null){
			System.out.println("select saleAndPur Table Success!");
		}
		if (ps != null) {
			ps.close();
		}
		return list;
	}
	public List<SaleAndPur> selectSaleAndPurBy(String goodsId) throws SQLException {
		List<SaleAndPur> list =new ArrayList<SaleAndPur>();
		SaleAndPur saleAndp = null;
		String sql = "select * from saleAndpur";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			saleAndp = new SaleAndPur();
			saleAndp.setSaleId(rs.getString("saleId"));
			saleAndp.setPurId(rs.getString("purId"));
			saleAndp.setGoodsId(rs.getString("goodsId"));
			saleAndp.setPurPrice(rs.getDouble("purPrice"));
			saleAndp.setSalePrice(rs.getDouble("salePrice"));
			saleAndp.setCurrentQty(rs.getInt("currentQty"));
			list.add(saleAndp);	
		}
		if(list != null){
			System.out.println("select saleAndPur Table Success!");
		}
		if (ps != null) {
			ps.close();
		}
		return list;
	}
	
	public List<SaleAllInfo> selectSaleAllInfo() throws SQLException{
		List<SaleAllInfo> list = new ArrayList<SaleAllInfo>();
		
		String sql = "select g.goodsId,g.goodsName,g.goodsQty,sum(s.currentQty) as salecount,"
				+ "sum(s.purPrice*s.currentQty) as purPricecount,sum(s.salePrice*s.currentQty) as salePricecount "
				+ "from goods g,saleAndpur s where g.goodsId=s.goodsId group by g.goodsId";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			SaleAllInfo sale = new SaleAllInfo();
			sale.setGoodsId(rs.getString("goodsId"));
			sale.setGoodsName(rs.getString("goodsName"));
			sale.setSaleCount(rs.getInt("salecount"));
			sale.setPurCount(rs.getInt("goodsQty" + rs.getInt("salecount")));
			sale.setGoodsCount(rs.getInt("goodsQty"));
			sale.setGain(rs.getInt("salePricecount") - rs.getInt("purPricecount"));
			list.add(sale);
		}
		if(list != null){
			System.out.println("select saleAndPur Table Success!");
		}
		if (ps != null) {
			ps.close();
		}
		return list;
	}
}
