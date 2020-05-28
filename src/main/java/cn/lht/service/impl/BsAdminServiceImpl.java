package cn.lht.service.impl;


import cn.lht.dao.BsAdminDao;
import cn.lht.entity.BsAdmin;
import cn.lht.service.BsAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsAdmin)表服务实现类
 *
 * @author makejava
 * @since 2020-02-24 16:09:14
 */
@Service("bsAdminService")
public class BsAdminServiceImpl implements BsAdminService {
    @Resource
    private BsAdminDao bsAdminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bsAdminid 主键
     * @return 实例对象
     */
    @Override
    public BsAdmin queryById(Integer bsAdminid) {
        return this.bsAdminDao.queryById(bsAdminid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsAdmin> queryAllByLimit(int offset, int limit) {
        return this.bsAdminDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bsAdmin 实例对象
     * @return 实例对象
     */
    @Override
    public BsAdmin insert(BsAdmin bsAdmin) {
        this.bsAdminDao.insert(bsAdmin);
        return bsAdmin;
    }

    /**
     * 修改数据
     *
     * @param bsAdmin 实例对象
     * @return 实例对象
     */
    @Override
    public BsAdmin update(BsAdmin bsAdmin) {
        this.bsAdminDao.update(bsAdmin);
        return this.queryById(bsAdmin.getBsAdminid());
    }

    /**
     * 通过主键删除数据
     *
     * @param bsAdminid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bsAdminid) {
        return this.bsAdminDao.deleteById(bsAdminid) > 0;
    }
}