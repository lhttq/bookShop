package cn.lht.service;

import cn.lht.entity.BsOrderbooks;
import java.util.List;

/**
 * (BsOrderbooks)表服务接口
 *
 * @author makejava
 * @since 2020-04-13 16:02:43
 */
public interface BsOrderbooksService {

    /**
     * 通过ID查询单条数据
     *
     * @param bsOrderbooksid 主键
     * @return 实例对象
     */
    BsOrderbooks queryById(Integer bsOrderbooksid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsOrderbooks> queryAllByLimit(int offset, int limit);

    /**
     * 万能查询
     *
     * @param bsOrderbooks 实例对象
     * @return 对象列表
     */
    List<BsOrderbooks> queryAll(BsOrderbooks bsOrderbooks);
    /**
     * 新增数据
     *
     * @param bsOrderbooks 实例对象
     * @return 实例对象
     */
    Integer insert(BsOrderbooks bsOrderbooks);

    /**
     * 修改数据
     *
     * @param bsOrderbooks 实例对象
     * @return 实例对象
     */
    BsOrderbooks update(BsOrderbooks bsOrderbooks);

    /**
     * 通过主键删除数据
     *
     * @param bsOrderbooksid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bsOrderbooksid);

}