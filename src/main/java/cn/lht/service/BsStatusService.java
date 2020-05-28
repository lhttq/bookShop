package cn.lht.service;

import cn.lht.entity.BsStatus;

import java.util.List;

/**
 * (BsStatus)表服务接口
 *
 * @author makejava
 * @since 2020-02-24 16:11:09
 */
public interface BsStatusService {

    /**
     * 通过ID查询单条数据
     *
     * @param bsUserid 主键
     * @return 实例对象
     */
    BsStatus queryById(Integer bsUserid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsStatus> queryAllByLimit(int offset, int limit);
    /**
     * 新增数据
     *
     * @param bsStatus 实例对象
     * @return 实例对象
     */
    BsStatus insert(BsStatus bsStatus);

    /**
     * 修改数据
     *
     * @param bsStatus 实例对象
     * @return 实例对象
     */
    BsStatus update(BsStatus bsStatus);

    /**
     * 通过主键删除数据
     *
     * @param bsUserid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bsUserid);

}