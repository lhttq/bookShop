package cn.lht.service;

import cn.lht.entity.BsPassword;

import java.util.List;

/**
 * (BsPassword)表服务接口
 *
 * @author makejava
 * @since 2020-02-24 16:10:47
 */
public interface BsPasswordService {

    /**
     * 通过ID查询单条数据
     *
     * @param bsUserid 主键
     * @return 实例对象
     */
    BsPassword queryById(Object bsUserid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BsPassword> queryAllByLimit(int offset, int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param bsPassword 实例对象
     * @return 对象列表
     */
    List<BsPassword> queryAll(BsPassword bsPassword);
    /**
     * 新增数据
     *
     * @param bsPassword 实例对象
     * @return 实例对象
     */
    BsPassword insert(BsPassword bsPassword);

    /**
     * 修改数据
     *
     * @param bsPassword 实例对象
     * @return 实例对象
     */
    Integer update(BsPassword bsPassword);

    /**
     * 通过主键删除数据
     *
     * @param bsUserid 主键
     * @return 是否成功
     */
    boolean deleteById(Object bsUserid);

}