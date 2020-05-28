package cn.lht.dao;

import cn.lht.entity.BsCarts;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BsCarts)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-03 20:53:54
 */
public interface BsCartsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bsCartid 主键
     * @return 实例对象
     */
    BsCarts queryById(Integer bsCartid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsCarts> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bsCarts 实例对象
     * @return 对象列表
     */
    List<BsCarts> queryAll(BsCarts bsCarts);
    /**
     * 新增数据
     *
     * @param bsCarts 实例对象
     * @return 影响行数
     */
    int insert(BsCarts bsCarts);

    /**
     * 修改数据
     *
     * @param bsCarts 实例对象
     * @return 影响行数
     */
    int update(BsCarts bsCarts);

    /**
     *
     * @param bsCarts 实例对象
     * @return 影响行数
     */
    int updateIs(BsCarts bsCarts);

    /**
     * 通过主键删除数据
     *
     * @param bsCarts 对象
     * @return 影响行数
     */
    int deleteByUseridAndBookid(BsCarts bsCarts);

}