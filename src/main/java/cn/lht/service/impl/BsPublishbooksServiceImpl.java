package cn.lht.service.impl;

import cn.lht.entity.BsPublishbooks;
import cn.lht.dao.BsPublishbooksDao;
import cn.lht.service.BsPublishbooksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsPublishbooks)表服务实现类
 *
 * @author makejava
 * @since 2020-04-02 16:12:47
 */
@Service("bsPublishbooksService")
public class BsPublishbooksServiceImpl implements BsPublishbooksService {
    @Resource
    private BsPublishbooksDao bsPublishbooksDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bsBooksid 主键
     * @return 实例对象
     */
    @Override
    public BsPublishbooks queryById(Integer bsBooksid) {
        return this.bsPublishbooksDao.queryById(bsBooksid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsPublishbooks> queryAllByLimit(int offset, int limit) {
        return this.bsPublishbooksDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bsPublishbooks 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(BsPublishbooks bsPublishbooks) {
        return this.bsPublishbooksDao.insert(bsPublishbooks);
    }

    /**
     * 通过指定属性查询数据
     *
     * @param bsPublishbooks 实例对象
     * @return 实例对象
     */
    @Override
    public List<BsPublishbooks> queryAllByBsPublish(BsPublishbooks bsPublishbooks) {
        return bsPublishbooksDao.queryAll(bsPublishbooks);
    }

    /**
     * 修改数据
     *
     * @param bsPublishbooks 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(BsPublishbooks bsPublishbooks) {
        return this.bsPublishbooksDao.update(bsPublishbooks);
    }

    /**
     * 通过主键删除数据
     *
     * @param bsBooksid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bsBooksid) {
        return this.bsPublishbooksDao.deleteById(bsBooksid) > 0;
    }
}