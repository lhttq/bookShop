package cn.lht.service.impl;

import cn.lht.entity.BsOrderbooks;
import cn.lht.dao.BsOrderbooksDao;
import cn.lht.service.BsOrderbooksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsOrderbooks)表服务实现类
 *
 * @author makejava
 * @since 2020-04-13 16:02:43
 */
@Service("bsOrderbooksService")
public class BsOrderbooksServiceImpl implements BsOrderbooksService {
    @Resource
    private BsOrderbooksDao bsOrderbooksDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bsOrderbooksid 主键
     * @return 实例对象
     */
    @Override
    public BsOrderbooks queryById(Integer bsOrderbooksid) {
        return this.bsOrderbooksDao.queryById(bsOrderbooksid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsOrderbooks> queryAllByLimit(int offset, int limit) {
        return this.bsOrderbooksDao.queryAllByLimit(offset, limit);
    }

    /**
     *
     * @param bsOrderbooks 实例对象
     * @return对象列表
     */
    @Override
    public List<BsOrderbooks> queryAll(BsOrderbooks bsOrderbooks) {
        return this.bsOrderbooksDao.queryAll(bsOrderbooks);
    }

    /**
     * 新增数据
     *
     * @param bsOrderbooks 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(BsOrderbooks bsOrderbooks) {
        return this.bsOrderbooksDao.insert(bsOrderbooks);
    }

    /**
     * 修改数据
     *
     * @param bsOrderbooks 实例对象
     * @return 实例对象
     */
    @Override
    public BsOrderbooks update(BsOrderbooks bsOrderbooks) {
        this.bsOrderbooksDao.update(bsOrderbooks);
        return this.queryById(bsOrderbooks.getBsOrderbooksid());
    }

    /**
     * 通过主键删除数据
     *
     * @param bsOrderbooksid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bsOrderbooksid) {
        return this.bsOrderbooksDao.deleteById(bsOrderbooksid) > 0;
    }
}