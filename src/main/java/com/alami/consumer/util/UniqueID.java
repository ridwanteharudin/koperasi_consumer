/*
 * 
 */
package com.alami.consumer.util;

import java.util.UUID;

public class UniqueID {
	public static synchronized String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}
}
