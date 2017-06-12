package com.qbq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qbq.domain.Goods;
import com.qbq.utils.DBUtity;

/**
 * 
 * @ClassName: GoodsDao
 * @Description: TODO(针对goods进行增删改查)
 * @author QianBingqiao
 * @date 2017年6月8日 上午11:10:05
 *
 */
public class GoodsDao {
	Connection conn;

	public GoodsDao() {
		try {
			conn = DBUtity.openConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// goods add
	/**
	 * 
	 * @param good
	 *            Goods类的对象
	 * @throws SQLException
	 */
	public int addGoods(Goods good) throws SQLException {
		String sql = "insert into goods(goodsId,goodsName,goodsUnit,goodsStatus,goodsQty)values(?,?,?,?,?)";
		// 使用PreparedStatement连接jdbc进行操作
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, good.getGoodsId());
		ps.setString(2, good.getGoddsName());
		ps.setString(3, good.getGoodsUnit());
		ps.setInt(4, good.getGoodsStatus());
		ps.setInt(5, good.getGoodsQty());
		int rs=ps.executeUpdate();
		if(rs !=0){
//			System.out.println("add goods success! ");
			return rs;
		}
//		System.out.println("add goods failed! ");
		if (ps != null) {
			ps.close();
		}
		return rs;  
		
	}

	// update goods
	/**
	 * 
	 * @param good
	 *            修改Goods 的对象
	 * @throws SQLException
	 */
	public void updateGoods(Goods good) throws SQLException {
		String sql = "update goods set goodsName=?,goodsUnit=?,goodsStatus=?,goodsQty=? where goodsId=?";
		// 使用PreparedStatement连接jdbc进行操作
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, good.getGoddsName());
		ps.setString(2, good.getGoodsUnit());
		ps.setInt(3, good.getGoodsStatus());
		ps.setInt(4, good.getGoodsQty());
		ps.setString(5, good.getGoodsId());
		int rs=ps.executeUpdate();
		if(rs>0){
			System.out.println("update goods success! ");
		}
//		    System.out.println("update goods failed! ");
		if (ps != null) {
			ps.close();
		}

	}

	// select goods
	/**
	 * 全部查询
	 * 
	 * @return List<Goods> 集合的对象list;
	 * @throws SQLException
	 */
	public List<Goods> selectAll() throws SQLException {
		List<Goods> list = new ArrayList<Goods>();
		String sql = "select * from goods";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Goods good = new Goods();
			good.setGoodsId(rs.getString("goodsId"));
			good.setGoddsName(rs.getString("goodsName"));
			good.setGoodsUnit(rs.getString("goodsUnit"));
			good.setGoodsStatus(rs.getInt("goodsStatus"));
			good.setGoodsQty(rs.getInt("goodsQty"));
			list.add(good);
		}
		System.out.println(list);
		if (ps != null) {
			ps.close();
		}

		return list;
	}

	/**
	 * 精确查找 通过商品编号来查找
	 * 
	 * @param id
	 *            商品编号
	 * @return Goods类中的good对象
	 * @throws SQLException
	 */
	public Goods selectGoodsId(String id) throws SQLException {
		Goods good = null;
		String sql = "select * from goods where goodsId=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			good = new Goods();
			good.setGoodsId(rs.getString("goodsId"));
			good.setGoddsName(rs.getString("goodsName"));
			good.setGoodsUnit(rs.getString("goodsUnit"));
			good.setGoodsStatus(rs.getInt("goodsStatus"));
			good.setGoodsQty(rs.getInt("goodsQty"));
		}
		System.out.println(good);
		if (ps != null) {
			ps.close();
		}

		return good;
	}

	/**
	 * 模糊查找 通过商品名称来查找
	 * 
	 * @param id
	 *            商品编号
	 * @return Goods类中的good对象
	 * @throws SQLException
	 */
	public List<Goods> selectGoodsName(String name) throws SQLException {
		List<Goods> list = new ArrayList<Goods>();
		String sql = "select * from goods where goodsName like ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%" +name +"%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Goods good = new Goods();
			good.setGoodsId(rs.getString("goodsId"));
			good.setGoddsName(rs.getString("goodsName"));
			good.setGoodsUnit(rs.getString("goodsUnit"));
			good.setGoodsStatus(rs.getInt("goodsStatus"));
			good.setGoodsQty(rs.getInt("goodsQty"));
			list.add(good);
		}
		System.out.println(list);
		if (ps != null) {
			ps.close();
		}
		return list;
	}

	/**
	 * 通过ID删除goods表中的数据
	 * 
	 * @param id
	 *            goodsId;
	 * @return
	 * @throws SQLException
	 */
	public int deleteGoodsId(String id) throws SQLException {
		String sql = "delete from goods where goodsId=? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		int rs = ps.executeUpdate();
		// if(rs>0){
		// System.out.println("删除成功!");
		// }
		// System.out.println("删除失败!");
		if (ps != null) {
			ps.close();
		}

		return rs;
	}
	/**
	 * 
	 * @return goodsId 的list集合
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
			goodsId=rs.getString("goodsId");
			listId.add(goodsId);
		}
		System.out.println(listId);
		if (ps != null) {
			ps.close();
		}
		return listId;
	}

}
