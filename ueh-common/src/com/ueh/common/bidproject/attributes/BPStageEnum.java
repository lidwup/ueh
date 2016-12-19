package com.ueh.common.bidproject.attributes;

public enum BPStageEnum {

	TD { 
		public String getCode() { 
			return "TD";
		} 
		public String getName() { 
			return "招标";
		}
	},BD { 
		public String getCode() { 
			return "BD";
		}
 
		public String getName() { 
			return "投标";
		}
	},BO { 
		public String getCode() { 
			return "BO";
		}
 
		public String getName() { 
			return "开标";
		}
	},BE { 
		public String getCode() { 
			return "BE";
		}
 
		public String getName() { 
			return "评标";
		}
	},BC { 
		public String getCode() { 
			return "BC";
		}
 
		public String getName() { 
			return "定标";
		}
	},FIN { 
		public String getCode() { 
			return "FIN";
		}
 
		public String getName() { 
			return "结束";
		}
	},BRFORE_BE { 
		public String getCode() { 
			return "BRFORE_BE";
		}
 
		public String getName() { 
			return "评标准备";
		}
	};
	 
	
	public abstract String  getCode();
	public abstract String  getName();
}
