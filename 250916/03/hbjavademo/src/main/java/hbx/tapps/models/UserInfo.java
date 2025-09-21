package hbx.tapps.models;

import hbx.tapps.core.IModelInfo;

public final class UserInfo implements IModelInfo {
    public UserInfo(String rawid, String email, String name) {
        _rawid = rawid;
        _email = email;
        _name = name;
    }

    private String _rawid;
    public String get_rawid() {
        return _rawid;
    }

    private String _email;
    public String get_email() {
        return _email;
    }

    private String _name;
    public String get_name() {
        return _name;
    }
}
