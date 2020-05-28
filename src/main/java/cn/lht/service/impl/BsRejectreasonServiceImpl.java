package cn.lht.service.impl;

import cn.lht.dao.BsRejectreasonDao;
import cn.lht.entity.BsRejectreason;
import cn.lht.service.BsRejectreasonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsRejectreason)表服务实现类
 *
 * @author makejava
 * @since 2020-02-24 16:10:57
 */
@Service("bsRejectreasonService")
public class BsRejectreasonServiceImpl implements BsRejectreasonService {
    @Resource
    private BsRejectreasonDao bsRejectreasonDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bsRejectreasonid 主键
     * @return 实例对象
     */
    @Override
    public BsRejectreason queryById(Integer bsRejectreasonid) {
        return this.bsRejectreasonDao.queryById(bsRejectreasonid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsRejectreason> queryAllByLimit(int offset, int limit) {
        return this.bsRejectreasonDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bsRejectreason 实例对象
     * @return 实例对象
     */
    @Override
    public BsRejectreason insert(BsRejectreason bsRejectreason) {
        this.bsRejectreasonDao.insert(bsRejectreason);
        return bsRejectreason;
    }

    /**
     * 修改数据
     *
     * @param bsRejectreason 实例对象
     * @return 实例对象
     */
    @Override
    public BsRejectreason update(BsRejectreason bsRejectreason) {
        this.bsRejectreasonDao.update(bsRejectreason);
        return this.queryById(bsRejectreason.getBsRejectreasonid());
    }

    /**
     * 通过主键删除数据
     *
     * @param bsRejectreasonid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bsRejectreasonid) {
        return this.bsRejectreasonDao.deleteById(bsRejectreasonid) > 0;
    }
}