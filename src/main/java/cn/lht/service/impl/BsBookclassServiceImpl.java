package cn.lht.service.impl;


import cn.lht.dao.BsBookclassDao;
import cn.lht.entity.BsBookclass;
import cn.lht.service.BsBookclassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsBookclass)表服务实现类
 *
 * @author makejava
 * @since 2020-02-24 16:09:51
 */
@Service("bsBookclassService")
public class BsBookclassServiceImpl implements BsBookclassService {
    @Resource
    private BsBookclassDao bsBookclassDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bsBookclassid 主键
     * @return 实例对象
     */
    @Override
    public BsBookclass queryById(Object bsBookclassid) {
        return this.bsBookclassDao.queryById(bsBookclassid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BsBookclass> queryAllByLimit(int offset, int limit) {
        return this.bsBookclassDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bsBookclass 实例对象
     * @return 实例对象
     */
    @Override
    public BsBookclass insert(BsBookclass bsBookclass) {
        this.bsBookclassDao.insert(bsBookclass);
        return bsBookclass;
    }

    /**
     * 修改数据
     *
     * @param bsBookclass 实例对象
     * @return 实例对象
     */
    @Override
    public BsBookclass update(BsBookclass bsBookclass) {
        this.bsBookclassDao.update(bsBookclass);
        return this.queryById(bsBookclass.getBsBookclassid());
    }

    /**
     * 通过主键删除数据
     *
     * @param bsBookclassid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object bsBookclassid) {
        return this.bsBookclassDao.deleteById(bsBookclassid) > 0;
    }
}