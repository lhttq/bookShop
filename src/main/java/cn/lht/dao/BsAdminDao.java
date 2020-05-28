package cn.lht.dao;


import cn.lht.entity.BsAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BsAdmin)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-24 16:09:13
 */
public interface BsAdminDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bsAdminid 主键
     * @return 实例对象
     */
    BsAdmin queryById(Integer bsAdminid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsAdmin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bsAdmin 实例对象
     * @return 对象列表
     */
    List<BsAdmin> queryAll(BsAdmin bsAdmin);

    /**
     * 新增数据
     *
     * @param bsAdmin 实例对象
     * @return 影响行数
     */
    int insert(BsAdmin bsAdmin);

    /**
     * 修改数据
     *
     * @param bsAdmin 实例对象
     * @return 影响行数
     */
    int update(BsAdmin bsAdmin);

    /**
     * 通过主键删除数据
     *
     * @param bsAdminid 主键
     * @return 影响行数
     */
    int deleteById(Integer bsAdminid);

}