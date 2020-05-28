package cn.lht.service.impl;

import cn.lht.dao.BsCancelreasonDao;
import cn.lht.entity.BsCancelreason;
import cn.lht.service.BsCancelreasonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsCancelreason)表服务实现类
 *
 * @author makejava
 * @since 2020-02-24 16:10:27
 */
@Service("bsCancelreasonService")
public class BsCancelreasonServiceImpl implements BsCancelreasonService {
    @Resource
    private BsCancelreasonDao bsCancelreasonDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bsCancelreasonid 主键
     * @return 实例对象
     */
    @Override
    public BsCancelreason queryById(Integer bsCancelreasonid) {
        return this.bsCancelreasonDao.queryById(bsCancelreasonid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsCancelreason> queryAllByLimit(int offset, int limit) {
        return this.bsCancelreasonDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bsCancelreason 实例对象
     * @return 实例对象
     */
    @Override
    public BsCancelreason insert(BsCancelreason bsCancelreason) {
        this.bsCancelreasonDao.insert(bsCancelreason);
        return bsCancelreason;
    }

    /**
     * 修改数据
     *
     * @param bsCancelreason 实例对象
     * @return 实例对象
     */
    @Override
    public BsCancelreason update(BsCancelreason bsCancelreason) {
        this.bsCancelreasonDao.update(bsCancelreason);
        return this.queryById(bsCancelreason.getBsCancelreasonid());
    }

    /**
     * 通过主键删除数据
     *
     * @param bsCancelreasonid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bsCancelreasonid) {
        return this.bsCancelreasonDao.deleteById(bsCancelreasonid) > 0;
    }
}