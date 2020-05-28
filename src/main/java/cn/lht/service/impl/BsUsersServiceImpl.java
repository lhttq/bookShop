package cn.lht.service.impl;

import cn.lht.dao.BsUsersDao;
import cn.lht.entity.BsUsers;
import cn.lht.service.BsUsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsUsers)表服务实现类
 *
 * @author makejava
 * @since 2020-02-24 16:11:18
 */
@Service("bsUsersService")
public class BsUsersServiceImpl implements BsUsersService {
    @Resource
    private BsUsersDao bsUsersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bsUserid 主键
     * @return 实例对象
     */
    @Override
    public BsUsers queryById(Integer bsUserid) {
        return this.bsUsersDao.queryById(bsUserid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsUsers> queryAllByLimit(int offset, int limit) {
        return this.bsUsersDao.queryAllByLimit(offset, limit);
    }
    /**
     * 通过用户名查询单条数据
     *
     * @param bsLoginname 用户名
     * @return 实例对象
     */
    @Override
    public BsUsers queryByBsLoginName(String bsLoginname) {
        return this.bsUsersDao.queryByuserLoginName(bsLoginname);
    }

    /**
     * 新增数据
     *
     * @param bsUsers 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(BsUsers bsUsers) {
        return this.bsUsersDao.insert(bsUsers);
    }

    /**
     * 修改数据
     *
     * @param bsUsers 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(BsUsers bsUsers) {
        return this.bsUsersDao.update(bsUsers);
    }

    /**
     * 通过主键删除数据
     *
     * @param bsUserid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object bsUserid) {
        return this.bsUsersDao.deleteById(bsUserid) > 0;
    }
}