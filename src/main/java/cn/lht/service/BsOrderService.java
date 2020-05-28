package cn.lht.service;

import cn.lht.entity.BsOrder;
import java.util.List;

/**
 * (BsOrder)表服务接口
 *
 * @author makejava
 * @since 2020-04-13 15:55:14
 */
public interface BsOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param bsOrderid 主键
     * @return 实例对象
     */
    BsOrder queryById(Integer bsOrderid);

    /**
     * 条件查询
     *
     * @param bsOrder 实例对象
     * @return 对象列表
     */
    List<BsOrder> queryAll(BsOrder bsOrder);
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsOrder> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bsOrder 实例对象
     * @return 影响行数
     */
    Integer insert(BsOrder bsOrder);

    /**
     * 修改数据
     *
     * @param bsOrder 实例对象
     * @return 实例对象
     */
    BsOrder update(BsOrder bsOrder);

    /**
     * 通过主键删除数据
     *
     * @param bsOrderid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bsOrderid);

}