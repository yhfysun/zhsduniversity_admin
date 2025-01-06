package com.yhfysun.zhuniversity.controller;

import com.yhfysun.zhuniversity.common.annotation.Log;
import com.yhfysun.zhuniversity.common.core.controller.BaseController;
import com.yhfysun.zhuniversity.common.core.domain.AjaxResult;
import com.yhfysun.zhuniversity.common.core.page.TableDataInfo;
import com.yhfysun.zhuniversity.common.enums.BusinessType;
import com.yhfysun.zhuniversity.common.utils.poi.ExcelUtil;
import com.yhfysun.zhuniversity.system.domain.SysCourse;
import com.yhfysun.zhuniversity.system.service.ISysCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 课程 Controller
 * 
 * @date 2024-06-22
 */
@RestController
@RequestMapping("/app/course")
public class CourseController extends BaseController
{
    @Autowired
    private ISysCourseService sysCourseService;

    /**
     * 查询课程列表
     */
//   //  @PreAuthorize("@ss.hasPermi('system:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysCourse sysCourse)
    {
        startPage();
        List<SysCourse> list = sysCourseService.selectSysCourseList(sysCourse);
        return getDataTable(list);
    }

    /**
     * 导出课程列表
     */
//   //  @PreAuthorize("@ss.hasPermi('system:course:export')")
    @Log(title = "课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysCourse sysCourse)
    {
        List<SysCourse> list = sysCourseService.selectSysCourseList(sysCourse);
        ExcelUtil<SysCourse> util = new ExcelUtil<SysCourse>(SysCourse.class);
        util.exportExcel(response, list, "课程数据");
    }

    /**
     * 获取课程详细信息
     */
   //  @PreAuthorize("@ss.hasPermi('system:course:query')")
    @GetMapping(value = "/{couId}")
    public AjaxResult getInfo(@PathVariable("couId") Long couId)
    {
        return success(sysCourseService.selectSysCourseByCouId(couId));
    }

    /**
     * 新增课程
     */
   //  @PreAuthorize("@ss.hasPermi('system:course:add')")
    @Log(title = "课程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysCourse sysCourse)
    {
        return toAjax(sysCourseService.insertSysCourse(sysCourse));
    }

    /**
     * 修改课程
     */
   //  @PreAuthorize("@ss.hasPermi('system:course:edit')")
    @Log(title = "课程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysCourse sysCourse)
    {
        return toAjax(sysCourseService.updateSysCourse(sysCourse));
    }

    /**
     * 删除课程
     */
   //  @PreAuthorize("@ss.hasPermi('system:course:remove')")
    @Log(title = "课程", businessType = BusinessType.DELETE)
	@DeleteMapping("/{couIds}")
    public AjaxResult remove(@PathVariable Long[] couIds)
    {
        return toAjax(sysCourseService.deleteSysCourseByCouIds(couIds));
    }
}
