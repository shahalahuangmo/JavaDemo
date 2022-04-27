package com.nanfa.domaindemo.dto;

import com.nanfa.domaindemo.dto.clientobject.ATAMetricCO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * ATAMetricAddCmd
 *
 * @author Frank Zhang
 * @date 2019-03-01 10:12 AM
 */
@Data
public class ATAMetricAddCmd extends CommonCommand{
    @NotNull
    private ATAMetricCO ataMetricCO;
}
