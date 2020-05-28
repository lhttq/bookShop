package cn.lht.service.impl;

import cn.lht.dao.BsCartsDao;
import cn.lht.entity.BsCarts;
import cn.lht.service.BsCartsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsCarts)表服务实现类
 *
 * @author makejava
 * @since 2020-03-03 20:53:54
 */
@Service("bsCartsService")
public class BsCartsServiceImpl implements BsCartsService {
    @Resource
    private BsCartsDao bsCartsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bsCartid 主键
     * @return 实例对象
     */
    @Override
    public BsCarts queryById(Integer bsCartid) {
        return this.bsCartsDao.queryById(bsCartid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsCarts> queryAllByLimit(int offset, int limit) {
        return this.bsCartsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bsCarts 实例对象
     * @return 实例对象
     */
    @Override
    public BsCarts insert(BsCarts bsCarts) {
        this.bsCartsDao.insert(bsCarts);
        return bsCarts;
    }

    /**
     * 修改数据
     *
     * @param bsCarts 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(BsCarts bsCarts) {
        return this.bsCartsDao.update(bsCarts);
    }

    /**
     * @param bsCarts 实例对象
     * @return 影响行数
     */
    @Override
    public Integer updateIs(BsCarts bsCarts) {
        return bsCartsDao.updateIs(bsCarts);
    }

    /**
     * 通过主键删除数据
     *
     * @param bsCarts 实例对象
     * @return 是否成功
     */
    @Override
    public boolean deleteByUseridAndBookid(BsCarts bsCarts) {
        return this.bsCartsDao.deleteByUseridAndBookid(bsCarts) > 0;
    }

    /**
     * 通过用户Id查询
     *
     * @param bsCarts 实例对象
     * @return 实例集合
     */
    @Override
    public List<BsCarts> queryAll(BsCarts bsCarts) {
        return this.bsCartsDao.queryAll(bsCarts);
    }
}