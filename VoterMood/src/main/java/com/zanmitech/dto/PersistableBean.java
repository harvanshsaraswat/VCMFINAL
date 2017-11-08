package com.zanmitech.dto;

public abstract class PersistableBean {
	private transient Boolean newBean = true;
	private transient Boolean updated=false;
	private transient Boolean existing=true;

	
	public PersistableBean(Boolean newBean, Boolean existing) {
		this.newBean = newBean;
		this.existing = existing;
	}

	public PersistableBean(Boolean newBean) {
		this.newBean = newBean;
	}

	public Boolean getNewBean() {
		return newBean;
	}

	public void setNewBean(Boolean newBean) {
		this.newBean = newBean;
	}

	public Boolean getUpdated() {
		return updated;
	}

	public void setUpdated(Boolean updated) {
		this.updated = updated;
	}
	public Boolean getExisting() {
		return existing;
	}
	public void setExisting(Boolean existing) {
		this.existing = existing;
	}

	public void setNewUpdate() {
		if (existing) {
			setNewBean(true);
			setUpdated(true);
		}
	}
	
	public void processPostPersist() {
		setNewBean(false);
		setUpdated(false);
		setExisting(false);
	}
}
