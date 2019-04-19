package com.sa.net.DB;

import java.sql.Time;

/**
 * created by lyx on 2019/4/14
 */
public class Order {
        private String classRoom;
        private String user;
		private Time startTime;
        private Time endTime;
        private boolean used;
        private String remark;

        public Order(String c,String u,Time s,Time e,boolean us,String r)
        {
            this.setClassRoom(c);
            this.user=u;
            this.startTime=s;
            this.endTime=e;
            this.used=us;
            this.remark=r;
        }

		public String getClassRoom() {
			return classRoom;
		}

		public void setClassRoom(String classRoom) {
			this.classRoom = classRoom;
		}

        public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public Time getStartTime() {
			return startTime;
		}

		public void setStartTime(Time startTime) {
			this.startTime = startTime;
		}

		public Time getEndTime() {
			return endTime;
		}

		public void setEndTime(Time endTime) {
			this.endTime = endTime;
		}

		public boolean isUsed() {
			return used;
		}

		public void setUsed(boolean used) {
			this.used = used;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}
  
}
