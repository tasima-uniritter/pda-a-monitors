package br.edu.uniritter.monitors.entity;

import br.edu.uniritter.monitors.constant.Metric;
import br.edu.uniritter.monitors.contracts.ThresholdRule;
import br.edu.uniritter.monitors.converters.RuleConverter;
import br.edu.uniritter.monitors.converters.ThresholdRuleSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class OutputMessage {
    private String origin;

    @Enumerated(EnumType.STRING)
    private Metric metric;

    @NotNull
    private Long value;

    private Long timestamp;

    @Convert(converter = RuleConverter.class)
    private ThresholdRule rule;

    private Long threshold;

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}