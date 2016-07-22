package br.com.okto.view.builder;

import java.util.List;

public class FieldValueConfig {

	private String label;
	private String type;
	private String placeholder;
	private String tip;
	private String attrName;
	private String confirmAttrName;
	private Object value;
	private Boolean required;
	private Boolean disabled;
	private Boolean readonly;
	private Integer minLength;
	private Integer maxLength;
	private List<FieldValueOption> options;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Boolean getDisabled() {
		return disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	public Boolean getReadonly() {
		return readonly;
	}
	public void setReadonly(Boolean readonly) {
		this.readonly = readonly;
	}
	public List<FieldValueOption> getOptions() {
		return options;
	}
	public void setOptions(List<FieldValueOption> options) {
		this.options = options;
	}
	public Integer getMinLength() {
		return minLength;
	}
	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}
	public Integer getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getConfirmAttrName() {
		return confirmAttrName;
	}
	public void setConfirmAttrName(String confirmAttrName) {
		this.confirmAttrName = confirmAttrName;
	}
	public Boolean isRequired() {
		return required != null && required;
	}
	public void setRequired(Boolean required) {
		this.required = required;
	}
}
