package com.avizva.test.controller;

import java.io.IOException;
import java.net.SocketException;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.avizva.test.config.ApplicationContextConfigTest;

@WebAppConfiguration
@ContextConfiguration(classes = ApplicationContextConfigTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ErrorExceptionHandlerTest {

	@Test(expected = Exception.class)
	public void testExceptionHandler() throws Exception {
		throw new Exception();
	}

	@Test(expected = SQLException.class)
	public void testSQLExceptionHandler() throws SQLException {
		throw new SQLException();
	}

	@Test(expected = IOException.class)
	public void testIOExceptionHandler() throws IOException {
		throw new IOException();
	}

	@Test(expected = NullPointerException.class)
	public void testNullPointerExceptionHandler() throws NullPointerException {
		throw new NullPointerException();
	}

	@Test(expected = SocketException.class)
	public void testSocketExceptionHandler() throws SocketException {
		throw new SocketException();
	}
}
