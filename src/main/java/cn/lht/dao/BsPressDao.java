package cn.lht.dao;

import cn.lht.entity.BsPress;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (BsPress)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-21 22:46:20
 */
@Repository
public interface BsPressDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bsPressid 主键
     * @return 实例对象
     */
    BsPress queryById(Integer bsPressid);
    BsPress queryByNum(String bsPressnum);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsPress> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bsPress 实例对象
     * @return 对象列表
     */
    List<BsPress> queryAll(BsPress bsPress);

    /**
     * 新增数据
     *
     * @param bsPress 实例对象
     * @return 影响行数
     */
    int insert(BsPress bsPress);

    /**
     * 修改数据
     *
     * @param bsPress 实例对象
     * @return 影响行数
     */
    int update(BsPress bsPress);

    /**
     * 通过主键删除数据
     *
     * @param bsPressid 主键
     * @return 影响行数
     */
    int deleteById(Integer bsPressid);

}