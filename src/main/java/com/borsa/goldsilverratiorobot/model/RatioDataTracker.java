package com.borsa.goldsilverratiorobot.model;

import com.borsa.goldsilverratiorobot.entity.RatioData;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Component
public class RatioDataTracker {
    List<RatioData> dataList;

    public RatioDataTracker() {

    }

    public void setDataList(List<RatioData> dataList) {
        this.dataList = dataList;
    }

    public TradingRules analyse() {
        OptionalDouble avg = dataList.stream().limit(5).mapToDouble(RatioData::getPrice).average();

        if (avg.isPresent()) {
            if (avg.getAsDouble() >= 50 && avg.getAsDouble() < 55) {
                return TradingRules.NOTR;
            } else if (avg.getAsDouble() >= 50 && avg.getAsDouble() <= 70) {
                return TradingRules.BUYMIXED;
            } else if (avg.getAsDouble() > 70) {
                return TradingRules.BUYSILVER;
            } else if (avg.getAsDouble() < 50) {
                return TradingRules.SELLSILVER;
            }
        }
        return TradingRules.NOTR;

    }



}
