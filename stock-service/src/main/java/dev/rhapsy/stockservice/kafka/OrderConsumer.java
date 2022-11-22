package dev.rhapsy.stockservice.kafka;

import dev.rhapsy.basedomains.dto.OrderEvent;
import dev.rhapsy.stockservice.StockOrderRepository;
import dev.rhapsy.stockservice.entity.StockOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderConsumer {

    private final StockOrderRepository stockOrderRepository;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event) {
        log.info(String.format("Order event received in stock service -> %s", event.toString()));

        // save the order event into a database
        StockOrder stockOrder = StockOrder.builder()
                .orderDetails(event.toString())
                .build();
        stockOrderRepository.save(stockOrder);
    }
}
