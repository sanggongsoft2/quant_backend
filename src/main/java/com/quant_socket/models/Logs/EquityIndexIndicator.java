package com.quant_socket.models.Logs;

import com.quant_socket.annotations.SG_column;
import com.quant_socket.annotations.SG_idx;
import com.quant_socket.annotations.SG_table;
import com.quant_socket.models.SG_model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@SG_table(name = "equity_index_indicator")
public class EquityIndexIndicator extends SG_model<EquityIndexIndicator> {

    @SG_idx
    @SG_column(dbField = "eii_idx")
    private Long idx;
    @SG_column(dbField = "eii_data_category")
    private String data_category;
    @SG_column(dbField = "eii_info_category")
    private String info_category;
    @SG_column(dbField = "eii_message_seq_number")
    private Integer message_seq_number;
    @SG_column(dbField = "eii_isin_code")
    private String isin_code;
    @SG_column(dbField = "eii_a_designated_number_for_an_issue")
    private Integer a_designated_number_for_an_issue;
    @SG_column(dbField = "eii_sec_group_id")
    private String sec_group_id;
    @SG_column(dbField = "eii_eps_calculation")
    private String eps_calculation;
    @SG_column(dbField = "eii_eps")
    private Float eps;
    @SG_column(dbField = "eii_loss_category")
    private String loss_category;
    @SG_column(dbField = "eii_per")
    private Double per;
    @SG_column(dbField = "eii_bps_calculation")
    private String bps_calculation;
    @SG_column(dbField = "eii_bps")
    private Float bps;
    @SG_column(dbField = "eii_pbr")
    private Double pbr;
    @SG_column(dbField = "eii_dps_calculation")
    private String dps_calculation;
    @SG_column(dbField = "eii_dps")
    private Float dps;
    @SG_column(dbField = "eii_dividend_yield")
    private Double dividend_yield;
    @SG_column(dbField = "eii_market_capitalization")
    private String market_capitalization;
    @SG_column(dbField = "eii_manufacturing")
    private String manufacturing;
    @SG_column(dbField = "eii_index_classification_level1")
    private String index_classification_level1;
    @SG_column(dbField = "eii_index_classification_level2")
    private String index_classification_level2;
    @SG_column(dbField = "eii_index_classification_level3")
    private String index_classification_level3;
    @SG_column(dbField = "eii_kospi200_sector_code1")
    private String kospi200_sector_code1;
    @SG_column(dbField = "eii_kospi200_sector_code2")
    private String kospi200_sector_code2;
    @SG_column(dbField = "eii_is_kospi")
    private String is_kospi;
    @SG_column(dbField = "eii_is_kosdaq")
    private String is_kosdaq;
    @SG_column(dbField = "eii_is_kospi100")
    private String is_kospi100;
    @SG_column(dbField = "eii_is_kospi50")
    private String is_kospi50;
    @SG_column(dbField = "eii_kosdaq150")
    private String kosdaq150;
    @SG_column(dbField = "eii_krx100")
    private String krx100;
    @SG_column(dbField = "eii_krx300")
    private String krx300;
    @SG_column(dbField = "eii_kospi200_high_dividend_yield_index")
    private String kospi200_high_dividend_yield_index;
    @SG_column(dbField = "eii_krx_bbig_knew_deal_index")
    private String krx_bbig_knew_deal_index;
    @SG_column(dbField = "eii_krx_second_battery_knew_deal_index")
    private String krx_second_battery_knew_deal_index;
    @SG_column(dbField = "eii_krx_bio_knew_deal_index")
    private String krx_bio_knew_deal_index;
    @SG_column(dbField = "eii_filler")
    private String filler;
    @SG_column(dbField = "eii_end_keyword")
    private String end_keyword;

    public EquityIndexIndicator(String msg) {
        int index = 0;
        data_category = msg.substring(index, index += 2);
        info_category = msg.substring(index, index += 3);
        message_seq_number = Integer.valueOf(msg.substring(index, index += 8));
        isin_code = msg.substring(index, index += 12);
        a_designated_number_for_an_issue = Integer.valueOf(msg.substring(index, index += 6));
        sec_group_id = msg.substring(index, index += 2);
        eps_calculation = msg.substring(index, index += 1);
        eps = Float.valueOf(msg.substring(index, index += 22));
        loss_category = msg.substring(index, index += 1);
        per = Double.valueOf(msg.substring(index, index += 13));
        bps_calculation = msg.substring(index, index += 1);
        bps = Float.valueOf(msg.substring(index, index += 22));
        pbr = Double.valueOf(msg.substring(index, index += 13));
        dps_calculation = msg.substring(index, index += 1);
        dps = Float.valueOf(msg.substring(index, index += 22));
        dividend_yield = Double.valueOf(msg.substring(index, index += 13));
        market_capitalization = msg.substring(index, index += 1);
        manufacturing = msg.substring(index, index += 1);
        index_classification_level1 = msg.substring(index, index += 6);
        index_classification_level2 = msg.substring(index, index += 6);
        index_classification_level3 = msg.substring(index, index += 6);
        kospi200_sector_code1 = msg.substring(index, index += 1);
        kospi200_sector_code2 = msg.substring(index, index += 1);
        is_kospi = msg.substring(index, index += 1);
        is_kosdaq = msg.substring(index, index += 1);
        is_kospi100 = msg.substring(index, index += 1);
        is_kospi50 = msg.substring(index, index += 1);
        kosdaq150 = msg.substring(index, index += 1);
        krx100 = msg.substring(index, index += 1);
        krx300 = msg.substring(index, index += 1);
        kospi200_high_dividend_yield_index = msg.substring(index, index += 1);
        krx_bbig_knew_deal_index = msg.substring(index, index += 1);
        krx_second_battery_knew_deal_index = msg.substring(index, index += 1);
        krx_bio_knew_deal_index = msg.substring(index, index += 1);
        filler = msg.substring(index, index += 9);
        end_keyword = msg.substring(index, index + 1);
    }

    public Map<String, Object> toMap() {
        final Map<String, Object> data = new HashMap<>();
        for(final Field f: this.getClass().getDeclaredFields()) {
            if(f.isAnnotationPresent(SG_column.class)) {
                final SG_column sc = f.getAnnotation(SG_column.class);
                try {
                    data.put(sc.dbField(), f.get(this));
                } catch (Exception ignore) {
                }
            }
        }
        return data;
    }
}