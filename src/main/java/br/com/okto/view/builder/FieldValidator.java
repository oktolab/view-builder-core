package br.com.okto.view.builder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

/**
 * TODO 
 * validar confirmAttrName
 * validar type combo - options value
 *
 */
public class FieldValidator {
	
	private static final Logger LOG = LoggerFactory.getLogger(FieldValidator.class);
	
	private String errorMessage;
	
	public FieldValidator(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public List<String> validateFieldSets(JsonObject jsonObj, List<FieldSetConfig> fieldSets) {
		List<String> lsMessages = new ArrayList<String>();
		if (fieldSets == null || fieldSets.size() == 0) {
			return lsMessages;
		}
		for (FieldSetConfig fieldSetConfig : fieldSets) {
			lsMessages.addAll(validateFields(jsonObj, fieldSetConfig));
		}
		return lsMessages;
	}

	public List<String> validateFields(JsonObject jsonObj, FieldSetConfig fieldSetConfig) {
		List<String> lsMessages = new ArrayList<String>();
		List<FieldValueConfig> fields = fieldSetConfig.getFields();
		for (FieldValueConfig config : fields) {
			if (config.isRequired() == false) {
				continue ;
			}
			try {
				if (!jsonObj.has(config.getAttrName()) || jsonObj.get(config.getAttrName()).isJsonNull()) {
					String label = config.getLabel();
					lsMessages.add(String.format(errorMessage, label));
				}
			} catch (SecurityException | IllegalArgumentException e) {
				LOG.error(String.format("Error %s.", getClass()), e);
			}
		}
		return lsMessages;
	}
	
	public List<String> validateFields(Object dto, Class<?> clazz, FieldSetConfig fieldSetConfig) {
		List<String> lsMessages = new ArrayList<String>();
		List<FieldValueConfig> fields = fieldSetConfig.getFields();
		for (FieldValueConfig config : fields) {
			if (config.isRequired() == false) {
				continue ;
			}
			try {
				Field field = clazz.getDeclaredField(config.getAttrName());
				field.setAccessible(true);
				Object value = field.get(dto);
				if (value == null) {
					String label = config.getLabel();
					lsMessages.add(String.format(errorMessage, label));
				}
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				LOG.error(String.format("Error %s.", getClass()), e);
			}
		}
		return lsMessages;
	}
}
