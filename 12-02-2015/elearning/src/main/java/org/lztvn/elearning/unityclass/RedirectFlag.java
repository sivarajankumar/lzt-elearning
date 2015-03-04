package org.lztvn.elearning.unityclass;

public enum RedirectFlag {
	ISREDIRECT(-1);
	public int getValue() {
		return value;
	}
	private int value;

	RedirectFlag(int value) {
       this.value = value;
    }
}
