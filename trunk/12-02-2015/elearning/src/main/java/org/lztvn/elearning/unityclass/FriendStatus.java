package org.lztvn.elearning.unityclass;

public enum FriendStatus {
	/*active, passive*/
	NOT_ADD(1), ADD_NOT_CHECK(2), ADD_CHECK(3), FRIEND(4),P_FRIEND(-4),P_ADD_CHECK(-3),P_ADD_NOT_CHECK(-2),P_ADD(-1);
	
	public int getValue() {
		return value;
	}
	private int value;
	
	FriendStatus(int value) {
       this.value = value;
    }
}
