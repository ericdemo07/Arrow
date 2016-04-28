package com.cassandra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.pojo.ProductDetails;

public class ConnectingToCassandra {
	final static Logger log = LoggerFactory.getLogger(ConnectingToCassandra.class);
	Cluster cluster;

	public Session getSession() {
		Session session = null;
		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect("arrowkeyspace");
		return session;
	}
	
	public List<ProductDetails> getUserHomeData()
	{
		Session session = getSession();
		String getProductListByUserIdQuery = "SELECT product_type, brand_name, model_name, product_desc, update_date FROM arrowproducts WHERE user_id = 'ayush' ALLOW FILTERING";
		log.info("\tgetting productListByUserId from arrowkeyspace.arrowproducts");
		ResultSet getProductListByUserId = session.execute(getProductListByUserIdQuery);
		List<ProductDetails> productDetailList = new ArrayList<>();
		for(Row row : getProductListByUserId.all())
		{
			ProductDetails productDetails = new ProductDetails();
			productDetails.setProductType(row.getString("product_type"));
			productDetails.setBrandName(row.getString("brand_name"));
			productDetails.setModelName(row.getString("model_name"));
			productDetails.setProductDescription(row.getString("product_desc"));
			productDetailList.add(productDetails);
		}
		return productDetailList;
	}

	public void insertProductDetails(ProductDetails productDetails) throws IllegalStateException, IOException {
		Session session = getSession();
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
		session.execute(insertStringBuilder.toString());

		/*
		 * ResultSet results = session.execute("SELECT * FROM arrowinserttest1"
		 * ); for (Row row : results) { System.out.format("%s %s \n",
		 * row.getString("name"), row.getString("name1")); }
		 */
		cluster.close();
	}
}
