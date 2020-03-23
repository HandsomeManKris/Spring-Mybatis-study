package com.mybatisdays;

import java.sql.Time;
import java.sql.Timestamp;
//编写实体类
public class Student {
    private Integer id;

    public String getCreateAtStr() {
        return createAtStr;
    }

    public void setCreateAtStr(String createAtStr) {
        this.createAtStr = createAtStr;
    }

    public String getUpdateAtStr() {
        return updateAtStr;
    }

    public void setUpdateAtStr(String updateAtStr) {
        this.updateAtStr = updateAtStr;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    private Timestamp create_at;
        private Timestamp update_at;
    //private long create_at;
    private String createAtStr;
    private String updateAtStr;
    private String dateStr;
   // private long update_at;
    private  String name;
    private Integer  QQ;
    private  String type_job;

    private  String date;
    //private  long date;
    private  String school;
    private Integer number_online;
    private  String daily;
    private String dream;
    private String brother;
    private String where_know;
//
//public Student(Integer id, long create_at, long update_at, String name, Integer QQ, String type_job, long date, String school, Integer number_online, String daily, String dream, String brother, String where_know) {
    public Student(Integer id, Timestamp create_at, Timestamp update_at, String name, Integer QQ, String type_job, String date, String school, Integer number_online, String daily, String dream, String brother, String where_know) {
        this.id = id;
        this.create_at = create_at;
        this.createAtStr = createAtStr;
        this.updateAtStr = updateAtStr;
        this.dateStr = dateStr;
        this.update_at = update_at;
        this.name = name;
        this.QQ = QQ;
        this.type_job = type_job;
        this.date = date;
        this.school = school;
        this.number_online = number_online;
        this.daily = daily;
        this.dream = dream;
        this.brother = brother;
        this.where_know = where_know;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }
   public void setCreate_at(Timestamp create_at){
       this.create_at = create_at;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }
    /*public long getCreate_at() {
        return create_at;
    }
    public void setCreate_at(long create_at){
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }*/
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /*public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }*/
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
    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", name='" + name + '\'' +
                ", QQ=" + QQ +
                ", type_job='" + type_job + '\'' +
                ", date='" + date + '\'' +
                ", school='" + school + '\'' +
                ", number_online=" + number_online +
                ", daily='" + daily + '\'' +
                ", dream='" + dream + '\'' +
                ", brother='" + brother + '\'' +
                ", where_know='" + where_know + '\'' +
                '}';
    }
}
