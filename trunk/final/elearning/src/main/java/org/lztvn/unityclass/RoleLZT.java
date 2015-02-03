package org.lztvn.unityclass;

public enum RoleLZT {
	Admin(5), Teacher(4), Student(3), User(2), NonUser(1);
	public int getValue() {
		return value;
	}
	private int value;

    RoleLZT(int value) {
            this.value = value;
    }
};
