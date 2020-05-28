package cn.lht.dao;

import cn.lht.entity.BsRejectreason;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BsRejectreason)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-24 16:10:57
 */
public interface BsRejectreasonDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bsRejectreasonid 主键
     * @return 实例对象
     */
    BsRejectreason queryById(Integer bsRejectreasonid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsRejectreason> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bsRejectreason 实例对象
     * @return 对象列表
     */
    List<BsRejectreason> queryAll(BsRejectreason bsRejectreason);

    /**
     * 新增数据
     *
     * @param bsRejectreason 实例对象
     * @return 影响行数
     */
    int insert(BsRejectreason bsRejectreason);

    /**
     * 修改数据
     *
     * @param bsRejectreason 实例对象
     * @return 影响行数
     */
    int update(BsRejectreason bsRejectreason);

    /**
     * 通过主键删除数据
     *
     * @param bsRejectreasonid 主键
     * @return 影响行数
     */
    int deleteById(Integer bsRejectreasonid);

}