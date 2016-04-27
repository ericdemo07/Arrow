package com.cassandra;

import java.io.IOException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.pojo.ProductDetails;

public class ConnectingToCassandra {
	final static Logger log = LoggerFactory.getLogger(ConnectingToCassandra.class);

	public void insertProductDetails(ProductDetails productDetails) throws IllegalStateException, IOException {
		// MultipartFile productimage2 = null;
		// File convFile = new File( productimage1.getOriginalFilename());
		// productimage1.transferTo(convFile);

		Cluster cluster;
		Session session;
		// log.info(productDetails.getProductType());
		// log.info(productDetails.getVendor());
		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect("arrowkeyspace");

		String getMaxserialNoQuery = "SELECT MAX(serial_no) FROM arrowproducts";
		log.info("\tgetting maxSerialNo from arrowkeyspace.arrowproducts");
		ResultSet getMaxserialNo = session.execute(getMaxserialNoQuery);
		Integer maxSerialNo = getMaxserialNo.all().get(0).getInt(0);
		Integer nextSerialNo = maxSerialNo + 1;
		log.info("\tinserting values to arrowkeyspace.arrowproducts");
		StringBuilder insertStringBuilder = new StringBuilder();
		insertStringBuilder.append(
				"INSERT INTO arrowkeyspace.arrowproducts (serial_no, product_desc, product_type, brand_name, model_name, composite_invoice, create_date, product_image_1, product_image_2, product_image_3, update_date, user_id) VALUES (");
		insertStringBuilder.append(nextSerialNo);
		insertStringBuilder.append(",'");
		insertStringBuilder.append(productDetails.getProductDescription());
		insertStringBuilder.append("','");
		insertStringBuilder.append(productDetails.getProductType());
		insertStringBuilder.append("','");
		insertStringBuilder.append(productDetails.getBrandName());
		insertStringBuilder.append("','");
		insertStringBuilder.append(productDetails.getModelName());
		insertStringBuilder.append("','");
		insertStringBuilder.append("null");
		insertStringBuilder.append("','");
		DateTime createDate = new DateTime(DateTimeZone.UTC);
		insertStringBuilder.append(createDate);
		insertStringBuilder.append("','");
		insertStringBuilder.append("null");
		insertStringBuilder.append("','");
		insertStringBuilder.append("null");
		insertStringBuilder.append("','");
		insertStringBuilder.append("null");
		insertStringBuilder.append("','");
		insertStringBuilder.append(createDate);
		insertStringBuilder.append("','");
		insertStringBuilder.append("ayush')");
		System.out.println(insertStringBuilder.toString());
		session.execute(insertStringBuilder.toString());

		/*
		 * ResultSet results = session.execute("SELECT * FROM arrowinserttest1"
		 * ); for (Row row : results) { System.out.format("%s %s \n",
		 * row.getString("name"), row.getString("name1")); }
		 */
		cluster.close();
	}
}
