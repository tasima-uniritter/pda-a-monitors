package br.edu.uniritter.monitors.service;

import br.edu.uniritter.monitors.constant.Metric;
import br.edu.uniritter.monitors.constant.Rule;
import br.edu.uniritter.monitors.entity.Threshold;
import br.edu.uniritter.monitors.repository.ThresholdRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ThresholdServiceTest {

    @Mock
    private ThresholdRepository thresholdRepository;

    @InjectMocks
    private ThresholdService thresholdService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCallThresholdRepositoryFindAll() {

        // given the mocked thresholds
        List<Threshold> thresholds = new ArrayList<Threshold>();
        thresholds.add(new Threshold(1L, "some-origin", Metric.MEMORY_USAGE, Rule.GREATER_THAN, 100L));

        // when I call service All
        Mockito.when(thresholdRepository.findAll()).thenReturn(thresholds);

        List<Threshold> thresholdsFounded = thresholdService.all();

        // then I expect all thresholds
        assertSame(thresholds, thresholdsFounded);

    }

    @Test
    public void shouldCallThresholdRepositoryFindOneByOriginAndMetric() {

        // given the mocked threshold
        Threshold threshold = new Threshold(1L, "some-origin", Metric.MEMORY_USAGE, Rule.GREATER_THAN, 100L);


        // when I call service findOneByOriginAndMetric
        Mockito.when(thresholdRepository.findOneByOriginAndMetric("some-origin", Metric.MEMORY_USAGE)).thenReturn(threshold);

        Threshold thresholdFounded = thresholdService.findOneByOriginAndMetric("some-origin", Metric.MEMORY_USAGE);

        // then I expect the threshold
        assertEquals(threshold.getId(), thresholdFounded.getId());
    }


}