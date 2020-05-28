package cn.lht.service.impl;


import cn.lht.dao.BsStatusDao;
import cn.lht.entity.BsStatus;
import cn.lht.service.BsStatusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsStatus)表服务实现类
 *
 * @author makejava
 * @since 2020-02-24 16:11:09
 */
@Service("bsStatusService")
public class BsStatusServiceImpl implements BsStatusService {
    @Resource
    private BsStatusDao bsStatusDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bsUserid 主键
     * @return 实例对象
     */
    @Override
    public BsStatus queryById(Integer bsUserid) {
        return this.bsStatusDao.queryById(bsUserid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsStatus> queryAllByLimit(int offset, int limit) {
        return this.bsStatusDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bsStatus 实例对象
     * @return 实例对象
     */
    @Override
    public BsStatus insert(BsStatus bsStatus) {
        this.bsStatusDao.insert(bsStatus);
        return bsStatus;
    }

    /**
     * 修改数据
     *
     * @param bsStatus 实例对象
     * @return 实例对象
     */
    @Override
    public BsStatus update(BsStatus bsStatus) {
        this.bsStatusDao.update(bsStatus);
        return this.queryById(bsStatus.getBsUserid());
    }

    /**
     * 通过主键删除数据
     *
     * @param bsUserid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bsUserid) {
        return this.bsStatusDao.deleteById(bsUserid) > 0;
    }
}