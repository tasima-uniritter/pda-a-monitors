package br.edu.uniritter.monitors.entity;

import br.edu.uniritter.monitors.constant.MetricName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metric {
    private String origin;

    @Enumerated(EnumType.STRING)
    @JsonProperty("metric")
    private MetricName name;

    @NotNull
    private Long value;

    private Long timestamp;

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
            return "";
        }
    }
}
