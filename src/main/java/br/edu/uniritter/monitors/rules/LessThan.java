package br.edu.uniritter.monitors.rules;

import br.edu.uniritter.monitors.contracts.ThresholdRule;

public class LessThan extends ThresholdRule {

    @Override
    public Boolean compare(Long value, Long threshold) {
        return value < threshold;
    }
}
