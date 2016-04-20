package com.cassandra;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.pojo.ProductInvoice;

public class ConnectingToCassandra {
	final static Logger log = LoggerFactory.getLogger(ConnectingToCassandra.class);
	public void insertProductDetails(ProductInvoice productDetails, MultipartFile productimage1 ) throws IllegalStateException, IOException {
		MultipartFile productimage2 = null;
		 File convFile = new File( productimage1.getOriginalFilename());
		 productimage1.transferTo(convFile);

		Cluster cluster;
		Session session;
		log.info(productDetails.getCommerce());
		log.info(productDetails.getVendor());
		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect("arrowkeyspace");
		log.info("\tinserting values to arrowkeyspace.arrowinserttest1");
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO arrowinserttest2  (name, nam1) VALUES ('174p1',");
		builder.append(productimage2);
		builder.append(")");
		session.execute(builder.toString());

		/*ResultSet results = session.execute("SELECT * FROM arrowinserttest1");
		for (Row row : results) {
			System.out.format("%s %s \n", row.getString("name"), row.getString("name1"));
		}*/
		cluster.close();
	}
}
