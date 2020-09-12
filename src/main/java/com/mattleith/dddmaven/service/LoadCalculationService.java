package com.mattleith.dddmaven.service;

import com.mattleith.dddmaven.model.Load;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LoadCalculationService {

    public LoadCalculationService() {
        setupLoads();
    }

    public Load getHighestAverageShippingCostLoad() {
        List<Load> loads = setupLoads();

        Load loadWithHighestAverageShippingCost = loads.get(0);
        for (Load load : loads) {
            if (load.getAverageShippingCost() > loadWithHighestAverageShippingCost.getAverageShippingCost()) {
                loadWithHighestAverageShippingCost = load;
            }
        }
        return loadWithHighestAverageShippingCost;
    }

    private List<Load> setupLoads() {
        Load load1 = new Load.Builder()
                .withStandardItem(1)
                .withStandardItem(5)
                .withLightweightItem(1)
                .build();
        Load load2 = new Load.Builder()
                .withStandardItem(2)
                .withLightweightItem(3)
                .withBulkyItem(1)
                .build();
        Load load3 = new Load.Builder()
                .withStandardItem(1)
                .withBulkyItem(1)
                .withBulkyItem(2)
                .build();
        Load load4 = new Load.Builder()
                .withStandardItem(2)
                .withLightweightItem(2)
                .withLightweightItem(3)
                .build();
        return Arrays.asList(load1, load2, load3, load4);
    }
}
