package cn.lht.dao;

import cn.lht.entity.BsStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BsStatus)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-24 16:11:09
 */
public interface BsStatusDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bsUserid 主键
     * @return 实例对象
     */
    BsStatus queryById(Integer bsUserid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsStatus> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bsStatus 实例对象
     * @return 对象列表
     */
    List<BsStatus> queryAll(BsStatus bsStatus);

    /**
     * 新增数据
     *
     * @param bsStatus 实例对象
     * @return 影响行数
     */
    int insert(BsStatus bsStatus);

    /**
     * 修改数据
     *
     * @param bsStatus 实例对象
     * @return 影响行数
     */
    int update(BsStatus bsStatus);

    /**
     * 通过主键删除数据
     *
     * @param bsUserid 主键
     * @return 影响行数
     */
    int deleteById(Integer bsUserid);

}