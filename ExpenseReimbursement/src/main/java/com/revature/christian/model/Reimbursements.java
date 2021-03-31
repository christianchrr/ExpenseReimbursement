package com.revature.christian.model;

public class Reimbursements {
	
	private Integer reimbursement_id;
	private Integer user_id;
	private String reason;
	private Double amount;
	private String status;
	
	public Reimbursements() {
		super();
	}
	
	public Reimbursements(Integer reimbursement_id, Integer user_id, String reason, Double amount, String status) {
		super();
		this.setReimbursement_id(reimbursement_id);
		this.setUser_id(user_id);
		this.setReason(reason);
		this.setAmount(amount);
		this.setStatus(status);
	}

	public Integer getReimbursement_id() {
		return reimbursement_id;
	}

	public void setReimbursement_id(Integer reimbursement_id) {
		this.reimbursement_id = reimbursement_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((reimbursement_id == null) ? 0 : reimbursement_id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursements other = (Reimbursements) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (reimbursement_id == null) {
			if (other.reimbursement_id != null)
				return false;
		} else if (!reimbursement_id.equals(other.reimbursement_id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursements [reimbursement_id=" + reimbursement_id + ", user_id=" + user_id + ", reason=" + reason
				+ ", amount=" + amount + ", status=" + status + "]";
	}

}
