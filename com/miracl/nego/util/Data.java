package com.miracl.nego.util;

import java.io.Serializable;

public class Data implements Serializable{
private String _key;

private String _value;

public Data(String _key, String _value)
{
	this._key = _key;
	this._value=_value;
	
}


public String get_key() {
	return _key;
}
public void set_key(String _key) {
	this._key = _key;
}
public String get_value() {
	return _value;
}
public void set_value(String _value) {
	this._value = _value;
}

}
