package com.codewithrajeev.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	String ResourceName;
	String fieldName;
	long fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
      super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
      this.ResourceName = resourceName;
      this.fieldName = fieldName;
      this.fieldValue = fieldValue;
      
	}

	public String getResourceName() {
		return ResourceName;
	}

	public void setResourceName(String resourceName) {
		ResourceName = resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public long getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}
	

}
