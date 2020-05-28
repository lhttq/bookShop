package cn.lht.service;

import cn.lht.entity.BsPublishbooks;
import java.util.List;

/**
 * (BsPublishbooks)表服务接口
 *
 * @author makejava
 * @since 2020-04-02 16:12:47
 */
public interface BsPublishbooksService {

    /**
     * 通过ID查询单条数据
     *
     * @param bsBooksid 主键
     * @return 实例对象
     */
    BsPublishbooks queryById(Integer bsBooksid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsPublishbooks> queryAllByLimit(int offset, int limit);

    /**
     * 通过指定属性查询数据
     *
     * @param bsPublishbooks 实例对象
     * @return 实例对象
     */
    List<BsPublishbooks> queryAllByBsPublish(BsPublishbooks bsPublishbooks);


    /**
     * 新增数据
     *
     * @param bsPublishbooks 实例对象
     * @return 实例对象
     */
    Integer insert(BsPublishbooks bsPublishbooks);

    /**
     * 修改数据
     *
     * @param bsPublishbooks 实例对象
     * @return 实例对象
     */
    Integer update(BsPublishbooks bsPublishbooks);

    /**
     * 通过主键删除数据
     *
     * @param bsBooksid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bsBooksid);

}