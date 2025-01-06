package com.yhfysun.zhuniversity.system.mapper;

import com.yhfysun.zhuniversity.system.domain.SysCourse;

import java.util.List;

/**
 * 课程Mapper接口
 * 
 * @author yhfysun
 * @date 2024-06-22
 */
public interface SysCourseMapper 
{
    /**
     * 查询课程
     * 
     * @param couId 课程主键
     * @return 课程
     */
    public SysCourse selectSysCourseByCouId(Long couId);

    /**
     * 查询课程列表
     * 
     * @param sysCourse 课程
     * @return 课程集合
     */
    public List<SysCourse> selectSysCourseList(SysCourse sysCourse);

    /**
     * 新增课程
     * 
     * @param sysCourse 课程
     * @return 结果
     */
    public int insertSysCourse(SysCourse sysCourse);

    /**
     * 修改课程
     * 
     * @param sysCourse 课程
     * @return 结果
     */
    public int updateSysCourse(SysCourse sysCourse);

    /**
     * 删除课程
     * 
     * @param couId 课程主键
     * @return 结果
     */
    public int deleteSysCourseByCouId(Long couId);

    /**
     * 批量删除课程
     * 
     * @param couIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysCourseByCouIds(Long[] couIds);
}
