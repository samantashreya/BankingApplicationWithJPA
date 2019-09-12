package com.cg;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

public class SqlDateEditor extends PropertyEditorSupport{

	@Override
	public String getAsText() {
		// for returning the value
		
		return getValue().toString();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// to convert date to corresponding data type
		if(text.equalsIgnoreCase("getDate()")){
			Date date = new Date(System.currentTimeMillis());
			setValue(date);
		}
		else {
			Date date = Date.valueOf(text);
			setValue(date);
		}
	}

}
