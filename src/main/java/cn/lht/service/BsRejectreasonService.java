package cn.lht.service;

import cn.lht.entity.BsRejectreason;

import java.util.List;

/**
 * (BsRejectreason)表服务接口
 *
 * @author makejava
 * @since 2020-02-24 16:10:57
 */
public interface BsRejectreasonService {

    /**
     * 通过ID查询单条数据
     *
     * @param bsRejectreasonid 主键
     * @return 实例对象
     */
    BsRejectreason queryById(Integer bsRejectreasonid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsRejectreason> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bsRejectreason 实例对象
     * @return 实例对象
     */
    BsRejectreason insert(BsRejectreason bsRejectreason);

    /**
     * 修改数据
     *
     * @param bsRejectreason 实例对象
     * @return 实例对象
     */
    BsRejectreason update(BsRejectreason bsRejectreason);

    /**
     * 通过主键删除数据
     *
     * @param bsRejectreasonid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bsRejectreasonid);

}