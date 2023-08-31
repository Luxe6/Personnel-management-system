package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 
 * @TableName tb_employee
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName(value ="tb_employee")
public class TbEmployee implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 出生日期
     */
    private LocalDateTime birthdayDate;

    /**
     * 政治面貌
     */
    private String politicsStatus;

    /**
     * 民族
     */
    private String nation;

    /**
     * 籍贯
     */
    private String nativePlace;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 职位的关联id
     */
    private Integer positionId;

    /**
     * 职称的关联id
     */
    private Integer titleId;

    /**
     * 部门的关联id
     */
    private Integer departmentId;

    @TableField(exist = false)
    private TbDepartment department;

    @TableField(exist = false)
    private TbPosition position;

    @TableField(exist = false)
    private TbTitle title;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 工号
     */
    private String employeeNumber;

    /**
     * 学历
     */
    private String education;

    /**
     * 毕业院校
     */
    private String graduationInstitution;

    /**
     * 专业名称
     */
    private String professionalName;

    /**
     * 入职日期
     */

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime hireDate;

    /**
     * 转正日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime probationDate;

    /**
     * 合同起始日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime contractStartDate;

    /**
     * 合同结束日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime contractEndDate;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 聘用形式 0劳动合同 1劳务合同
     */
    private Integer employmentType;

    /**
     * 婚姻状况 0未婚 1 已婚 2离异
     */
    private Integer maritalStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 出生日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public LocalDateTime getBirthdayDate() {
        return birthdayDate;
    }

    /**
     * 出生日期
     */
    public void setBirthdayDate(LocalDateTime birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    /**
     * 政治面貌
     */
    public String getPoliticsStatus() {
        return politicsStatus;
    }

    /**
     * 政治面貌
     */
    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus;
    }

    /**
     * 民族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 民族
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * 籍贯
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * 籍贯
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    /**
     * 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 联系地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 职位的关联id
     */
    public Integer getPositionId() {
        return positionId;
    }

    /**
     * 职位的关联id
     */
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    /**
     * 职称的关联id
     */
    public Integer getTitleId() {
        return titleId;
    }

    /**
     * 职称的关联id
     */
    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    /**
     * 部门的关联id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * 部门的关联id
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 联系方式
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 联系方式
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 工号
     */
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * 工号
     */
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * 学历
     */
    public String getEducation() {
        return education;
    }

    /**
     * 学历
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 毕业院校
     */
    public String getGraduationInstitution() {
        return graduationInstitution;
    }

    /**
     * 毕业院校
     */
    public void setGraduationInstitution(String graduationInstitution) {
        this.graduationInstitution = graduationInstitution;
    }

    /**
     * 专业名称
     */
    public String getProfessionalName() {
        return professionalName;
    }

    /**
     * 专业名称
     */
    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName;
    }

    /**
     * 入职日期
     */
    public LocalDateTime getHireDate() {
        return hireDate;
    }

    /**
     * 入职日期
     */
    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    /**
     * 转正日期
     */
    public LocalDateTime getProbationDate() {
        return probationDate;
    }

    /**
     * 转正日期
     */
    public void setProbationDate(LocalDateTime probationDate) {
        this.probationDate = probationDate;
    }

    /**
     * 合同起始日期
     */
    public LocalDateTime getContractStartDate() {
        return contractStartDate;
    }

    /**
     * 合同起始日期
     */
    public void setContractStartDate(LocalDateTime contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    /**
     * 合同结束日期
     */
    public LocalDateTime getContractEndDate() {
        return contractEndDate;
    }

    /**
     * 合同结束日期
     */
    public void setContractEndDate(LocalDateTime contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    /**
     * 身份证号
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 身份证号
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * 聘用形式 0劳动合同 1劳务合同
     */
    public Integer getEmploymentType() {
        return employmentType;
    }

    /**
     * 聘用形式 0劳动合同 1劳务合同
     */
    public void setEmploymentType(Integer employmentType) {
        this.employmentType = employmentType;
    }

    /**
     * 婚姻状况 0未婚 1 已婚 2离异
     */
    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * 婚姻状况 0未婚 1 已婚 2离异
     */
    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
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
        TbEmployee other = (TbEmployee) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthdayDate() == null ? other.getBirthdayDate() == null : this.getBirthdayDate().equals(other.getBirthdayDate()))
            && (this.getPoliticsStatus() == null ? other.getPoliticsStatus() == null : this.getPoliticsStatus().equals(other.getPoliticsStatus()))
            && (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
            && (this.getNativePlace() == null ? other.getNativePlace() == null : this.getNativePlace().equals(other.getNativePlace()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getPositionId() == null ? other.getPositionId() == null : this.getPositionId().equals(other.getPositionId()))
            && (this.getTitleId() == null ? other.getTitleId() == null : this.getTitleId().equals(other.getTitleId()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getEmployeeNumber() == null ? other.getEmployeeNumber() == null : this.getEmployeeNumber().equals(other.getEmployeeNumber()))
            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
            && (this.getGraduationInstitution() == null ? other.getGraduationInstitution() == null : this.getGraduationInstitution().equals(other.getGraduationInstitution()))
            && (this.getProfessionalName() == null ? other.getProfessionalName() == null : this.getProfessionalName().equals(other.getProfessionalName()))
            && (this.getHireDate() == null ? other.getHireDate() == null : this.getHireDate().equals(other.getHireDate()))
            && (this.getProbationDate() == null ? other.getProbationDate() == null : this.getProbationDate().equals(other.getProbationDate()))
            && (this.getContractStartDate() == null ? other.getContractStartDate() == null : this.getContractStartDate().equals(other.getContractStartDate()))
            && (this.getContractEndDate() == null ? other.getContractEndDate() == null : this.getContractEndDate().equals(other.getContractEndDate()))
            && (this.getIdcard() == null ? other.getIdcard() == null : this.getIdcard().equals(other.getIdcard()))
            && (this.getEmploymentType() == null ? other.getEmploymentType() == null : this.getEmploymentType().equals(other.getEmploymentType()))
            && (this.getMaritalStatus() == null ? other.getMaritalStatus() == null : this.getMaritalStatus().equals(other.getMaritalStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthdayDate() == null) ? 0 : getBirthdayDate().hashCode());
        result = prime * result + ((getPoliticsStatus() == null) ? 0 : getPoliticsStatus().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getNativePlace() == null) ? 0 : getNativePlace().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPositionId() == null) ? 0 : getPositionId().hashCode());
        result = prime * result + ((getTitleId() == null) ? 0 : getTitleId().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getEmployeeNumber() == null) ? 0 : getEmployeeNumber().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getGraduationInstitution() == null) ? 0 : getGraduationInstitution().hashCode());
        result = prime * result + ((getProfessionalName() == null) ? 0 : getProfessionalName().hashCode());
        result = prime * result + ((getHireDate() == null) ? 0 : getHireDate().hashCode());
        result = prime * result + ((getProbationDate() == null) ? 0 : getProbationDate().hashCode());
        result = prime * result + ((getContractStartDate() == null) ? 0 : getContractStartDate().hashCode());
        result = prime * result + ((getContractEndDate() == null) ? 0 : getContractEndDate().hashCode());
        result = prime * result + ((getIdcard() == null) ? 0 : getIdcard().hashCode());
        result = prime * result + ((getEmploymentType() == null) ? 0 : getEmploymentType().hashCode());
        result = prime * result + ((getMaritalStatus() == null) ? 0 : getMaritalStatus().hashCode());
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
        sb.append(", sex=").append(sex);
        sb.append(", birthdayDate=").append(birthdayDate);
        sb.append(", politicsStatus=").append(politicsStatus);
        sb.append(", nation=").append(nation);
        sb.append(", nativePlace=").append(nativePlace);
        sb.append(", email=").append(email);
        sb.append(", address=").append(address);
        sb.append(", positionId=").append(positionId);
        sb.append(", titleId=").append(titleId);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", phone=").append(phone);
        sb.append(", employeeNumber=").append(employeeNumber);
        sb.append(", education=").append(education);
        sb.append(", graduationInstitution=").append(graduationInstitution);
        sb.append(", professionalName=").append(professionalName);
        sb.append(", hireDate=").append(hireDate);
        sb.append(", probationDate=").append(probationDate);
        sb.append(", contractStartDate=").append(contractStartDate);
        sb.append(", contractEndDate=").append(contractEndDate);
        sb.append(", idcard=").append(idcard);
        sb.append(", employmentType=").append(employmentType);
        sb.append(", maritalStatus=").append(maritalStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}