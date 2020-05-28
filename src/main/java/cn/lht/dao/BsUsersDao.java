package cn.lht.dao;

import cn.lht.entity.BsUsers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BsUsers)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-24 16:11:18
 */
public interface BsUsersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bsUserid 主键
     * @return 实例对象
     */
    BsUsers queryById(Integer bsUserid);

    /**
     * 通过用户名查询单条数据
     *
     * @param bsLoginname 用户名
     * @return 实例对象
     */
    BsUsers queryByuserLoginName(String bsLoginname);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsUsers> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bsUsers 实例对象
     * @return 对象列表
     */
    List<BsUsers> queryAll(BsUsers bsUsers);

    /**
     * 新增数据
     *
     * @param bsUsers 实例对象
     * @return 影响行数
     */
    int insert(BsUsers bsUsers);

    /**
     * 修改数据
     *
     * @param bsUsers 实例对象
     * @return 影响行数
     */
    int update(BsUsers bsUsers);

    /**
     * 通过主键删除数据
     *
     * @param bsUserid 主键
     * @return 影响行数
     */
    int deleteById(Object bsUserid);

}