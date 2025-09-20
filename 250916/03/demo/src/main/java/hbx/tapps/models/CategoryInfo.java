package hbx.tapps.models;

import hbx.tapps.hbx.tapps.core.IModelInfo;

public final class CategoryInfo implements IModelInfo {
    public CategoryInfo(String rawid, String type, String name) {
        _rawid = rawid;
        _type = type;
        _name = name;
    }

    private String _rawid;
    public String get_rawid() {
        return _rawid;
    }

    private String _type;
    public String get_type() {
        return _type;
    }

    private String _name;
    public String get_name() {
        return _name;
    }
}
