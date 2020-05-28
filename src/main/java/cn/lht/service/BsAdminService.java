package cn.lht.service;


import cn.lht.entity.BsAdmin;

import java.util.List;

/**
 * (BsAdmin)表服务接口
 *
 * @author makejava
 * @since 2020-02-24 16:09:14
 */
public interface BsAdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param bsAdminid 主键
     * @return 实例对象
     */
    BsAdmin queryById(Integer bsAdminid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsAdmin> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bsAdmin 实例对象
     * @return 实例对象
     */
    BsAdmin insert(BsAdmin bsAdmin);

    /**
     * 修改数据
     *
     * @param bsAdmin 实例对象
     * @return 实例对象
     */
    BsAdmin update(BsAdmin bsAdmin);

    /**
     * 通过主键删除数据
     *
     * @param bsAdminid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bsAdminid);

}