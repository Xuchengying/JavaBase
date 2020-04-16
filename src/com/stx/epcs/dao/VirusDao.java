package com.stx.epcs.dao;


import com.stx.epcs.entity.Vrius;
import com.stx.epcs.util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 病毒访问层
 */
public class VirusDao {

    /**
     * 添加病毒
     * @param vrius
     * @return 影响的行数
     */
    public  int addVrius(Vrius vrius){
        return JdbcUtil.executeUpdate("insert into tbl_virus values(seq_virus.nextval, '"
                +vrius.getName()+"','"+vrius.getDescrip()+"')");
    }

    /**
     * 根据ID 删除病毒
     * @param id
     * @return
     */
    public  int deleteVriusById(int id){
        return JdbcUtil.executeUpdate("delete from tbl_virus where id = " + id);
    }

    /**
     * 修改病毒
     * @param vrius
     * @return 影响的行数
     */
    public  int updateVrius(Vrius vrius){
        return JdbcUtil.executeUpdate("update tbl_virus set name='"+vrius.getName()+"',descrip ='"
                +vrius.getDescrip()+"'  where id = "+vrius.getId());
    }

    /**
     * 获取一个病毒
     */
    public Vrius getVirus(String sql) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            //获取连接
            conn = JdbcUtil.getConnection();
            //获取 Statement
            st = conn.createStatement();
            // 执行操作
            rs = st.executeQuery(sql);
            //先取出数据 保存在一个对象里面
            Vrius virus = new Vrius();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("NAME");
                String descc = rs.getString("descrip");
//                System.out.println(id + ", " + name + ", " + descc);
                virus.setId(id);
                virus.setName(name);
                virus.setDescrip(descc);
                return virus;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            JdbcUtil.closeConnection(conn, st, rs);
        }
    }

    /**
     * 获取一个数组的集合
     * @param sql
     * @return
     */
    public ArrayList<Vrius> getViruses(String sql) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            //获取连接
            conn = JdbcUtil.getConnection();
            //获取 Statement
            st = conn.createStatement();
            // 执行操作
            rs = st.executeQuery(sql);
            //先取出数据 保存在一个对象里面
            ArrayList<Vrius> arrayList =  new ArrayList();
            while (rs.next()) {
                Vrius virus = new Vrius();
                int id = rs.getInt("id");
                String name = rs.getString("NAME");
                String descc = rs.getString("descrip");
                virus.setId(id);
                virus.setName(name);
                virus.setDescrip(descc);
                arrayList.add(virus);
            }
            return arrayList;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            JdbcUtil.closeConnection(conn, st, rs);
        }
    }

}
