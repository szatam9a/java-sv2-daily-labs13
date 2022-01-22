package day05;

import org.junit.jupiter.api.Test;

class TransferAggregatorTest {

    @Test
    void startTest() {
        TransferAggregator transferAggregator = new TransferAggregator();
        transferAggregator.start();
        transferAggregator.summer();
    }
}