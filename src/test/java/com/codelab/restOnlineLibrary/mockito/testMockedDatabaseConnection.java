package com.codelab.restOnlineLibrary.mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class testMockedDatabaseConnection {

	@Test
	public void testMockedDatabaseConnection() throws SQLException {
		Connection mockConnection = mock(Connection.class);
		when(mockConnection.isClosed()).thenReturn(false);

		try {
			assertFalse(mockConnection.isClosed(), "The connection must not be closed");
		} catch (SQLException e) {
			fail("Error checking connection: " + e.getMessage());
		}
	}

}
