package br.com.okto.view.builder;

import java.lang.reflect.Field;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FieldSetConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(FieldSetConfig.class);

	private String title;
	private List<FieldValueConfig> fields;
	
	public void mergeFields(Object objectFields) {
		if (objectFields == null) {
			return ;
		}
		try {
			Field[] declaredFields = objectFields.getClass().getDeclaredFields();
			for (FieldValueConfig fieldValueConfig : fields) {
				if (containsField(fieldValueConfig.getAttrName(), declaredFields)) {
					Field field = objectFields.getClass().getDeclaredField(fieldValueConfig.getAttrName());
					field.setAccessible(true);
					Object value = field.get(objectFields);
					fieldValueConfig.setValue(value);
				}
			}
		} catch (Exception e) {
			LOG.error("Error trying to merge fields", e);
		}
	}
	
	private boolean containsField(String attrName, Field[] declaredFields) {
		for (Field field : declaredFields) {
			if (field.getName().equals(attrName)) {
				return true;
			}
		}
		return false;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<FieldValueConfig> getFields() {
		return fields;
	}
	public void setFields(List<FieldValueConfig> fields) {
		this.fields = fields;
	}
}
