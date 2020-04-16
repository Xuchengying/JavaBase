package com.stx.epcs.dao;


import com.stx.epcs.entity.Case;
import com.stx.epcs.entity.Vrius;
import com.stx.epcs.util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 病人访问层
 */
public class CaseDao {
    VirusDao virusDao = new VirusDao();

    /**
     * 添加病人
     * @param cases
     * @return 影响的行数用于判断是否添加成功
     */
    public  int addCase(Case cases){
        //写出添加病人的sql 逻辑
        return JdbcUtil.executeUpdate("insert into tbl_cases values(seq_cases.nextval,'" + cases.getName() + "','"
                + cases.getProvince() + "','" + cases.getStatus() + "','" + cases.getVrius().getId() + "')");
    }

    /**
     * 根据病人id 删除病人信息
     * @param id
     * @return
     */
    public int deleteCaseByID(String id){
        //写出根据ID删除病人sql 逻辑
        return JdbcUtil.executeUpdate("delete from tbl_cases where id = " + id);
    }


    /**
     * 病人出院
     * @param id
     * @return
     */
    public  int caseOutHospt(String id){
        return JdbcUtil.executeUpdate("update tbl_cases set status = 2 where id = " + id);
    }

    /**
     * 获取病人的集合
     * @param sql
     * @return
     */
    public ArrayList<Case> getCases(String sql) {
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
            ArrayList<Case> arrayList =  new ArrayList();
            //完成对结果集的遍历，封装在病人对象里面 然后添加到数组里面
            while (rs.next()) {
                Case aCase = new Case();
                aCase.setId(rs.getInt("id"));
                aCase.setName(rs.getString("NAME"));
                aCase.setProvince(rs.getString("province"));
                aCase.setStatus(rs.getInt("status"));
                int virusid = rs.getInt("virusid");
                Vrius virus = virusDao.getVirus("select * from tbl_virus where id =" + virusid);
                aCase.setVrius(virus);
                arrayList.add(aCase);
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
