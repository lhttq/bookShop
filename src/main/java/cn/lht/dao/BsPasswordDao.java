package cn.lht.dao;

import cn.lht.entity.BsPassword;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BsPassword)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-24 16:10:47
 */
public interface BsPasswordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bsUserid 主键
     * @return 实例对象
     */
    BsPassword queryById(Object bsUserid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsPassword> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bsPassword 实例对象
     * @return 对象列表
     */
    List<BsPassword> queryAll(BsPassword bsPassword);

    /**
     * 新增数据
     *
     * @param bsPassword 实例对象
     * @return 影响行数
     */
    int insert(BsPassword bsPassword);

    /**
     * 修改数据
     *
     * @param bsPassword 实例对象
     * @return 影响行数
     */
    int update(BsPassword bsPassword);

    /**
     * 通过主键删除数据
     *
     * @param bsUserid 主键
     * @return 影响行数
     */
    int deleteById(Object bsUserid);

}