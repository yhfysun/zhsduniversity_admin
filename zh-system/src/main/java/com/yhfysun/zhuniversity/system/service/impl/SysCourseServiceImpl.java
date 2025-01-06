package com.yhfysun.zhuniversity.system.service.impl;

import com.yhfysun.zhuniversity.common.utils.DateUtils;
import com.yhfysun.zhuniversity.system.domain.SysCourse;
import com.yhfysun.zhuniversity.system.mapper.SysCourseMapper;
import com.yhfysun.zhuniversity.system.service.ISysCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程Service业务层处理
 * 
 * @author yhfysun
 * @date 2024-06-22
 */
@Service
public class SysCourseServiceImpl implements ISysCourseService 
{
    @Autowired
    private SysCourseMapper sysCourseMapper;

    /**
     * 查询课程
     * 
     * @param couId 课程主键
     * @return 课程
     */
    @Override
    public SysCourse selectSysCourseByCouId(Long couId)
    {
        return sysCourseMapper.selectSysCourseByCouId(couId);
    }

    /**
     * 查询课程列表
     * 
     * @param sysCourse 课程
     * @return 课程
     */
    @Override
    public List<SysCourse> selectSysCourseList(SysCourse sysCourse)
    {
        return sysCourseMapper.selectSysCourseList(sysCourse);
    }

    /**
     * 新增课程
     * 
     * @param sysCourse 课程
     * @return 结果
     */
    @Override
    public int insertSysCourse(SysCourse sysCourse)
    {
        sysCourse.setCreateTime(DateUtils.getNowDate());
        return sysCourseMapper.insertSysCourse(sysCourse);
    }

    /**
     * 修改课程
     * 
     * @param sysCourse 课程
     * @return 结果
     */
    @Override
    public int updateSysCourse(SysCourse sysCourse)
    {
        sysCourse.setUpdateTime(DateUtils.getNowDate());
        return sysCourseMapper.updateSysCourse(sysCourse);
    }

    /**
     * 批量删除课程
     * 
     * @param couIds 需要删除的课程主键
     * @return 结果
     */
    @Override
    public int deleteSysCourseByCouIds(Long[] couIds)
    {
        return sysCourseMapper.deleteSysCourseByCouIds(couIds);
    }

    /**
     * 删除课程信息
     * 
     * @param couId 课程主键
     * @return 结果
     */
    @Override
    public int deleteSysCourseByCouId(Long couId)
    {
        return sysCourseMapper.deleteSysCourseByCouId(couId);
    }
}
