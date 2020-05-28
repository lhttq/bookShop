package cn.lht.dao;

import cn.lht.entity.BsBookclass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BsBookclass)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-24 16:09:51
 */
public interface BsBookclassDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bsBookclassid 主键
     * @return 实例对象
     */
    BsBookclass queryById(Object bsBookclassid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsBookclass> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bsBookclass 实例对象
     * @return 对象列表
     */
    List<BsBookclass> queryAll(BsBookclass bsBookclass);

    /**
     * 新增数据
     *
     * @param bsBookclass 实例对象
     * @return 影响行数
     */
    int insert(BsBookclass bsBookclass);

    /**
     * 修改数据
     *
     * @param bsBookclass 实例对象
     * @return 影响行数
     */
    int update(BsBookclass bsBookclass);

    /**
     * 通过主键删除数据
     *
     * @param bsBookclassid 主键
     * @return 影响行数
     */
    int deleteById(Object bsBookclassid);

}