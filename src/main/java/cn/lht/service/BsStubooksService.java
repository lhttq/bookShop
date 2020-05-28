package cn.lht.service;

import cn.lht.entity.BsStubooks;
import java.util.List;

/**
 * (BsStubooks)表服务接口
 *
 * @author makejava
 * @since 2020-04-05 18:21:28
 */
public interface BsStubooksService {

    /**
     * 通过ID查询单条数据
     *
     * @param bsBookid 主键
     * @return 实例对象
     */
    BsStubooks queryById(Integer bsBookid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BsStubooks> queryAllByLimit(int offset, int limit);

    /**
     * 通过学校查询书籍
     *
     * @param bsStubooks 实例对象
     * @return 对象列表
     */
    List<BsStubooks> queryAllByUniversity(BsStubooks bsStubooks);
    /**
     * 新增数据
     *
     * @param bsStubooks 实例对象
     * @return 实例对象
     */
    Integer insert(BsStubooks bsStubooks);

    /**
     * 修改数据
     *
     * @param bsStubooks 实例对象
     * @return 影响行数
     */
    Integer update(BsStubooks bsStubooks);

    /**
     * 通过主键删除数据
     *
     * @param bsBookid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bsBookid);

}