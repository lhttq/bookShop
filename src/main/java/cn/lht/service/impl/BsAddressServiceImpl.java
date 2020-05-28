package cn.lht.service.impl;

import cn.lht.dao.BsAddressDao;
import cn.lht.entity.BsAddress;
import cn.lht.service.BsAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsAddress)表服务实现类
 *
 * @author makejava
 * @since 2020-03-28 21:34:48
 */
@Service("bsAddressService")
public class BsAddressServiceImpl implements BsAddressService {
    @Resource
    private BsAddressDao bsAddressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bsAddressid 主键
     * @return 实例对象
     */
    @Override
    public BsAddress queryById(Integer bsAddressid) {
        return this.bsAddressDao.queryById(bsAddressid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsAddress> queryAllByLimit(int offset, int limit) {
        return this.bsAddressDao.queryAllByLimit(offset, limit);
    }

    /**
     * @param bsAddress 实例对象
     * @return 对象列表
     */
    @Override
    public List<BsAddress> queryByUserId(BsAddress bsAddress) {
        List<BsAddress> list = this.bsAddressDao.queryAll(bsAddress);
        return list;
    }

    /**
     * 新增数据
     *
     * @param bsAddress 实例对象
     * @return 实例对象
     */
    @Override
    public BsAddress insert(BsAddress bsAddress) {
        this.bsAddressDao.insert(bsAddress);
        return bsAddress;
    }

    /**
     * 修改数据
     *
     * @param bsAddress 实例对象
     * @return 实例对象
     */
    @Override
    public BsAddress update(BsAddress bsAddress) {
        this.bsAddressDao.update(bsAddress);
        return this.queryById(bsAddress.getBsAddressid());
    }

    /**
     * 通过主键删除数据
     *
     * @param bsAddressid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bsAddressid) {
        return this.bsAddressDao.deleteById(bsAddressid) > 0;
    }
}