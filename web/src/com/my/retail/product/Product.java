package com.my.retail.product;

import org.json.JSONObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PRODUCT")
public class Product extends DomainEntity implements Serializable
{
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "SKU")
    private String sku;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "LAST_UPDATED")
    private Date lastUpdated;

    public Integer getId()
    {
        return this.id;
    }

    public String getSku()
    {
        return this.sku;
    }

    public String getName()
    {
        return this.name;
    }

    public String getCategory() {return this.category;}

    public Date getLastUpdated()
    {
        return this.lastUpdated;
    }

}
