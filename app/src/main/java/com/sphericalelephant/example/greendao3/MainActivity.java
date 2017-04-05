package com.sphericalelephant.example.greendao3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.sphericalelephant.example.greendao3.entity.DaoMaster;
import com.sphericalelephant.example.greendao3.entity.DaoSession;
import com.sphericalelephant.example.greendao3.entity.Order;
import com.sphericalelephant.example.greendao3.entity.OrderDao;
import com.sphericalelephant.example.greendao3.entity.Product;
import com.sphericalelephant.example.greendao3.entity.ProductDao;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.LazyList;

import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
	private DaoSession daoSession;
	private ProductDao productDao;
	private OrderDao orderDao;
	private TextView productText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		productText = (TextView) findViewById(R.id.activity_main_tv_producttext);

		// DAO initialization
		DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "greendao_test");
		Database db = helper.getWritableDb();
		daoSession = new DaoMaster(db).newSession();
		orderDao = daoSession.getOrderDao();
		productDao = daoSession.getProductDao();

		// create a product
		Product p = new Product();
		p.setInternalId(UUID.randomUUID().toString());
		p.setName("test product");

		// create an order
		Order o = new Order();
		o.setName("Default Order");

		// insert the order
		daoSession.insert(o);

		// ... and add the product
		o.getProducts().add(p);

		showProducts();
	}

	private void showProducts() {
		LazyList<Order> orders = orderDao
				.queryBuilder()
				.where(OrderDao.Properties.Name.eq("Default Order"))
				.build()
				.listLazy();
		Product p = orders.get(0).getProducts().get(0);
		productText.setText(p.getInternalId() + " " + p.getName());
		orders.close();
	}
}
