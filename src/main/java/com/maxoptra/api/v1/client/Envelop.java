package com.maxoptra.api.v1.client;

import java.util.Arrays;

public class Envelop {

	        private int[] rows;
	        private int total;
	        private boolean success;
	        private int[] errors;
	        private int[] warnings;
	        private int[] infos;
	        private int ordersCount;
	        
			public int[] getRows() {
				return rows;
			}
			public void setRows(int[] rows) {
				this.rows = rows;
			}
			public int getTotal() {
				return total;
			}
			public void setTotal(int total) {
				this.total = total;
			}
			public boolean isSuccess() {
				return success;
			}
			public void setSuccess(boolean success) {
				this.success = success;
			}
			public int[] getErrors() {
				return errors;
			}
			public void setErrors(int[] errors) {
				this.errors = errors;
			}
			public int[] getWarnings() {
				return warnings;
			}
			public void setWarnings(int[] warnings) {
				this.warnings = warnings;
			}
			public int[] getInfos() {
				return infos;
			}
			public void setInfos(int[] infos) {
				this.infos = infos;
			}
			public int getOrdersCount() {
				return ordersCount;
			}
			public void setOrdersCount(int ordersCount) {
				this.ordersCount = ordersCount;
			}
			
			@Override
			public String toString() {
				return "Envelop [rows=" + Arrays.toString(rows) + ", total="
						+ total + ", success=" + success + ", errors="
						+ Arrays.toString(errors) + ", warnings="
						+ Arrays.toString(warnings) + ", infos="
						+ Arrays.toString(infos) + ", ordersCount="
						+ ordersCount + "]";
			}
			
			
}
