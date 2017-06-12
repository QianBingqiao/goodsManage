package com.qbq.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qbq.domain.Purchase;
import com.qbq.utils.DBUtity;


/**
 * 
 * @ClassName: PurchaseDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author QianBingqiao
 * @date 2017年6月8日 下午2:36:29
 *
 */
public class PurchaseDao {
	Connection conn;

	// 无参数构造
	public PurchaseDao() {
		try {
			conn = DBUtity.openConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 添加
	 * 
	 * @param pur
	 * @throws SQLException
	 */
	public int addPur(Purchase pur) throws SQLException {

		String sql = "insert into purchase(purId,goodsId,purPrice,purQty,purDate,supplier,remainQty)values(?,?,?,?,?,?,?)";
		// 使用PreparedStatement连接jdbc进行操作
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, pur.getPurId());
		ps.setString(2, pur.getGoodsId());
		ps.setDouble(3, pur.getPurPrice());
		ps.setInt(4, pur.getPurQty());
		ps.setDate(5, Date.valueOf(pur.getPurDate()));
		ps.setString(6, pur.getSupplier());
		ps.setInt(7, pur.getRemainQty());
		int rs=ps.executeUpdate();
		if (ps != null) {
			ps.close();
		}
	return rs;
	}

	/**
	 * 修改
	 * 
	 * @param pur
	 * @throws SQLException
	 */
	public void modifyPur(Purchase pur) throws SQLException {
		String sql = "update purchase set goodsId=?,purPrice=?,purQty=?,purDate=?,supplier=?,remainQty=? where purId=?";
		// 使用PreparedStatement连接jdbc进行操作
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, pur.getGoodsId());
		ps.setDouble(2, pur.getPurPrice());
		ps.setInt(3, pur.getPurQty());
		ps.setDate(4, Date.valueOf(pur.getPurDate()));
		ps.setString(5, pur.getSupplier());
		ps.setInt(6, pur.getRemainQty());
		ps.setString(7, pur.getPurId());
		ps.executeUpdate();
		if (ps != null) {
			ps.close();
		}
	}
	/**
	 * 修改 remainQty 通过  purID
	 * @param id
	 * @param remainQty
	 * @throws SQLException
	 */
	public void modifyPur(String id,String goodsId,int remainQty ) throws SQLException {
		String sql = "update purchase set remainQty=? where purId=? and goodsId";
		// 使用PreparedStatement连接jdbc进行操作
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, remainQty);
		ps.setString(2, id);
		ps.setString(3, goodsId);
		ps.executeUpdate();
		if (ps != null) {
			ps.close();
		}
	}

	/**
	 * 全部查询
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Purchase> selectAllPur() throws SQLException {
		List<Purchase> list = new ArrayList<Purchase>();
		String sql = "select * from purchase";
		// 使用PreparedStatement连接jdbc进行操作
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Purchase pur = new Purchase();
			pur.setPurId(rs.getString("purId"));
			pur.setGoodsId(rs.getString("goodsId"));
			pur.setPurPrice(rs.getDouble("purPrice"));
			pur.setPurQty(rs.getInt("purQty"));
			pur.setPurDate(String.valueOf(rs.getDate("purDate")));
			pur.setSupplier(rs.getString("supplier"));
			pur.setRemainQty(rs.getInt("remainQty"));
			list.add(pur);
		}
		System.out.println(list);
		if (ps != null) {
			ps.close();
		}
		return list;
	}

	/**
	 * 通过ID精确查找
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Purchase selectPurId(String id) throws SQLException {
		Purchase pur = null;
		String sql = "select * from purchase where purId=?";
		// 使用PreparedStatement连接jdbc进行操作
		PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pur = new Purchase();
			pur.setPurId(rs.getString("purId"));
			pur.setGoodsId(rs.getString("goodsId"));
			pur.setPurPrice(rs.getDouble("purPrice"));
			pur.setPurQty(rs.getInt("purQty"));
			pur.setPurDate(String.valueOf(rs.getDate("purDate")));
			pur.setSupplier(rs.getString("supplier"));
			pur.setRemainQty(rs.getInt("remainQty"));

		}
		System.out.println(pur);
		if (ps != null) {
			ps.close();
		}
		return pur;
	}
	public List<Purchase> selectGoodsId(String goodsId) throws SQLException {
		List<Purchase> list  = new ArrayList<Purchase>();
		Purchase pur = null;
		String sql = "select * from purchase where goodsId=? order by purDate asc";
		// 使用PreparedStatement连接jdbc进行操作
		PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, goodsId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pur = new Purchase();
			pur.setPurId(rs.getString("purId"));
			pur.setGoodsId(rs.getString("goodsId"));
			pur.setPurPrice(rs.getDouble("purPrice"));
			pur.setPurQty(rs.getInt("purQty"));
			pur.setPurDate(String.valueOf(rs.getDate("purDate")));
			pur.setSupplier(rs.getString("supplier"));
			pur.setRemainQty(rs.getInt("remainQty"));
			list.add(pur);

		}
//		System.out.println(pur);
		if (ps != null) {
			ps.close();
		}
		return list;
	}
	/**
	 * 
	 * @return goodsId 的list
	 * @throws SQLException
	 */
	public List<String> countGoodsId() throws SQLException {
		List<String> listId = new ArrayList<String>();
		String goodsId = null;
		String sql = "select goodsId count from goods group by goodsId";
		// 使用PreparedStatement连接jdbc进行操作
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
			goodsId=rs.getString("purId");

			listId.add(goodsId);
		}
		System.out.println(listId);
		if (ps != null) {
			ps.close();
		}
		return listId;
	}

}
