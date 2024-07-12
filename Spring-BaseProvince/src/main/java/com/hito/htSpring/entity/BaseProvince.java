package com.hito.htSpring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * (BaseProvince)表实体类
 *
 * @author makejava
 * @since 2024-07-12 17:02:12
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "base_province")
public class BaseProvince {

    @Id
    private String id;

    private String name;

    private String region_id;

    private String area_code;

    private String iso_code;

    private String iso_3166_2;

    private String create_time;

    private String operate_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegion_id() {
        return region_id;
    }

    public void setRegion_id(String region_id) {
        this.region_id = region_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso_code() {
        return iso_code;
    }

    public void setIso_code(String iso_code) {
        this.iso_code = iso_code;
    }

    public String getIso_3166_2() {
        return iso_3166_2;
    }

    public void setIso_3166_2(String iso_3166_2) {
        this.iso_3166_2 = iso_3166_2;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getOperate_time() {
        return operate_time;
    }

    public void setOperate_time(String operate_time) {
        this.operate_time = operate_time;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }
}

