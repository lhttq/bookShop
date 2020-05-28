package cn.lht.dao;

import cn.lht.entity.BsAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BsAddress)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-28 21:34:48
 */
public interface BsAddressDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bsAddressid 主键
     * @return 实例对象
     */
    BsAddress queryById(Integer bsAddressid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsAddress> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bsAddress 实例对象
     * @return 对象列表
     */
    List<BsAddress> queryAll(BsAddress bsAddress);

    /**
     * 新增数据
     *
     * @param bsAddress 实例对象
     * @return 影响行数
     */
    int insert(BsAddress bsAddress);

    /**
     * 修改数据
     *
     * @param bsAddress 实例对象
     * @return 影响行数
     */
    int update(BsAddress bsAddress);

    /**
     * 通过主键删除数据
     *
     * @param bsAddressid 主键
     * @return 影响行数
     */
    int deleteById(Integer bsAddressid);

}