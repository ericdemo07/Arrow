package com.cassandra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.pojo.ProductDetails;

public class ConnectingToCassandra {
	final static Logger log = LoggerFactory.getLogger(ConnectingToCassandra.class);
	public void insertProductDetails(ProductDetails productDetails) {
		Cluster cluster;
		Session session;
		log.info(productDetails.getCommerce());
		log.info(productDetails.getVendor());

		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect("arrowkeyspace");
		log.info("\tinserting values to arrowkeyspace.arrowinserttest1");
		session.execute("INSERT INTO arrowinserttest1 (name, name1) VALUES ('174p', 'jAMES')");

		/*ResultSet results = session.execute("SELECT * FROM arrowinserttest1");
		for (Row row : results) {
			System.out.format("%s %s \n", row.getString("name"), row.getString("name1"));
		}*/
		cluster.close();
	}
}
