package com.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class ConnectingToCassandra 
{
	/*public static void main(String...args)
	{
		Cluster cluster;
		Session session;
		
		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect("mykeyspace");
		
		session.execute("INSERT INTO users (user_id,  fname, lname) VALUES (1745, 'john', 'smith')");
		
		ResultSet results = session.execute("SELECT * FROM users");
		for (Row row : results) 
		{
			System.out.format("%s %d\n", row.getString("fname"), row.getInt("user_id"));
		}
		cluster.close();
	}*/
}
