package com.it.Baomingtie;

import java.sql.Date;
import java.sql.Timestamp;

public class Jnshu {
    //使用基本的类型封装类
    private Integer id;
    private Timestamp create_at;
    private Timestamp update_at;
    private String name;
    private Integer QQ;
    private String type_job;
    private Date date;
    private String school;
    private Integer number_online;
    private String daily;
    private String dream;
    private String brother;
    private String where_know;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQQ() {
        return QQ;
    }

    public void setQQ(Integer QQ) {
        this.QQ = QQ;
    }

    public String getType_job() {
        return type_job;
    }

    public void setType_job(String type_job) {
        this.type_job = type_job;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getNumber_online() {
        return number_online;
    }

    public void setNumber_online(Integer number_online) {
        this.number_online = number_online;
    }

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }

    public String getDream() {
        return dream;
    }

    public void setDream(String dream) {
        this.dream = dream;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public String getWhere_know() {
        return where_know;
    }

    public void setWhere_know(String where_know) {
        this.where_know = where_know;
    }

    @Override
    public String toString() {
        return "Jnshu{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", name='" + name + '\'' +
                ", QQ=" + QQ +
                ", type_job='" + type_job + '\'' +
                ", date=" + date +
                ", school='" + school + '\'' +
                ", number_online=" + number_online +
                ", daily='" + daily + '\'' +
                ", dream='" + dream + '\'' +
                ", brother='" + brother + '\'' +
                ", where_know='" + where_know + '\'' +
                '}';
    }
}
