package cn.lht.service;

import cn.lht.entity.BsAddress;

import java.util.List;

/**
 * (BsAddress)表服务接口
 *
 * @author makejava
 * @since 2020-03-28 21:34:48
 */
public interface BsAddressService {

    /**
     * 通过ID查询单条数据
     *
     * @param bsAddressid 主键
     * @return 实例对象
     */
    BsAddress queryById(Integer bsAddressid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsAddress> queryAllByLimit(int offset, int limit);

    /**
     *
     * @param bsAddress 实例对象
     * @return 对象列表
     */
    List<BsAddress> queryByUserId(BsAddress bsAddress);

    /**
     * 新增数据
     *
     * @param bsAddress 实例对象
     * @return 实例对象
     */
    BsAddress insert(BsAddress bsAddress);

    /**
     * 修改数据
     *
     * @param bsAddress 实例对象
     * @return 实例对象
     */
    BsAddress update(BsAddress bsAddress);

    /**
     * 通过主键删除数据
     *
     * @param bsAddressid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bsAddressid);

}