package com.schautdollar.DonorDreams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class SaveWrapper {
	public ConfigAccessor file;
	public SaveWrapper(ConfigAccessor instance) {
		this.file = instance;
	}
	/**
	 * method saveBoolean. Saves in yml as:
	 * key: true
	 */
	public void saveBoolean(String key, boolean bool) {
		this.file.getConfig().set("BLN"+key, bool);
	}
	/**
	 * method saveString. Saves in yml as:
	 * key: String
	 */
	public void saveString(String key, String value) {
		this.file.getConfig().set("STR"+key, value);
	}
	/**
	 * method saveInt. Saves in yml as:
	 * key: 1
	 */
	public void saveInt(String key, int value) {
		this.file.getConfig().set("INT"+key, value);
	}
	/**
	 * method saveList. Saves in yml as:
	 * key:
	 *   -value
	 *   -value2
	 */
	public void saveList(String key, List<?> value) {
		this.file.getConfig().set("LIST"+key, value);
	}
	/**
	 * method saveStringArray. Saves in yml as:
	 * key:
	 *   -StringOne
	 *   -StringTwo
	 */
	public void saveArray(String key, Object[] value) {
		this.saveList(key, Arrays.asList(value));
	}
	/**
	 * method saveHashMap. Saves in yml as:
	 * key:
	 *   hashKey1: hashValue1
	 *   hashKey2: hashValue2
	 */
	public void saveHashMap(String key, HashMap<?, ?> value) {
		this.file.getConfig().createSection("HMAP"+key, value);
	}
	/**
	 * method saveHashtable. Saves in yml as:
	 * key:
	 *   hashKey1: hashValue1
	 *   hashKey2: hashValue2
	 */
	public void saveHashTable(String key, Hashtable<?, ?> value) {
		this.file.getConfig().createSection("HTABLE"+key, value);
	}
}
