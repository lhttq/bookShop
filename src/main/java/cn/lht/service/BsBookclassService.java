package cn.lht.service;

import cn.lht.entity.BsBookclass;

import java.util.List;

/**
 * (BsBookclass)表服务接口
 *
 * @author makejava
 * @since 2020-02-24 16:09:51
 */
public interface BsBookclassService {

    /**
     * 通过ID查询单条数据
     *
     * @param bsBookclassid 主键
     * @return 实例对象
     */
    BsBookclass queryById(Object bsBookclassid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsBookclass> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bsBookclass 实例对象
     * @return 实例对象
     */
    BsBookclass insert(BsBookclass bsBookclass);

    /**
     * 修改数据
     *
     * @param bsBookclass 实例对象
     * @return 实例对象
     */
    BsBookclass update(BsBookclass bsBookclass);

    /**
     * 通过主键删除数据
     *
     * @param bsBookclassid 主键
     * @return 是否成功
     */
    boolean deleteById(Object bsBookclassid);

}