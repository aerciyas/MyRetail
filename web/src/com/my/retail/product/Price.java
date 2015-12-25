package com.my.retail.product;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "PRICE")
public class Price extends DomainEntity implements Serializable{

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PRICE")
    private BigDecimal price;

    public Integer getId()
    {
        return this.id;
    }

    public BigDecimal getPrice()
    {
        return this.price;
    }

}
