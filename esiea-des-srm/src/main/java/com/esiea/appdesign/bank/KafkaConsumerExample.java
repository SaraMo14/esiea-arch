package com.esiea.appdesign.bank;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

public class KafkaConsumerExample {
	public static void main(String[] args) {
		Properties props = new Properties();
	     props.setProperty("bootstrap.servers", "localhost:9092");
	     props.setProperty("group.id", "test");
	     props.setProperty("enable.auto.commit", "true");
	     //props.setProperty("auto.commit.interval.ms", "1000");
	     props.setProperty("session.timeout.ms", "8000");
	     props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
	     consumer.subscribe(Arrays.asList("bankTransactionDataFlow"), new ConsumerRebalanceListener() {
			@Override
			public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
				System.out.printf("%s topic-partitions are revoked from this customer",
						Arrays.toString(partitions.toArray()));
				
			}
			
			@Override
			public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
				System.out.printf("%s topic-partitions are assigned to this customer",
						Arrays.toString(partitions.toArray()));
				
			}});
	     while (true) {
	         ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
	         for (ConsumerRecord<String, String> record : records) {
	            // System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
	             BankTransaction  bankTransaction = BankTransaction.jsonTransactionToObject(record.value());
	             if(bankTransaction.getAmount()<=2000) {
	            	 System.out.println();
	            	 System.out.println("idclient: " + bankTransaction.getIdclient());
	            	 System.out.println("firstname: " + bankTransaction.getFirstname());
	            	 System.out.println("lastname: " + bankTransaction.getLastname());
	            	 System.out.println("amount: " + bankTransaction.getAmount());
	            	 System.out.println("transactdate: " + bankTransaction.getTransactdate());
	             }else {
	            	 System.out.println("Amount > 2000: fraud!");
	             }
	         }
	     }
	}
}
