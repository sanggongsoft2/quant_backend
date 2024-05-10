package com.quant_socket.models.Logs.prod;

import com.quant_socket.annotations.SG_column;
import com.quant_socket.annotations.SG_crdt;
import com.quant_socket.annotations.SG_idx;
import com.quant_socket.annotations.SG_table;
import com.quant_socket.models.Product;
import com.quant_socket.models.SG_model;

import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@SG_table(name = "product_minute")
public class ProductMinute extends SG_model {
    @SG_idx
    @SG_column(dbField = "m_idx")
    private Long idx;
    @SG_column(dbField = "p_code")
    private String isinCode;
    @SG_column(dbField = "m_close")
    private Double close;
    @SG_column(dbField = "m_high")
    private Double high;
    @SG_column(dbField = "m_low")
    private Double low;
    @SG_column(dbField = "m_open")
    private Double open;
    @SG_column(dbField = "m_volume")
    private Long volume;
    @SG_column(dbField = "m_pre_close")
    private Double pre_close;
    @SG_column(dbField = "m_date")
    private Date date;
    @SG_column(dbField = "m_time")
    private Time time;
    @SG_crdt
    @SG_column(dbField = "m_crdt")
    private Timestamp createdAt;

    public ProductMinute(ResultSet rs) {
        resultSetToClass(rs);
    }

    static public String[] insertCols() {
        return new String[] {
                "p_code",
                "m_close",
                "m_high",
                "m_low",
                "m_open",
                "m_volume",
                "m_pre_close",
        };
    }

    public ProductMinute(Product prod) {
        this.isinCode = prod.getCode();
        this.close = prod.getCurrentPrice();
        this.high = prod.getHighPrice();
        this.low = prod.getLowPrice();
        this.open = prod.getOpenPrice();
        this.volume = prod.getTradingVolume();
        this.pre_close = prod.getCurrentPrice();
    }
}