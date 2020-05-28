package cn.lht.service;

import cn.lht.entity.BsCancelreason;

import java.util.List;

/**
 * (BsCancelreason)表服务接口
 *
 * @author makejava
 * @since 2020-02-24 16:10:27
 */
public interface BsCancelreasonService {

    /**
     * 通过ID查询单条数据
     *
     * @param bsCancelreasonid 主键
     * @return 实例对象
     */
    BsCancelreason queryById(Integer bsCancelreasonid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsCancelreason> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bsCancelreason 实例对象
     * @return 实例对象
     */
    BsCancelreason insert(BsCancelreason bsCancelreason);

    /**
     * 修改数据
     *
     * @param bsCancelreason 实例对象
     * @return 实例对象
     */
    BsCancelreason update(BsCancelreason bsCancelreason);

    /**
     * 通过主键删除数据
     *
     * @param bsCancelreasonid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bsCancelreasonid);

}