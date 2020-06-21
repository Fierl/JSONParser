package model;

public class AvatarUrl {
	String _16x16;
	String _24x24;
	String _36x36;
	String _48x48;
	
	public AvatarUrl(String _16x16, String _24x24, String _36x36, String _48x48) {
		this._16x16 = _16x16;
		this._24x24 = _24x24;
		this._36x36 = _36x36;
		this._48x48 = _48x48;
	}
	
	public String get16x16() {
		return _16x16;
	}

	public void set16x16(String _16x16) {
		this._16x16 = _16x16;
	}

	public String get24x24() {
		return _24x24;
	}

	public void set24x24(String _24x24) {
		this._24x24 = _24x24;
	}

	public String get36x36() {
		return _36x36;
	}

	public void set36x36(String _36x36) {
		this._36x36 = _36x36;
	}

	public String get48x48() {
		return _48x48;
	}

	public void set48x48(String _48x48) {
		this._48x48 = _48x48;
	}
}
