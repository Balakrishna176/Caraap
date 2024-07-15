package com.edubridge.Carapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.Carapp.Car;
import com.edubridge.Carapp.utill.DBUtils1;

public class CarDaoImpl implements CarDao {

	@Override
	public int addCar(Car c) {
		
		String INSERT = "insert into car(company, model, colour, fuel_type, engine_cc, price) values(?,?,?,?,?,?)";
		Connection con = DBUtils1.getConnection();
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(INSERT);
			ps.setString(1, c.getCompany());
			ps.setString(2, c.getModel());
			ps.setString(3, c.getColour());
			ps.setString(4, c.getFuel_type());
			ps.setInt(5, c.getEngine_cc());
			ps.setFloat(6, c.getPrice());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Car> getAllCars() {
		
		String SELECT = "select * from car";
		Connection con = DBUtils1.getConnection();
		List<Car> cars = new ArrayList<Car>();
		try {
			PreparedStatement ps = con.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Car c = new Car();
				c.setId(rs.getInt("id"));
				c.setCompany(rs.getString("company"));
				c.setModel(rs.getString("model"));
				c.setColour(rs.getString("colour"));
				c.setFuel_type(rs.getString("fuel_type"));
				c.setEngine_cc(rs.getInt("engine_cc"));
				c.setPrice(rs.getFloat("price"));
				cars.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public Car getCar(String name) {
		String SELECT_BY_NAME = "select * from car where model = ?";
		Connection con = DBUtils1.getConnection();
		Car c = new Car();
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_BY_NAME);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c.setId(rs.getInt("id"));
				c.setCompany(rs.getString("company"));
				c.setModel(rs.getString("model"));
				c.setColour(rs.getString("colour"));
				c.setFuel_type(rs.getString("fuel_type"));
				c.setEngine_cc(rs.getInt("engine_cc"));
				c.setPrice(rs.getFloat("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	

	@Override
	public int updateCar(Car c) {
		String UPDATE = "update car set company = ?, model = ?, colour = ?, fuel_type = ?, engine_cc = ?, price = ? where id = ?";
		Connection con = DBUtils1.getConnection();
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(UPDATE);
			ps.setString(1, c.getCompany());
			ps.setString(2, c.getModel());
			ps.setString(3, c.getColour());
			ps.setString(4, c.getFuel_type());
			ps.setInt(5, c.getEngine_cc());
			ps.setFloat(6, c.getPrice());
			ps.setInt(7, c.getId());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}


	@Override
	public int deleteCar(String name) {
		String DELETE = "delete from car where model = ?";
		Connection con = DBUtils1.getConnection();
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(DELETE);
			ps.setString(1, name);
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}


	@Override
	public void deleteAllCars() {
		String DELETE_ALL = "delete from car";
		Connection con = DBUtils1.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_ALL);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
