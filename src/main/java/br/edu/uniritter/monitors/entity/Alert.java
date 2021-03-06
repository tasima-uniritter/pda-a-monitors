package br.edu.uniritter.monitors.entity;

import br.edu.uniritter.monitors.constant.Metric;
import br.edu.uniritter.monitors.constant.Rule;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Slf4j
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "objectMapper")
public class Alert {
    @JsonIgnore
    private ObjectMapper objectMapper = new ObjectMapper();

    private String origin;

    @Enumerated(EnumType.STRING)
    private Metric metric;

    @NotNull
    private Long value;

    private Long timestamp;

    @Enumerated(EnumType.STRING)
    private Rule rule;

    private Long threshold;

    @Override
    public String toString() {
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
            return "";
        }
    }
}
