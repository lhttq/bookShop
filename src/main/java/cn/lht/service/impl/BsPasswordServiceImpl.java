package cn.lht.service.impl;

import cn.lht.dao.BsPasswordDao;
import cn.lht.entity.BsPassword;
import cn.lht.service.BsPasswordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsPassword)表服务实现类
 *
 * @author makejava
 * @since 2020-02-24 16:10:47
 */
@Service("bsPasswordService")
public class BsPasswordServiceImpl implements BsPasswordService {
    @Resource
    private BsPasswordDao bsPasswordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bsUserid 主键
     * @return 实例对象
     */
    @Override
    public BsPassword queryById(Object bsUserid) {
        return this.bsPasswordDao.queryById(bsUserid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsPassword> queryAllByLimit(int offset, int limit) {
        return this.bsPasswordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param bsPassword 实例对象
     * @return 对象列表
     */
    @Override
    public List<BsPassword> queryAll(BsPassword bsPassword) {
        return this.bsPasswordDao.queryAll(bsPassword);
    }

    /**
     * 新增数据
     *
     * @param bsPassword 实例对象
     * @return 实例对象
     */
    @Override
    public BsPassword insert(BsPassword bsPassword) {
        this.bsPasswordDao.insert(bsPassword);
        return bsPassword;
    }

    /**
     * 修改数据
     *
     * @param bsPassword 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(BsPassword bsPassword) {
        return this.bsPasswordDao.update(bsPassword);
    }

    /**
     * 通过主键删除数据
     *
     * @param bsUserid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object bsUserid) {
        return this.bsPasswordDao.deleteById(bsUserid) > 0;
    }

}