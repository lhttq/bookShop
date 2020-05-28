package cn.lht.service;

import cn.lht.entity.BsCarts;

import java.util.List;

/**
 * (BsCarts)表服务接口
 *
 * @author makejava
 * @since 2020-03-03 20:53:54
 */
public interface BsCartsService {

    /**
     * 通过ID查询单条数据
     *
     * @param bsCartid 主键
     * @return 实例对象
     */
    BsCarts queryById(Integer bsCartid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsCarts> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bsCarts 实例对象
     * @return 实例对象
     */
    BsCarts insert(BsCarts bsCarts);

    /**
     * 修改数据
     *
     * @param bsCarts 实例对象
     * @return 影响行数
     */
    Integer update(BsCarts bsCarts);

    /**
     *
     * @param bsCarts 实例对象
     * @return 影响行数
     */
    Integer updateIs(BsCarts bsCarts);
    /**
     * 通过主键删除数据
     *
     * @param bsCarts 实例对象
     * @return 是否成功
     */
    boolean deleteByUseridAndBookid(BsCarts bsCarts);

    /**
     *  通过用户Id查询
     *
     * @param bsCarts 实例对象
     * @return 实例集合
     */
     List<BsCarts> queryAll(BsCarts bsCarts);

}