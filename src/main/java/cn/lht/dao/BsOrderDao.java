package cn.lht.dao;

import cn.lht.entity.BsOrder;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (BsOrder)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-13 15:55:14
 */
public interface BsOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bsOrderid 主键
     * @return 实例对象
     */
    BsOrder queryById(Integer bsOrderid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsOrder> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bsOrder 实例对象
     * @return 对象列表
     */
    List<BsOrder> queryAll(BsOrder bsOrder);

    /**
     * 新增数据
     *
     * @param bsOrder 实例对象
     * @return 影响行数
     */
    int insert(BsOrder bsOrder);

    /**
     * 修改数据
     *
     * @param bsOrder 实例对象
     * @return 影响行数
     */
    int update(BsOrder bsOrder);

    /**
     * 通过主键删除数据
     *
     * @param bsOrderid 主键
     * @return 影响行数
     */
    int deleteById(Integer bsOrderid);

}