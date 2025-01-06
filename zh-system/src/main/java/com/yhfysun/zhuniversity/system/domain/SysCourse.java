package com.yhfysun.zhuniversity.system.domain;

import com.yhfysun.zhuniversity.common.annotation.Excel;
import com.yhfysun.zhuniversity.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 课程对象 sys_course
 * 
 * @author yhfysun
 * @date 2024-06-22
 */
public class SysCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long couId;

    /** 名称 */
    @Excel(name = "名称")
    private String couName;

    /** 父ID */
    @Excel(name = "父ID")
    private Long parentId;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer orderNum;

    /** 课程类型（M目录 C课程 F章节） */
    @Excel(name = "课程类型", readConverterExp = "M=目录,C=课程,F=章节")
    private String couType;

    /** 课程状态（0显示 1隐藏） */
    @Excel(name = "课程状态", readConverterExp = "0=显示,1=隐藏")
    private String visible;

    /** 课程状态（0正常 1停用） */
    @Excel(name = "课程状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 是否推荐（0否 1是） */
    @Excel(name = "是否推荐", readConverterExp = "0=否,1=是")
    private String isTop;

    /** 图标 */
    @Excel(name = "图标")
    private String icon;

    /** 详细介绍 */
    @Excel(name = "详细介绍")
    private String detail;

    /** 资源路径 */
    @Excel(name = "资源路径")
    private String sourceUrl;

    public void setCouId(Long couId) 
    {
        this.couId = couId;
    }

    public Long getCouId() 
    {
        return couId;
    }
    public void setCouName(String couName) 
    {
        this.couName = couName;
    }

    public String getCouName() 
    {
        return couName;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setOrderNum(Integer orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() 
    {
        return orderNum;
    }
    public void setCouType(String couType) 
    {
        this.couType = couType;
    }

    public String getCouType() 
    {
        return couType;
    }
    public void setVisible(String visible) 
    {
        this.visible = visible;
    }

    public String getVisible() 
    {
        return visible;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setIsTop(String isTop) 
    {
        this.isTop = isTop;
    }

    public String getIsTop() 
    {
        return isTop;
    }
    public void setIcon(String icon) 
    {
        this.icon = icon;
    }

    public String getIcon() 
    {
        return icon;
    }
    public void setDetail(String detail) 
    {
        this.detail = detail;
    }

    public String getDetail() 
    {
        return detail;
    }
    public void setSourceUrl(String sourceUrl) 
    {
        this.sourceUrl = sourceUrl;
    }

    public String getSourceUrl() 
    {
        return sourceUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("couId", getCouId())
            .append("couName", getCouName())
            .append("parentId", getParentId())
            .append("orderNum", getOrderNum())
            .append("couType", getCouType())
            .append("visible", getVisible())
            .append("status", getStatus())
            .append("isTop", getIsTop())
            .append("icon", getIcon())
            .append("detail", getDetail())
            .append("sourceUrl", getSourceUrl())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
