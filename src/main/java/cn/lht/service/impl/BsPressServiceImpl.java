package cn.lht.service.impl;

import cn.lht.dao.BsPressDao;
import cn.lht.entity.BsPress;
import cn.lht.service.BsPressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsPress)表服务实现类
 *
 * @author makejava
 * @since 2020-02-21 22:46:23
 */
@Service("bsPressService")
public class BsPressServiceImpl implements BsPressService {
    @Resource
    private BsPressDao bsPressDao;
    /**
     * 通过ID查询单条数据
     *
     * @param bsPressid 主键
     * @return 实例对象
     */
    @Override
    public BsPress queryById(Integer bsPressid) {
        return this.bsPressDao.queryById(bsPressid);
    }

    /**
     * 通过出版社编程查询数据
     *
     * @param bsPressnum 出版社编号
     * @return 实例对象
     */
    @Override
    public BsPress queryByNum(String bsPressnum) {
        return this.bsPressDao.queryByNum(bsPressnum);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsPress> queryAllByLimit(int offset, int limit) {
        return this.bsPressDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bsPress 实例对象
     * @return 实例对象
     */
    @Override
    public BsPress insert(BsPress bsPress) {
        this.bsPressDao.insert(bsPress);
        return bsPress;
    }

    /**
     * 修改数据
     *
     * @param bsPress 实例对象
     * @return 实例对象
     */
    @Override
    public BsPress update(BsPress bsPress) {
        this.bsPressDao.update(bsPress);
        return this.queryById(bsPress.getBsPressid());
    }

    /**
     * 通过主键删除数据
     *
     * @param bsPressid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bsPressid) {
        return this.bsPressDao.deleteById(bsPressid) > 0;
    }
}