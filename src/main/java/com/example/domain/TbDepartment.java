package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName tb_department
 */
@TableName(value ="tb_department")
public class TbDepartment implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 描述
     */
    private String mark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 部门名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 描述
     */
    public String getMark() {
        return mark;
    }

    /**
     * 描述
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbDepartment other = (TbDepartment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMark() == null ? other.getMark() == null : this.getMark().equals(other.getMark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMark() == null) ? 0 : getMark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", mark=").append(mark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}